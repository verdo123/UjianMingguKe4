package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.timestamp.TSResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestGetMovie_NowPlaying {

    String endpoint = "https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1";
    String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZWY2Yzc5NWViMjk5Nzc2NzExZWMzN2FmZjUxZTg0MyIsInN1YiI6IjY1ZDg4YTY1ZDRkNTA5MDE4NjY1MGU4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fChahTUTCSyATUzWUAYjD3wolVvtnx_d-638dY7wmdc";


    @Test
    public void testGetMovieNowPlaying() {

        given()
                .header("Authorization", token)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.title[0]", equalTo("Land of Bad"))
                .log().all();
    }

    //Negative case ----------------------------------------------------------------
    @Test
    public void testGetMovieNowPlayingId() {

        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results-id[1]",equalTo(1072790));

    }






//        Response response = RestAssured.get(endpoint);
//        int actual = response.getStatusCode();
//        Assert.assertEquals(actual, 200);



}
