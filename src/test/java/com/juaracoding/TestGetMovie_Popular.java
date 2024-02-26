package com.juaracoding;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestGetMovie_Popular {
    String endpoint = "https://api.themoviedb.org/3/movie/popular";
    String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZWY2Yzc5NWViMjk5Nzc2NzExZWMzN2FmZjUxZTg0MyIsInN1YiI6IjY1ZDg4YTY1ZDRkNTA5MDE4NjY1MGU4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fChahTUTCSyATUzWUAYjD3wolVvtnx_d-638dY7wmdc";


    @Test
    public void testGetMoviePopular() {

        given()
                .header("Authorization", token)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testGetMovieByTitle() {

        given()
                .header("Authorization", token)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("original_title",equalTo("Land of Bad"));

    }
}


