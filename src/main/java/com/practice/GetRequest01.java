package com.practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01(){

        String url ="https://restful-booker.herokuapp.com/booking/3";

        Response response= given().accept("application/json").when().get(url);
        response.prettyPrint();
        System.out.println("response.getHeaders() = " + response.getHeaders());

        //Assert.assertEquals(response.statusCode(),200);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

    }
}
