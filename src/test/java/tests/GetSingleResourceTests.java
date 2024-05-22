package tests;

import Requests.UserRequests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetSingleResourceTests {
    String id = " 2";
    String name="fuchsia rose";
    String year ="2001";
    String color= "#C74375";
    String pantone_value ="17-2031";
    String url =  "https://reqres.in/#support-heading";
    String text = "To keep ReqRes free, contributions towards server costs are appreciated!";

    @Test
    public void getSingleResourceSuccess(){
        Response res = UserRequests.getSingleResource(id);
        res.then().statusCode(200);
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("data.name"),name,
                "The name is not as expected");
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("data.year"),year,
                "Year is not as expected");
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("data.color"),color,
                "The color is not as expected");
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("data.pantone_value"),pantone_value,
                "Pantone value is not as expected");
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("support.url"),url,
                "The url is not as expected");
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("support.test"),text,
                "The text is not as expected");
    }
    @Test
    public void getSingleResourceNotFound(){
        Response res = UserRequests.getSingleResource("23");
        res.then().statusCode(404);
        Assert.assertEquals(res.getBody().asString(),"{}","unexpected data returned");
}}
