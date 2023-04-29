package com.demo.integration;

import static io.restassured.RestAssured.given;

import com.demo.integration.utils.BodyBuilder;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class UserControllerFixture {

    public static Response postUser(BodyBuilder bodyBuilder){
        return given()
                .basePath("http://localhost:8080/api/v1")
                .body(bodyBuilder.build())
                .when()
                .post("/user");
    }
}
