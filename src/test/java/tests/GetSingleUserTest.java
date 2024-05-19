package tests;

import Requests.UserRequests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserTest {
 String id ="2";
 String Fname="Janet";
 String Lname= "Weaver";

    @Test
    public void getSingleUserSuccess() {

        Response response = UserRequests.getSingleUser(id);
        System.out.println(response.getBody().asString());

        response.then().statusCode(200);
        int id = JsonPath.from(response.asString()).getInt("data.id");
        //Assert.assertEquals(JsonPath.from(response.asString()).getString("data.id"),id, "id is not as expected");
        String responseFname = JsonPath.from(response.asString()).getString("data.first_name");
        Assert.assertEquals(responseFname,Fname, "first name is not as expected");
        String responseLname = JsonPath.from(response.asString()).getString("data.last_name");

        Assert.assertEquals(responseLname,Lname, "last name  is not as expected");


    }

}
