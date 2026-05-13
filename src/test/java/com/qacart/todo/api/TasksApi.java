package com.qacart.todo.api;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.config.Endpoint;
import com.qacart.todo.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TasksApi {
    public void addTask(String token){
        Task task=new Task("Learn Selenium",false);
     Response response= given()
                .baseUri(ConfigUtils.geInstance().getBaseUrl())
                .header("content-type","application/json")
                .body(task)
                .auth().oauth2(token)

        .when()
                .post(Endpoint.API_TASK_ENF_POINT)

        .then()
                .log().all()
                .extract().response();

        if(response.statusCode()!=201) {
            throw new RuntimeException("something went wrong in adding the todo");
        }



    }
}

