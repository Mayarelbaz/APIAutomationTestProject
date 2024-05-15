package tests;

import Requests.UserRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.path.json.JsonPath.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetSingleUserTest {
 String id ="2";
 String Fname="Janet";
 String Lname= "Weaver";

    @Test
    public void getSingleUserSuccess() {
        Response response = UserRequests.getSingleUser(id);
        response.then().statusCode(200);
        Assert.assertEquals(jsonPath(response.asString()).getString("id"),id, "id is not as expected");
        String responseFname = jsonPath(response.asString()).getString("Fname");
        Assert.assertEquals(responseFname,Fname, "first name is not as expected");
        String responseLname = jsonPath(response.asString()).getString("Lname");

        Assert.assertEquals(responseLname,Lname, "last name  is not as expected");


    }

}
