package Day2;

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

public class BreakingBad_Test extends BreakingBadBaseTest {

    //https://www.breakingbadapi.com/api/characters?name=Walter
    @Test
    public void testFilterCharacterName(){

        given()
                .log().uri()
                .queryParam("name", "Walter").
        when()
                .get("/characters").
        then()
                .log().all()
                //.and() //this is just for readability
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
        ;
    }

    @DisplayName("Test GET /characters/{char_id}")
    @Test
    public void test1Character(){

        given()
                .pathParam("char_id",1)
                .log().uri().
        when()
                .get("characters/{char_id}").
        then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
                ;
    }

    //episode 60
    @DisplayName("Test GET /episodes/{episode_id}")
    @Test
    public void test1Episode(){

        given()
                .pathParam("episode_id",60)
                .log().all().
        when()
                .get("episodes/{episode_id}").
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;
    }
}
