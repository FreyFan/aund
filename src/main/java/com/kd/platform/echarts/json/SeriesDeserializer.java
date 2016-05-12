package com.kd.platform.echarts.json;

import com.google.gson.*;
import com.kd.platform.echarts.code.SeriesType;
import com.kd.platform.echarts.series.*;

import java.lang.reflect.Type;

/**
 * <b>Application name:</b> SeriesDeserializer.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class SeriesDeserializer implements JsonDeserializer<Series> {

    /**
     * 设置json,typeOfT,context值
     * @param json
     * @param typeOfT
     * @param context
     */
    public Series deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        String _type = jsonObject.get("type").getAsString();
        SeriesType type = SeriesType.valueOf(_type);
        Series series = null;
        switch (type) {
        case line:
            series = context.deserialize(jsonObject, Line.class);
            break;
        case bar:
            series = context.deserialize(jsonObject, Bar.class);
            break;
        case scatter:
            series = context.deserialize(jsonObject, Scatter.class);
            break;
        case funnel:
            series = context.deserialize(jsonObject, Funnel.class);
            break;
        case pie:
            series = context.deserialize(jsonObject, Pie.class);
            break;
        case force:
            series = context.deserialize(jsonObject, Force.class);
            break;
        case gauge:
            series = context.deserialize(jsonObject, Gauge.class);
            break;
        case map:
            series = context.deserialize(jsonObject, Map.class);
            break;
        case island:
            series = context.deserialize(jsonObject, Island.class);
            break;
        case k:
            series = context.deserialize(jsonObject, K.class);
            break;
        case radar:
            series = context.deserialize(jsonObject, Radar.class);
            break;
        case chord:
            series = context.deserialize(jsonObject, Chord.class);
            break;
        }
        return series;
    }
}
