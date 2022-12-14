package Day2;

import test_util.SpartanNoAuthBaseTest;
import io.restassured.http.ContentType;
import test_util.BreakingBadBaseTest;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ContentType_Test extends SpartanNoAuthBaseTest {

    @Test
    public void testHelloContentType(){

        when()
                .get("/hello").
        then()
                .contentType(ContentType.TEXT)
                .body( is("Hello from Sparta"))
        ;
    }

    @DisplayName("GET /spartans in json")
    @Test
    public void testSpartansJsonContentType(){

        given()
                .accept(ContentType.JSON).// asking JSON result from the server
        when()
                .get("/spartans").
        then()
                .contentType(ContentType.JSON)// verifying the response body in JSON
                ;
    }

    @DisplayName("GET /spartans in XML")
    @Test
    public void testSpartansXmlContentType(){

        given()
                .accept(ContentType.XML).
        when()
                .get("/spartans").
        then()
                .contentType(ContentType.XML)
                ;
    }
}
