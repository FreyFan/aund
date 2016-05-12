package com.kd.mina.udp.vender.ikecin;

import com.kd.platform.core.common.model.json.AjaxJson;
import org.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fanchengwei on 15/12/25.
 */
public class Test {
    public static void main(String args[]){
        int[] aa = new int[]{1,2,3,4,5};
        int[] bb = new int[2];
        bb[0] = 1;
        bb[1] = 2;
        function(bb);

    }
    public static void function (int... is ){
        int sum = 0;
        for (int i = 0; i < is.length; i++) {
            System.out.print(is[i]+" ");
            sum += is[i];

        }
        System.out.println("\nSUM is :"+sum);
    }
}
