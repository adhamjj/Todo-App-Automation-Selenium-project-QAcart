package com.qacart.todo.api;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.Utils.UserUtlies;
import com.qacart.todo.config.Endpoint;
import com.qacart.todo.objects.User;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restassuredcookies;
    private String accessToken;
    private String userid;
    private String firstName;


    public String getToken(){
        return this .accessToken;

    }
    public List<Cookie> getcookies(){
        return this .restassuredcookies ;

    }
    public String getUserid(){
        return this .userid;

    }
    public String getFirstName(){
        return this .firstName;

    }
    public void register(){
        User user= UserUtlies.generaterandomuser();

        Response response=
                given()
                        .baseUri(ConfigUtils.geInstance().getBaseUrl())
                        .header("content-type","application/json")
                        .body(user)
                        .log().all()
                .when()
                        .post(Endpoint.API_REGISTER_END_POINT)

                .then()
                        .log().all()
                        .extract().response();

        if(response.statusCode()!=201){
            throw new RuntimeException("something went wrong");

        }
        restassuredcookies= response.detailedCookies().asList();
        accessToken =response.path("access_token");
        userid=response.path("userid");
        firstName=response.path("firstName");










    }


}
