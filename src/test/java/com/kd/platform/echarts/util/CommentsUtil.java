package com.kd.platform.echarts.util;

import java.io.*;

/**
 * <b>Application name:</b> CommentsUtil.java <br>
 * <b>Application describing:自动生成链式调用方法 - 仅针对本项目之前的代码 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CommentsUtil {
    public static final String[] EMPTY = new String[0];

    public static void main(String[] args) {
        // 输出全部类
        // String srcPath = ChainUtil.getSrcPath();
        // File srcFoler = new File(srcPath);
        // List<File> files = ChainUtil.allFiles(srcFoler);
        // for (File file : files) {
        // commentsFile(file);
        // }
        commentsFile(new File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\EventRiver.java"));
        commentsFile(new File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\event\\Detail.java"));
        commentsFile(new File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\event\\Event.java"));
        commentsFile(new File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\event\\Evolution.java"));
    }

    public static void commentsFile(File file) {
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            String className = file.getName();
            className = className.substring(0, className.lastIndexOf("."));
            String prevLine = null;
            while ((line = reader.readLine()) != null) {
                String tempLline = line;
                if (tempLline.contains("private") || tempLline.contains("public") || tempLline.contains("protected")) {
                    if (prevLine == null || !prevLine.contains("*")) {
                        if (tempLline.contains("(") && tempLline.contains(")")) {
                            // 分解参数
                            tempLline = tempLline.trim();
                            String[] ps = getParameter(tempLline);
                            if (ps == EMPTY) {
                                if (isConstructor(tempLline)) {
                                    sb.append("\t/**\n\t * 构造函数 \n");
                                } else {
                                    sb.append("\t/**\n\t * 获取" + getMethodFieldName(tempLline) + "值 \n");
                                }
                            } else {
                                String v = "";
                                for (String p : ps) {
                                    if (!v.equals("")) {
                                        v += ",";
                                    }
                                    v += p;
                                }
                                if (isConstructor(tempLline)) {
                                    sb.append("\t/**\n\t * 构造函数,参数:" + v + " \n\t * \n");
                                } else {
                                    sb.append("\t/**\n\t * 设置" + v + "值 \n\t * \n");
                                }
                                for (String s : ps) {

                                    sb.append("\t * @param " + s + "\n");
                                }
                            }
                            sb.append("\t */\n");
                            tempLline = "\t" + tempLline;
                        }
                    }
                }
                sb.append(tempLline + "\n");
                prevLine = tempLline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isConstructor(String line) {
        line = line.substring(0, line.indexOf("(")).trim();
        if (line.split(" ").length == 2) {
            return true;
        }
        return false;
    }

    public static String getMethodFieldName(String line) {
        int end = line.lastIndexOf("(");
        int start = line.lastIndexOf(" ", end);
        String name = line.substring(start + 1, end);
        if (name.startsWith("get")) {
            name = name.substring(3);
            name = name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        return name;
    }

    public static String[] getParameter(String line) {
        if (line.contains("(") && line.contains(")")) {
            // 分解参数
            String all = line.substring(line.indexOf("(") + 1, line.lastIndexOf(")"));
            if (all.equals("")) {
                return EMPTY;
            }
            while (all.contains("<")) {
                int start = all.indexOf("<");
                int end = all.indexOf(">", start);
                all = all.substring(0, start) + all.substring(end + 1);
            }
            String[] alls = all.split(",");
            String[] parameters = new String[alls.length];
            System.out.println("All:" + all);
            for (int i = 0; i < alls.length; i++) {
                System.out.println("\t" + alls[i]);
                parameters[i] = alls[i].trim().split(" ")[1].trim();
            }
            return parameters;
        }
        return EMPTY;
    }
}
