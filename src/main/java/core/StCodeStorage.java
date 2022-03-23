package core;

import java.util.HashMap;
import java.util.Map;

public class StCodeStorage {

    public static Map<String, String> codeStorage(){
        Map<String, String> result = new HashMap<>();

        result.put("1111111111111111111111111111111111", "0"); // 이상 없음(base_data, price, details의 모든 데이터 조회됨)

        result.put("1111111111110011111111111111111111", "101"); // base_data : color, color_display Null

        result.put("1111111111111111111111111110101111", "301"); // details : 엔진, 출력 null

        result.put("1111111111111111111111111000000011", "302"); // details : 연료, 미션 외 null

        result.put("1111111111111111111111111110100011", "303"); // details : 엔진, 출력, 휠, 연료량 null

        result.put("1111111111111111111111111010100011", "304"); // details : 배터리, 엔진, 출력, 휠, 연료량 null

        result.put("1111111111111111111111111011111011", "305"); // details : 배터리, 연료 null

        result.put("1111111111111111111111111111110111", "306"); // details : 휠 null

        result.put("1111111111111111111111111111101111", "307"); // details : 출력 null

        result.put("1111111111111111111111111010101011", "308"); //  details : 배터리, 엔진, 출력, 연료량 null

        result.put("1111111111110011111111111000000011", "401"); // base_data : color, color_display null - details : 연료, 미션 외 null

        result.put("1111111111111011111111111010011011", "402"); // base_data : color_display null - details : 배터리, 엔진, 타이어, 연료량 null

        result.put("1111111111111011111111111110110011", "403"); // base_data : color_display null - details : 엔진,  휠, 연료량 null

        result.put("1111111111110011111111111110010011", "404"); // "base_data : color, color_display null - details : 엔진, 타이어, 휠, 연료량 null"

        result.put("1111111111111111110000000000000011", "431"); // price : All null - details : 연료, 미션 외 null

        result.put("1111111111111111110000000110010011", "432"); // price : All null - details : 엔진, 타이어, 휠, 연료랑

        result.put("1111110000010011111000000000000011", "501"); // "base_data : grade_id, grade_name, subgrade_id, subgrade_name, class_name, color, color_display null - price : new 외 null - details : 연료, 미션 외 null

        result.put("1111110000010011110000000000000011", "502"); // "base_data : grade_id, grade_name, subgrade_id, subgrade_name, class_name, color, color_display null - price : All null - details : 연료, 미션 외 null"

        result.put("1111111111110011110000000000000011", "503"); //  "base_data : color, color_display null - price : All null -  details : 연료, 미션 외 null

        result.put("1111110000011111110000000000000011", "504"); // "base_data : grade_id, grade_name, subgrade_id, subgrade_name null - price : All null - details : 연료, 미션 외 null"

        result.put("1111110000011011110000000000000011", "505"); // "base_data : grade_id, grade_name, subgrade_id, subgrade_name, class_name, color null - price :  All null - details : 연료, 미션 외 null"

        result.put("1111110000011111111000000000000011", "506"); // "base_data : grade_id, grade_name, subgrade_id, subgrade_name null - price : new 외 null - details : 연료, 미션 외 null"

        result.put("1111110000110011111000000000000011", "507"); // base_data : grade_id, grade_name, subgrade_id, subgrade_name, color, color_display null - price : new 외 null - details : 연료, 미션 외 null

        result.put("1111111111111011110000000110010011", "508"); // "base_data : color_display null - price : All null - details : 엔진, 타이어, 휠, 연료량 null"




        return result;
    }
}
