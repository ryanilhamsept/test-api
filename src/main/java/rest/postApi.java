package rest;

import commons.Util;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class postApi {

    @Step
    public static Response testpostApi (String name, String job){
        String url = "https://reqres.in/api/users";
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("X-API-Key", "regres-free-v1");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("name", name);
        body.put("job", job);
        String json = Util.mapToJson(body);
        return given().headers(headers).body(json).when().post(url);
    }

    @Step
    public static Response testpostApi2 (String title, String body, Integer userId){
        String url = "https://jsonplaceholder.typicode.com/posts";
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("Content-Type", "application/json");
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("title",title);
        params.put("body",body);
        params.put("userId",userId);
        params.values().removeAll(Collections.singleton(null));
        String json = Util.mapToJson(params);
        return given().headers(headers).body(json).when().post(url);
    }

}
