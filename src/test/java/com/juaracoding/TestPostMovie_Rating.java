package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPostMovie_Rating {

    String endpoint = "https://api.themoviedb.org/3/movie/popular";
    String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZWY2Yzc5NWViMjk5Nzc2NzExZWMzN2FmZjUxZTg0MyIsInN1YiI6IjY1ZDg4YTY1ZDRkNTA5MDE4NjY1MGU4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fChahTUTCSyATUzWUAYjD3wolVvtnx_d-638dY7wmdc";


    @Test
    public void testGetListMoviePopular() {
        Response response = RestAssured.get(endpoint);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.getTime());
        Assert.assertEquals(response.getStatusCode(), 401);
    }

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
        public void testPostTitleMovie () {
            JSONObject request = new JSONObject();
            request.put("value", "8.0");
            System.out.println(request.toJSONString());
            given()
                    .header("Authorization", token)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(request.toJSONString())
                    .when()
                    .post("https://api.themoviedb.org/3/movie/1072790/rating")
                    .then()
                    .statusCode(201)
                    .log().all();
        }



//Negative case ----------------------------------------------------------------

    @Test
    public void testPostTitleMovieNegative () {
        JSONObject request = new JSONObject();
        request.put("value", "8.0");
        System.out.println(request.toJSONString());
        given()
                .header("Authorization", "token")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/1072790/rating")
                .then()
                .statusCode(401)
                .log().all();
    }



}

