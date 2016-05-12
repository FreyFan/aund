package com.kd.platform.echarts.json;

import com.google.gson.*;
import com.kd.platform.echarts.axis.Axis;
import com.kd.platform.echarts.axis.CategoryAxis;
import com.kd.platform.echarts.axis.TimeAxis;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.AxisType;

import java.lang.reflect.Type;

/**
 * <b>Application name:</b> AxisDeserializer.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class AxisDeserializer implements JsonDeserializer<Axis> {

    /**
     * 设置json,typeOfT,context值
     * @param json
     * @param typeOfT
     * @param context
     */
    public Axis deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        String _type = jsonObject.get("type").getAsString();
        AxisType type = AxisType.valueOf(_type);
        Axis axis = null;
        switch (type) {
        case category:
            axis = context.deserialize(jsonObject, CategoryAxis.class);
            break;
        case value:
            axis = context.deserialize(jsonObject, ValueAxis.class);
            break;
        case time:
            axis = context.deserialize(jsonObject, TimeAxis.class);
            break;
        }
        return axis;
    }
}
