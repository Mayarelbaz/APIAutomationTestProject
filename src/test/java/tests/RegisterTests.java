package tests;

import Requests.UserRequests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTests {
    private String email ="eve.holt@reqres.in";
    private String password = "pistol";
    private String expectedId= "4";
    private String expectedToken = "QpwL5tke4Pnpja7X4";

    @Test
    public void registerSuccessfully(){
        Response res = UserRequests.registration(email,password);
        res.then().statusCode(200);
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("id"),
                expectedId,"Id isn't correct");
        softAssert.assertEquals(JsonPath.from(res.asString()).getString("token"),
                expectedToken,"Wrong token");
    }

}
