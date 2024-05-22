package Requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class UserRequests {


    public static Response getSingleUser(String id){
        return RestAssured.given().log().all()
                .get(Constants.baseURL + Constants.userEndPoint + id);

    }
    public static Response getSingleResource(String id){
        return RestAssured.given().log().all()
                .get(Constants.baseURL+Constants.resourceEndPoint+id);
    }
    public static Response registration(String email,String password){
        return RestAssured.given().log().all().contentType("application/json")
                .body("{\"email\": \""+email+"\",\n" + "    \"password\": \""+password+"\"}")
                .post(Constants.baseURL + Constants.registerEndPoint);
    }
    public static Response deleteUser(String id){
        return RestAssured.given().log().all()
                .delete(Constants.baseURL + Constants.userEndPoint + id);
    }}


