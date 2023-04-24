package com.practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher.*;
import org.hamcrest.Matcher.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetRequest02 {

    @Test
    public void test03() {
        String uri ="https://restful-booker.herokuapp.com/booking/7";
        Response response=given().accept("application/json").when().get(uri);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Sally")).
                body("lastname", Matchers.equalTo("Wilson")).
                body("totalprice",Matchers.equalTo(503)).
                body("bookingdates.checkin",Matchers.equalTo("2019-02-16"))
                .body("bookingdates.checkout",Matchers.equalTo("2021-06-01"));

//        {
//    "firstname": "Jim",
//    "lastname": "Smith",
//    "totalprice": 299,
//    "depositpaid": false,
//    "bookingdates": {
//        "checkin": "2021-11-19",
//        "checkout": "2023-02-04"
//    }
//}

    }

    @Test
    public void test02(){
        String url= "https://restful-booker.herokuapp.com/booking";

        Response response =given().accept("application/json").when().get(url);
        response.prettyPrint();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        response.then().
                assertThat().
                contentType(ContentType.JSON).statusCode(200);

    }

    @Test
    public void test04() {
        String url2= "https://restful-booker.herokuapp.com/booking/5";
        Response response=given().accept("application/json").when().get(url2);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).
                body("firstname",Matchers.equalTo("Jim"),
                        "totalprice",Matchers.equalTo(766),
                        "bookingdates.checkin",Matchers.equalTo("2021-01-26"));
    }

    @Test
    public void test05() {
        String url3="http://dummy.restapiexample.com/api/v1/employees";
        Response response=given().accept("application/json").when().get(url3);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).
                contentType("application/json").body("data.profile_image",hasSize(24)
                ,"data.employee_name",hasItem("Ashton Cox")
                ,"data.employee_age",hasItems(21,61,23));
    }

    @Test
    public void test06() {
        String url4="";
    }
}
