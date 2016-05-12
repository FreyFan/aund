package com.kd.platform.minidao.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import com.kd.platform.minidao.annotation.Arguments;
import com.kd.platform.minidao.annotation.ResultType;
import com.kd.platform.minidao.annotation.Sql;
import com.kd.platform.minidao.hibernate.dao.IGenericBaseCommonDao;
import com.kd.platform.minidao.pojo.MiniDaoPage;
import com.kd.platform.minidao.spring.rowMapper.MiniColumnMapRowMapper;
import com.kd.platform.minidao.spring.rowMapper.MiniColumnOriginalMapRowMapper;
import com.kd.platform.minidao.util.FreemarkerParseFactory;
import com.kd.platform.minidao.util.MiniDaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * <b>Application name:</b> MiniDaoHandler.java <br>
 * <b>Application describing:MiniDAO 拦截器 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoHandler implements InvocationHandler {
    private static final Logger logger = Logger.getLogger(MiniDaoHandler.class);

    private static final BasicFormatterImpl formatter = new BasicFormatterImpl();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private IGenericBaseCommonDao miniDaoHiberCommonDao;

    private String UPPER_KEY = "upper";

    private String LOWER_KEY = "lower";

    private String keyType = "origin";

    private boolean formatSql = false;

    private boolean showSql = false;

    private String dbType;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnObj = null;

        String templateSql = null;

        Map sqlParamsMap = new HashMap();

        MiniDaoPage pageSetting = new MiniDaoPage();

        Map rs = new HashMap();
        if (miniDaoHiber(rs, method, args)) {
            return rs.get("returnObj");
        }

        templateSql = installDaoMetaData(pageSetting, method, sqlParamsMap, args);

        String executeSql = parseSqlTemplate(method, templateSql, sqlParamsMap);

        Map sqlMap = installPlaceholderSqlParam(executeSql, sqlParamsMap);
        try {
            returnObj = getReturnMinidaoResult(this.dbType, pageSetting, method, executeSql, sqlMap);
        } catch (EmptyResultDataAccessException e) {
            returnObj = null;
        }
        if (this.showSql) {
            logger.info("MiniDao-SQL:\n\n" + (this.formatSql ? formatter.format(executeSql) : executeSql) + "\n");
        }
        return returnObj;
    }

    private static boolean checkActiveKey(String methodName) {
        String[] keys = "insert,add,create,update,modify,store,delete,remove".split(",");
        for (String s : keys) {
            if (methodName.startsWith(s)) return true;
        }
        return false;
    }

    private static boolean checkBatchKey(String methodName) {
        String[] keys = "batch".split(",");
        for (String s : keys) {
            if (methodName.startsWith(s)) return true;
        }
        return false;
    }

    private void addResulArray(int[] result, int index, int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++)
            result[(index - length + i)] = arr[i];
    }

    private int[] batchUpdate(String executeSql) {
        String[] sqls = executeSql.split(";");
        if (sqls.length < 100) {
            return this.jdbcTemplate.batchUpdate(sqls);
        }
        int[] result = new int[sqls.length];
        List sqlList = new ArrayList();
        for (int i = 0; i < sqls.length; i++) {
            sqlList.add(sqls[i]);
            if (i % 100 == 0) {
                addResulArray(result, i + 1, this.jdbcTemplate.batchUpdate((String[]) sqlList.toArray(new String[0])));
                sqlList.clear();
            }
        }
        addResulArray(result, sqls.length, this.jdbcTemplate.batchUpdate((String[]) sqlList.toArray(new String[0])));
        return result;
    }

    private RowMapper<Map<String, Object>> getColumnMapRowMapper() {
        if (getKeyType().equalsIgnoreCase(this.LOWER_KEY)) return new MiniColumnMapRowMapper();
        if (getKeyType().equalsIgnoreCase(this.UPPER_KEY)) {
            return new ColumnMapRowMapper();
        }
        return new MiniColumnOriginalMapRowMapper();
    }

    private String getCountSql(String sql) {
        return "select count(0) from (" + sql + ") tmp_count";
    }

    public String getDbType() {
        return this.dbType;
    }

    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public IGenericBaseCommonDao getMiniDaoHiberCommonDao() {
        return this.miniDaoHiberCommonDao;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return this.namedParameterJdbcTemplate;
    }

    private Object getReturnMinidaoResult(String dbType, MiniDaoPage pageSetting, Method method, String executeSql, Map<String, Object> paramMap) {
        String methodName = method.getName();

        if (checkActiveKey(methodName)) {
            if (paramMap != null) {
                return Integer.valueOf(this.namedParameterJdbcTemplate.update(executeSql, paramMap));
            }
            return Integer.valueOf(this.jdbcTemplate.update(executeSql));
        }
        if (checkBatchKey(methodName)) {
            return batchUpdate(executeSql);
        }

        Class returnType = method.getReturnType();
        if (returnType.isPrimitive()) {
            Number number = (Number) this.jdbcTemplate.queryForObject(executeSql, BigDecimal.class);

            if ("int".equals(returnType.getCanonicalName())) return Integer.valueOf(number.intValue());
            if ("long".equals(returnType.getCanonicalName())) return Long.valueOf(number.longValue());
            if ("double".equals(returnType.getCanonicalName())) return Double.valueOf(number.doubleValue());
        } else {
            if ((returnType.isAssignableFrom(List.class)) || (returnType.isAssignableFrom(MiniDaoPage.class))) {
                int page = pageSetting.getPage();
                int rows = pageSetting.getRows();
                if ((page != 0) && (rows != 0)) {
                    if (returnType.isAssignableFrom(MiniDaoPage.class)) {
                        if (paramMap != null)
                            pageSetting.setTotal(((Integer) this.namedParameterJdbcTemplate.queryForObject(getCountSql(executeSql), paramMap, Integer.class)).intValue());
                        else {
                            pageSetting.setTotal(((Integer) this.jdbcTemplate.queryForObject(getCountSql(executeSql), Integer.class)).intValue());
                        }
                    }
                    executeSql = MiniDaoUtil.createPageSql(dbType, executeSql, page, rows);
                }

                RowMapper resultType = getListRealType(method);
                List list = new ArrayList();
                if (paramMap != null)
                    list = this.namedParameterJdbcTemplate.query(executeSql, paramMap, resultType);
                else {
                    list = this.jdbcTemplate.query(executeSql, resultType);
                }
                if (returnType.isAssignableFrom(MiniDaoPage.class)) {
                    pageSetting.setResults(list);
                    return pageSetting;
                }
                return list;
            }
            if (returnType.isAssignableFrom(Map.class)) {
                if (paramMap != null) {
                    return this.namedParameterJdbcTemplate.queryForObject(executeSql, paramMap, getColumnMapRowMapper());
                }
                return this.jdbcTemplate.queryForObject(executeSql, getColumnMapRowMapper());
            }
            if (returnType.isAssignableFrom(String.class)) {
                if (paramMap != null) {
                    return this.namedParameterJdbcTemplate.queryForObject(executeSql, paramMap, String.class);
                }
                return this.jdbcTemplate.queryForObject(executeSql, String.class);
            }
            if (MiniDaoUtil.isWrapClass(returnType)) {
                if (paramMap != null) {
                    return this.namedParameterJdbcTemplate.queryForObject(executeSql, paramMap, returnType);
                }
                return this.jdbcTemplate.queryForObject(executeSql, returnType);
            }

            RowMapper rm = ParameterizedBeanPropertyRowMapper.newInstance(returnType);
            if (paramMap != null) {
                return this.namedParameterJdbcTemplate.queryForObject(executeSql, paramMap, rm);
            }
            return this.jdbcTemplate.queryForObject(executeSql, rm);
        }

        return null;
    }

    private RowMapper<?> getListRealType(Method method) {
        ResultType resultType = (ResultType) method.getAnnotation(ResultType.class);
        if (resultType != null) {
            if (resultType.value().equals(Map.class)) {
                return getColumnMapRowMapper();
            }
            return ParameterizedBeanPropertyRowMapper.newInstance(resultType.value());
        }
        String genericReturnType = method.getGenericReturnType().toString();
        String realType = genericReturnType.replace("java.util.List", "").replace("<", "").replace(">", "");
        if (realType.contains("java.util.Map")) return getColumnMapRowMapper();
        if (realType.length() > 0) {
            try {
                return ParameterizedBeanPropertyRowMapper.newInstance(Class.forName(realType));
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage(), e.fillInStackTrace());
                throw new RuntimeException("minidao get class error ,class name is:" + realType);
            }
        }
        return getColumnMapRowMapper();
    }

    private String installDaoMetaData(MiniDaoPage pageSetting, Method method, Map<String, Object> sqlParamsMap, Object[] args) throws Exception {
        String templateSql = null;

        boolean arguments_flag = method.isAnnotationPresent(Arguments.class);
        if (arguments_flag) {
            Arguments arguments = (Arguments) method.getAnnotation(Arguments.class);
            logger.debug("@Arguments------------------------------------------" + Arrays.toString(arguments.value()));
            if (arguments.value().length > args.length) {
                throw new Exception("[注释标签]参数数目，不能大于[方法参数]参数数目");
            }

            int args_num = 0;
            for (String v : arguments.value()) {
                if (v.equalsIgnoreCase("page")) {
                    pageSetting.setPage(Integer.parseInt(args[args_num].toString()));
                }
                if (v.equalsIgnoreCase("rows")) {
                    pageSetting.setRows(Integer.parseInt(args[args_num].toString()));
                }

                sqlParamsMap.put(v, args[args_num]);
                args_num++;
            }
        } else {
            if ((args != null) && (args.length > 1)) throw new Exception("方法参数数目>=2，方法必须使用注释标签@Arguments");
            if ((args != null) && (args.length == 1)) {
                sqlParamsMap.put("dto", args[0]);
            }

        }

        if (method.isAnnotationPresent(Sql.class)) {
            Sql sql = (Sql) method.getAnnotation(Sql.class);

            if (StringUtils.isNotEmpty(sql.value())) {
                templateSql = sql.value();
            }
            logger.debug("@Sql------------------------------------------" + sql.value());
        }
        return templateSql;
    }

    private Map<String, Object> installPlaceholderSqlParam(String executeSql, Map sqlParamsMap) throws OgnlException {
        Map map = new HashMap();
        String regEx = ":[ tnx0Bfr]*[0-9a-z.A-Z]+";
        Pattern pat = Pattern.compile(regEx);
        Matcher m = pat.matcher(executeSql);
        while (m.find()) {
            logger.debug(" Match [" + m.group() + "] at positions " + m.start() + "-" + (m.end() - 1));
            String ognl_key = m.group().replace(":", "").trim();
            map.put(ognl_key, Ognl.getValue(ognl_key, sqlParamsMap));
        }
        return map;
    }

    public boolean isFormatSql() {
        return this.formatSql;
    }

    private boolean miniDaoHiber(Map rs, Method method, Object[] args) {
        if ("saveByHiber".equals(method.getName())) {
            this.miniDaoHiberCommonDao.save(args[0]);
            return true;
        }
        if ("getByIdHiber".equals(method.getName())) {
            Class clz = (Class) args[0];
            rs.put("returnObj", this.miniDaoHiberCommonDao.get(clz, args[1].toString()));
            return true;
        }
        if ("getByEntityHiber".equals(method.getName())) {
            rs.put("returnObj", this.miniDaoHiberCommonDao.get(args[0]));
            return true;
        }
        if ("updateByHiber".equals(method.getName())) {
            this.miniDaoHiberCommonDao.saveOrUpdate(args[0]);
            return true;
        }
        if ("deleteByHiber".equals(method.getName())) {
            this.miniDaoHiberCommonDao.delete(args[0]);
            return true;
        }
        if ("deleteByIdHiber".equals(method.getName())) {
            Class clz = (Class) args[0];
            this.miniDaoHiberCommonDao.deleteEntityById(clz, args[1].toString());
            return true;
        }
        if ("listByHiber".equals(method.getName())) {
            rs.put("returnObj", this.miniDaoHiberCommonDao.loadAll(args[0]));
            return true;
        }
        return false;
    }

    private String parseSqlTemplate(Method method, String templateSql, Map<String, Object> sqlParamsMap) {
        String executeSql = null;

        if (StringUtils.isNotEmpty(templateSql)) {
            executeSql = FreemarkerParseFactory.parseTemplateContent(templateSql, sqlParamsMap);
        } else {
            String sqlTempletPath = method.getDeclaringClass().getName().replace(".", "/").replace("/dao/", "/sql/") + "_" + method.getName() + ".sql";
            if (!FreemarkerParseFactory.isExistTemplate(sqlTempletPath)) {
                sqlTempletPath = method.getDeclaringClass().getName().replace(".", "/") + "_" + method.getName() + ".sql";
            }
            logger.debug("MiniDao-SQL-Path:" + sqlTempletPath);
            executeSql = FreemarkerParseFactory.parseTemplate(sqlTempletPath, sqlParamsMap);
        }
        return executeSql;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public void setFormatSql(boolean formatSql) {
        this.formatSql = formatSql;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }
}
