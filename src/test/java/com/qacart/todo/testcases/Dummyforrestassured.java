package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;

import static io.restassured.RestAssured.given;

public class Dummyforrestassured {
    public static void main(String[] args) {
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

        System.out.println(registerApi.getUserid());
        System.out.println(registerApi.getFirstName());
        System.out.println(registerApi.getToken());



    }




}
