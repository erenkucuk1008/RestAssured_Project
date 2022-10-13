package Day4;

import SpartanUtil.Spartan_Util;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanRandomPOST_Test extends SpartanNoAuthBaseTest {

    @DisplayName("/POST /spartans with random Data")
    @Test
    public void addOneRandomSpartanTest(){

        Map<String, Object> randomRequestBodyMap = Spartan_Util.getRandomSpartanMap();

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(randomRequestBodyMap).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
                ;
    }
}
