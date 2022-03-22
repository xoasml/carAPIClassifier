package core;

import java.util.ArrayList;
import java.util.List;

public class StandardizeJson {

    public static List<String> standardizer(String targetName) {
        List<String> result = new ArrayList<>();

        if(targetName.equals("base_data")){
            result = baseDataKeys();
        }else if(targetName.equals("price")){
            result = priceDataKeys();
        }else if(targetName.equals("details")){
            result = detailsDataKeys();
        }

        return result;
    }

    static List<String> baseDataKeys() {
        List<String> result = new ArrayList<>();
        result.add("company_id");
        result.add("company_name");
        result.add("model_id");
        result.add("model_name");
        result.add("submodel_id");
        result.add("submodel_name");
        result.add("grade_id");
        result.add("grade_name");
        result.add("subgrade_id");
        result.add("subgrade_name");
        result.add("class_name");
        result.add("product_year");
        result.add("color");
        result.add("color_display");
        result.add("fuel");
        result.add("register_date");
        result.add("displacement");
        result.add("mission");
        return result;

    }

    static List<String> priceDataKeys() {
        List<String> result = new ArrayList<>();
        result.add("new");
        result.add("avg");
        result.add("high");
        result.add("low");
        result.add("year_1");
        result.add("year_2");
        result.add("year_3");
        return result;
    }

    static List<String> detailsDataKeys() {
        List<String> result = new ArrayList<>();
        result.add("배터리");
        result.add("바디");
        result.add("엔진");
        result.add("타이어");
        result.add("출력");
        result.add("휠");
        result.add("연료량");
        result.add("연료");
        result.add("미션");
        return result;
    }


}
