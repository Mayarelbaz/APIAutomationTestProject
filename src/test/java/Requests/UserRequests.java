package Requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.Constants;

public class UserRequests {
    public static Response getSingleUser(String id){
        return RestAssured.given().log().all()
                .get(Constants.baseURL + Constants.userEndPoint + id)
                .then().extract().response();
    }

    public static Response deleteUser(String id){
        return RestAssured.given().log().all()
                .delete(Constants.baseURL + Constants.userEndPoint + id);
    }
}
