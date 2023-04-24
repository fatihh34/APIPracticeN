package com.practice;

import com.base_url.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 extends JsonBaseUrl {

    @Test
    public void test03(){
        spec01.pathParams("first","todos","second",123);

        Response response =given().
                spec(spec01).
                accept(ContentType.JSON).when().
                get("/{first}/{second}");
        response.prettyPrint();
    }
}
