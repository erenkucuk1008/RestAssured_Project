package Day2;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class SearchMovie_OmdbApi {

    @DisplayName("Get a movie")
    @Test
    public void testSearchMovie(){

        JsonPath jp =
                given()
                        .queryParam("apikey","1000a607")
                        .queryParam("s", "Superman")
                        .queryParam("type","series")
                        .log().all().
                        when()
                        .get("http://www.omdbapi.com")
                        .prettyPeek()
                        .jsonPath()
                ;

        List<String> allTitle = jp.getList("Search.Title", String.class);
        List<String> allYears = jp.getList("Search.Year", String.class);
        System.out.println("allTitle = " + allTitle);
        System.out.println("allYears = " + allYears);

        assertThat(allTitle, hasSize(10));
        assertThat(allTitle, hasItem("Superman"));
    }
}