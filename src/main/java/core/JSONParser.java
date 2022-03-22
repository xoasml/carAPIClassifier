package core;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


public class JSONParser {

    public static void parseJobData(){
        // 1. JSON 문자열 입력
        String JsonStr = inputData();

        // 2. 입력 받은 Json규격의 String으로 JSONObject 생성
        JSONObject JsonObj = makeJsonObj(JsonStr);

        // 3. JSONObject로 데이터의 필요 정보 정리
        makeInfo(JsonObj);

    }

    // JSON 문자열 입력
    static String inputData() {
        System.out.println("JSON 문자열 복붙 하세요, \"v\"를 구분자로 종료 됩니다. : ");
        String str = "";
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                str = br.readLine();
                if(str.charAt(str.length() - 1) == 'v' || str.charAt(str.length() - 1) == 'ㅍ'){
                    if(str.indexOf('}') > -1){
                        result += "}";
                    }
                    break;
                }
                result += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Json규격의 String으로 JSONObject 생성
    static JSONObject makeJsonObj(String JsonStr){

        JSONObject result = null;
        try {
            result = new JSONObject(JsonStr);
        } catch (JSONException e) {
            System.out.println(e.toString());
        }

        return  result;
    }

    // JSONObject로 데이터의 필요 정보 정리
    static void makeInfo(JSONObject JsonObj){
        JSONObject jsonObjData = JsonObj.getJSONObject("data");

        // 3-1 차량의 옵션이 몇개인지 구한다
        String optCnt = getOptCnt(jsonObjData);
        // 3-2 차량 이미지 데이터 유무 확인
        String imageYn = getImageYn(jsonObjData);
        // 3-3 데이터 상태 코드 구하기
        String stCode = getStCode(jsonObjData);

        System.out.println(optCnt + "\t" + imageYn + "\t" + stCode);
    }

    // 차량의 옵션이 몇개인지 구한다
    static String getOptCnt(JSONObject jsonObjData){
        String options = jsonObjData.get("options").toString();
        int optCnt = (options.length() - options.replaceAll("\"", "").length()) / 2;

        return optCnt + "";
    }

    // 차량 이미지 데이터 유무 확인
    static String getImageYn(JSONObject jsonObjData){
        String images = jsonObjData.get("images").toString();
        String imageYn = "";

        // images의 값이 null이면 N, 아니면 Y
        if(images.equals("null")){
            imageYn = "N";
        } else {
            imageYn = "Y";
        }

        return imageYn;
    }

    // 데이터 상태 코드 구하기
    static String getStCode(JSONObject jsonObjData){
        String biCode = "";

        //3-3-1 base_data change binary format
        biCode += biFormater("base_data", jsonObjData);
        //3-3-2 price change binary format
        biCode += biFormater("price", jsonObjData);
        //3-3-3 details change binary format
        biCode += biFormater("details", jsonObjData);

        return choiceCode(biCode);
    }

    // change binary formater
    static String biFormater(String targetName, JSONObject jsonObjData){
        String result = "";
        JSONObject targetObj = jsonObjData.getJSONObject(targetName);

        //JsonObject의 순서가 맞지 않아 따로 맞춰주는 작업이 필요함
        List<String> targetKeyList = StandardizeJson.standardizer(targetName);

        for (int i = 0 ; i < targetObj.length() ; i++) {
            if(targetObj.get(targetKeyList.get(i)).toString().equals("null")){
                result += "0";
            } else {
                result += "1";
            }
        }
        return result;
    }

    static String choiceCode(String biCode) {
        String result = "";

        Map<String, String> codeStorage = StCodeStorage.codeStorage();

        if(codeStorage.get(biCode) == null){
            System.err.println("처음보는 유형의 이진수 코드임");
            System.err.println(biCode);
        } else {
            result = codeStorage.get(biCode);
        }
        return result;
    }

}
