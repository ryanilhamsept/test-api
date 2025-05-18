package rest;

import org.testng.Assert;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import org.testng.annotations.Test;


public class testGetApi  {

    @Test
    public void getApiresponse(){
        var Res = getAPI.testGetApi();
        Assert.assertEquals(Res.getStatusCode(),200);
        System.out.println(Res.asString());
    }


}
