package rest;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import commons.Util;
import org.testng.annotations.Test;
import org.openqa.selenium.json.Json;
import org.testng.Assert;

public class testPostApi {

    @Test
    public void postApi(){
        var name = new Faker().name().name().toString();
        var job = new Faker().job().toString();
        var Res = postApi.testpostApi(name,job);
        //Assert.assertEquals(Res.getStatusCode(),201);
        Assert.assertEquals(JsonPath.read(Res.asString(),"$.name"),name);
        Assert.assertEquals(JsonPath.read(Res.asString(),"$.job"),job);
        //Assert.assertEquals(JsonPath.read(Res.asString(),"$.job"),job);
        System.out.println(Res.asString());

    }

    @Test
    public void postApi2(){
        var title = new Faker().name().name().toString();
        var body = new Faker().address().fullAddress().toString();
        var number = Util.generateRandomNumericStringA(String.valueOf(1),4);
        var Res = postApi.testpostApi2(title, body, Integer.valueOf(number));
        Assert.assertEquals(Res.getStatusCode(),201);
        Assert.assertEquals(JsonPath.read(Res.asString(),"$.title"), title);
        Assert.assertEquals(JsonPath.read(Res.asString(),"$.body"), body);
        Assert.assertEquals(JsonPath.read(Res.asString(),"$.userId"), Integer.valueOf(number));
        Assert.assertNotNull(JsonPath.read(Res.asString(),"$.id"));
        System.out.println(Res.asString());

    }
}
