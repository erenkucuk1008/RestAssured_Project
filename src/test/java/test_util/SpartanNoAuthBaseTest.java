package test_util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanNoAuthBaseTest {

    //BeforeAll ve AfterAll static methodla yaziyoruz
    @BeforeAll
    public static void init(){

        String spartanURL = ConfigurationReader.getProperty("spartanURL");
        RestAssured.baseURI = spartanURL;
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void cleanup(){

        RestAssured.reset();
    }
}
