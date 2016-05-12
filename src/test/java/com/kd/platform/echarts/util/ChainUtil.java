package com.kd.platform.echarts.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Application name:</b> ChainUtil.java <br>
 * <b>Application describing: 自动生成链式调用方法 - 仅针对本项目之前的代码</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ChainUtil {
    public static void main(String[] args) {
        // 输出全部类
        // String srcPath = getSrcPath();
        // File srcFoler = new File(srcPath);
        // List<File> all = allFiles(srcFoler);
        // for (File file : all) {
        // chainFile(file);
        // }
        chainFile(new File("G:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\RoamController.java"));
    }

    public static void chainFile(File file) {
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            String className = file.getName();
            className = className.substring(0, className.lastIndexOf("."));
            while ((line = reader.readLine()) != null) {
                String tempLline = line.trim();
                if (tempLline.startsWith("public") && tempLline.endsWith(";")) {
                    // 去分号
                    tempLline = tempLline.substring(0, tempLline.length() - 1);
                    String[] strs = tempLline.split(" ");
                    if (strs.length != 3) {
                        sb.append(line).append("\n");
                        continue;
                    }
                    // 链式
                    sb.append("\tprivate " + strs[1] + " " + strs[2] + ";\n\n");
                    sb.append("\tpublic " + strs[1] + " " + strs[2] + "(){\n");
                    sb.append("\t\treturn this." + strs[2] + ";\n\t}\n\n");
                    sb.append("\tpublic " + className + " " + strs[2] + "(" + strs[1] + " " + strs[2] + "){\n");
                    sb.append("\t\tthis." + strs[2] + " = " + strs[2] + ";\n");
                    sb.append("\t\treturn this;\n\t}\n");
                } else {
                    sb.append(line).append("\n");
                }
            }
            // System.out.println(sb.toString());
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

    public static List<File> allFiles(File file) {
        List<File> result = new ArrayList<File>();
        if (file.isFile()) {
            result.add(file);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    if (dir.isDirectory()) {
                        return true;
                    } else if (name.toUpperCase().endsWith(".JAVA")) {
                        return true;
                    }
                    return false;
                }
            });
            for (File f : files) {
                result.addAll(allFiles(f));
            }
        }
        return result;
    }

    public static String getSrcPath() {
        String basePath = getBasePath();
        return basePath + "src/main/java";
    }

    public static String getBasePath() {
        String path = ChainUtil.class.getResource("/").getPath();
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        if (path.indexOf("target1") > 0) {
            path = path.substring(0, path.indexOf("target"));
        } else if (path.indexOf("ECharts") > 0) {
            path = path.substring(0, path.indexOf("ECharts")) + "Echarts/";
        }
        return path;
    }
}
