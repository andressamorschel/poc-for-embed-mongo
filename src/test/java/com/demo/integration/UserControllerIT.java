package com.demo.integration;

import static io.restassured.RestAssured.given;

import com.demo.integration.config.UserConfig;
import org.junit.jupiter.api.Test;

class UserControllerIT extends UserConfig {

    @Test
    void findAll() {
        given()
                .when()
                .get("/user")
                .then()
                .statusCode(200);
    }

}
