package Day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.BreakingBadBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BreakingBadPractice extends BreakingBadBaseTest {

    @DisplayName("Breaking Bad Get Request")
    @Test
    public void getAllCharacters(){
        get("/characters").prettyPeek();
    }

    @DisplayName("Get 1 Character")
    @Test
    public void getOneCharacter(){

        Response response = get("/characters/1");

        assertThat(response.statusCode(), is(200));
        System.out.println("response.path(\"name\") = " + response.path("name"));
    }
}
