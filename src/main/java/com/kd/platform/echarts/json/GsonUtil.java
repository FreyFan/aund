package com.kd.platform.echarts.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kd.platform.echarts.Option;
import com.kd.platform.echarts.axis.Axis;
import com.kd.platform.echarts.series.Series;

/**
 * <b>Application name:</b> GsonUtil.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class GsonUtil {

    /**
     * 格式化对象为Json
     * @param object
     * @return
     */
    public static String format(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(gson.toJson(object));
        String prettyJsonString = gson.toJson(je);
        // 简单处理function
        String[] lines = prettyJsonString.split("\n");
        lines = replaceFunctionQuote(lines);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    /**
     * 格式化对象为Json
     * @param object
     * @return
     */
    public static String prettyFormat(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(gson.toJson(object));
        String prettyJsonString = gson.toJson(je);
        // 简单处理function
        String[] lines = prettyJsonString.split("\n");
        lines = replaceFunctionQuote(lines);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line + "\n");
        }
        return stringBuilder.toString();
    }

    /**
     * 处理字符串中的function和(function(){})()，除{}中的代码外，其他地方不允许有空格
     * @param lines
     * @return
     */
    public static String[] replaceFunctionQuote(String[] lines) {
        boolean function = false;
        boolean immediately = false;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (!function && line.contains("\"function")) {
                function = true;
                line = line.replaceAll("\"function", "function");
            }
            if (function && line.contains("}\"")) {
                function = false;
                line = line.replaceAll("\\}\"", "\\}");
            }

            if (!immediately && line.contains("\"(function")) {
                immediately = true;
                line = line.replaceAll("\"\\(function", "\\(function");
            }
            if (immediately && line.contains("})()\"")) {
                immediately = false;
                line = line.replaceAll("\\}\\)\\(\\)\"", "\\}\\)\\(\\)");
            }
            lines[i] = line;
        }
        return lines;
    }

    /**
     * 反序列化
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T extends Option> T fromJSON(String json, Class<T> type) {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Series.class, new SeriesDeserializer()).registerTypeAdapter(Axis.class, new AxisDeserializer()).create();
        return gson.fromJson(json, type);
    }

    /**
     * 反序列化
     * @param json
     * @return
     */
    public static Option fromJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Series.class, new SeriesDeserializer()).registerTypeAdapter(Axis.class, new AxisDeserializer()).create();
        Option option = gson.fromJson(json, Option.class);
        return option;
    }

    /**
     * 输出Json
     * @param object
     * @return
     */
    public static void print(Object object) {
        System.out.println(format(object));
    }

    /**
     * 输出Json
     * @param object
     * @return
     */
    public static void printPretty(Object object) {
        System.out.println(prettyFormat(object));
    }

}
