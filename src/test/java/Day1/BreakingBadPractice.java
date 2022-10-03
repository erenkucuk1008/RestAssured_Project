package Day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.BreakingBadBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BreakingBadPractice extends BreakingBadBaseTest {

    @DisplayName("Breaking Bad Get All Characters")
    @Test
    public void getAllCharacters(){
        Response response = get("/characters").prettyPeek();
        assertThat(response.statusCode(), is(200));
    }

    @DisplayName("Breaking Bad Get 1 Character")
    @Test
    public void getOneCharacter(){
        Response response = get("/characters/1").prettyPeek();
        assertThat(response.statusCode(), is(200));
        System.out.println("response.path(\"name\") = " + response.path("name"));
    }

    @DisplayName("Breaking Bad Get All Episodes")
    @Test
    public void getAllEpisodes(){
        Response response = get("/episodes").prettyPeek();
        assertThat(response.statusCode(), is(200));
    }

    @DisplayName("Breaking Bad Get One Episode")
    @Test
    public void getOneEpisode(){
        Response response = get("/episodes/16").prettyPeek();
        assertThat(response.statusCode(), is(200));
    }
}
