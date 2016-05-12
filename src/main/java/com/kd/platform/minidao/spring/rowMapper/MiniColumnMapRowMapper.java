package com.kd.platform.minidao.spring.rowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import com.kd.platform.minidao.spring.map.MiniDaoLinkedMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * <b>Application name:</b> MiniColumnMapRowMapper.java <br>
 * <b>Application describing: 使用小写的key 作为map的关键字 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniColumnMapRowMapper implements RowMapper<Map<String, Object>> {
    protected Map<String, Object> createColumnMap(int columnCount) {
        return new MiniDaoLinkedMap(columnCount);
    }

    protected String getColumnKey(String columnName) {
        return columnName;
    }

    protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
        return JdbcUtils.getResultSetValue(rs, index);
    }

    public Map<String, Object> mapRow(ResultSet resultset, int rowNum) throws SQLException {
        ResultSetMetaData rsmd = resultset.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Map mapOfColValues = createColumnMap(columnCount);
        for (int i = 1; i <= columnCount; i++) {
            String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
            Object obj = getColumnValue(resultset, i);
            mapOfColValues.put(key, obj);
        }

        return mapOfColValues;
    }
}
