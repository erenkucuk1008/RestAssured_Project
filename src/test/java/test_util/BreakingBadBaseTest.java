package test_util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BreakingBadBaseTest {

    @BeforeAll
    public static void init(){

        RestAssured.baseURI = ConfigurationReader.getProperty("breakingBadURL");
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void cleanUp(){

        RestAssured.reset();
    }
}
