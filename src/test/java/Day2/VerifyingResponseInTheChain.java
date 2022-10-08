package Day2;

import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VerifyingResponseInTheChain extends SpartanNoAuthBaseTest {

    @DisplayName("Verifying the GET /spartans/{id} response directly in the chain")
    @Test
    public void testOneSpartanInOneShot(){

        given()
                .log().all()
                .pathParam("id", 16).
        when()
                .get("/spartans/{id}").
        then()
                .log().all() // butun herseyi gosterir
                //.log().body() ekranda sadece body gosterir
                //.log().ifValidationFails() sadece test fail oldugunda ekrana yazdirilir
                //.log.status() ekranda sadece 200 gosterir
                //.log().headers() ekranda sadece header ler gosterilir
                //.log().ifError()
                .statusCode(200)
                .header("Content-Type", is("application/json"))
                .contentType("application/json")
                .body("id", equalTo(16))
                .body("name", is("Sinclair"))
                .body("gender", is("Male"))
                .body("phone", equalTo(9714460354L))
        ;

    }

    @DisplayName("All Different Logging Options")
    @Test
    public void testOneSpartanLogRequestAndResponse(){

        given()
             .log().all()
                //.log().uri() just for the request URL
                //.log().body() for logging request body
                //.log().params() logging only request parameters
                //.log().method() just log the http method
                //.log().ifValidationFails() only log the request if validation in
             .pathParam("id", 16).
        when()
             .get("/spartans/{id}").
        then()
             .log().all() // butun herseyi gosterir
                //.log().body() ekranda sadece body gosterir
                //.log().ifValidationFails() sadece test fail oldugunda ekrana yazdirilir
                //.log.status() ekranda sadece 200 gosterir
                //.log().headers() ekranda sadece header ler gosterilir
                //.log().ifError()
                .statusCode(200)
             ;
    }
}
