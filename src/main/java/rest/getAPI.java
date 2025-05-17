package rest;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class getAPI {

    @Step
    public static Response testGetApi (){
        String url = "https://reqres.in/api/users?page=2";
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put("X-API-Key", "regres-free-v1");
        headers.put("Content-Type", "application/json");
        return given().headers(headers).when().get(url);
    }
}
