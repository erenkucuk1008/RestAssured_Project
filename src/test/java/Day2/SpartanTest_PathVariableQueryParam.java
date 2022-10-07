package Day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Spartan Test with path variable and query param")
public class SpartanTest_PathVariableQueryParam extends SpartanNoAuthBaseTest{

    @Test
    public void getOneSpartan(){

        //get("/spartans/16").prettyPeek();

        // I want to provide 16 as path variable\parameter
        // I want to provide accept header

        Response r1 =
                given()
                        .header("Accept", "application/json")
                        .pathParam("spartan_id", 16).
                when()
                        .get("/spartans/{spartan_id}")
                        .prettyPeek()
        ;

        //this is alternative way
        Response r2 =
                given()
                        //.header("Accept", "application/json") SAME
                        .accept("application/json").
                when()
                        //alternative.. path variable and value directly in get method
                        .get("/spartans/{spartan_id}", 16)
                        .prettyPeek()
        ;

        System.out.println("r1.statusCode() = " + r1.statusCode());
        System.out.println("r2.statusCode() = " + r2.statusCode());

        assertThat(r1.statusCode(),is(r2.statusCode()));
    }

    @DisplayName("Logging the request")
    @Test
    public void getOneSpartanWithLog(){

        Response response =
                given()
                    .log().all()
                    .accept("application/json")
                    .pathParam("id",16).
                when()
                    .get("/spartans/{id}")
                    .prettyPeek()
                ;

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.contentType(), is("application/json"));
        //assertThat(response.header("Content-TYpe"), is("application/json"));
        assertThat(response.path("name"), is("Sinclair"));
    }
}
