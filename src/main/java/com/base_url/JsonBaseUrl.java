package com.base_url;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Before;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class JsonBaseUrl {

    protected RequestSpecification spec01;

    @Before
    public void setUp(){

        spec01= new RequestSpecBuilder().setBaseUri
                ("https://jsonplaceholder.typicode.com")
                .build();

    }
}
