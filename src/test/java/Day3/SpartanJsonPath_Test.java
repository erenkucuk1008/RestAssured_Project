package Day3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import test_util.BreakingBadBaseTest;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanJsonPath_Test extends SpartanNoAuthBaseTest{

    @Test
    public void testOne(){

        Response response =
                given()
                        .pathParam("id",106).
                when()
                        .get("spartans/{id}")
                        .prettyPeek()
        ;

        //using path method to extract data
        int myId = response.path("id");
        System.out.println("myId = " + myId);

        JsonPath jp = response.jsonPath();

        myId = jp.getInt("id");
        System.out.println("the result is = " + myId);

        long phoneNum = jp.getLong("phone");
        System.out.println("phoneNum = " + phoneNum);

        String myName = jp.getString("name");
        System.out.println("myName = " + myName);

        System.out.println("Save whole json object into map = " + jp.getMap(""));

        Map<String,Object> resultMap = jp.getMap("");
        System.out.println("resultMap = " + resultMap);
    }

    @DisplayName("Extract data from GET /spartans")
    @Test
    public void testGetAllSpartans(){

        //Response response = get("/spartans");
        //JsonPath jp = response.jsonPath();
// 2 sini birlestirdik...

        JsonPath jp = get("/spartans").jsonPath();
        // print first id in the json array response
        System.out.println("jp.getInt(\"id[0]\") = " + jp.getInt("id[0]"));

        // print second json object name in json array response
        System.out.println("jp.getString(\"name[1]\") = " + jp.getString("name[1]"));
        //daha once su sekilde yapiyorduk.. without JsonPath
        //System.out.println("response.path(\"name[1]\") = " + response.path("name[1]"));

        System.out.println("jp.getMap(\"[0]\") = " + jp.getMap("[0]"));

        // print first id in the json array response -- line 62 aynisi
        System.out.println("jp.getInt(\"[0].id\") = " + jp.getInt("[0].id"));

    }

    @DisplayName("Extract data from GET /spartans/search")
    @Test
    public void testGetSearchSpartans(){

        //http://3.91.182.164:8000/api/spartans/search
        // ?nameContains=a&Gender=Male //queryParam

        JsonPath jp =
                given()
                        .queryParam("nameContains", "Eren")
                        .queryParam("Gender", "Male")
                        .log().all().
                when()
                        .get("/spartans/search")
                        .prettyPeek()
                        .jsonPath()
        ;

        // find out first guy id, second guy name
        System.out.println("jp.getInt(\"content[0].id\") = " + jp.getInt("content[0].id"));
        System.out.println("jp.getString(\"content[1].name\") = " + jp.getString("content[1].name"));
        System.out.println("jp.getInt(\"totalElement\") = " + jp.getInt("totalElement"));
        //totalElement ve content sadece spartans/search de oldugu icin burada yaziyoruz.

        //store first object into a map
        Map<String, Object> secondJsonInMap = jp.getMap("content[1]");
        System.out.println("secondJsonInMap = " + secondJsonInMap);
    }

    @DisplayName("Saving json array fields into list")
    @Test
    public void testSavingJsonArrayFieldsIntoList(){

        JsonPath jp =
                given()
                        .queryParam("nameContains", "Eren")
                        .queryParam("gender", "Male")
                        .log().all().
                when()
                        .get("/spartans/search")
                        .prettyPeek()
                        .jsonPath()
        ;

        // save all id into the list
        System.out.println("jp.getList(\"content.id\") = " + jp.getList("content.id"));
        System.out.println("jp.getList(\"content.name\") = " + jp.getList("content.name"));
        System.out.println("jp.getList(\"content.phone\") = " + jp.getList("content.phone"));

        //getList method has 2 overloaded version
        //1. jp.getList("json path here") type of list will be automatically determine
        List<Integer> allId = jp.getList("content.id");
        //2. jp.getList("json path here", class type ypu want this list to have)
        List<Integer> allId2 = jp.getList("content.id", Integer.class);

        List<String> allNames = jp.getList("content.name");
        List<String> allNames2 = jp.getList("content.name", String.class);

        List<Long> allPhones = jp.getList("content.phone");
        List<Long> allPhones2 = jp.getList("content.phone", Long.class);

    }

    @DisplayName("Get List Practice for GET /spartans")
    @Test
    public void testGetListOutOfAllSpartans(){

        JsonPath jp = get("/spartans").jsonPath();
        //save the list into List object and assert the size

        List<Integer> allId = jp.getList("id", Integer.class);
        List<String> allNames = jp.getList("name", String.class);
        List<Long> allPhones = jp.getList("phone", Long.class);

        assertThat(allId, hasSize(122));
        assertThat(allNames, hasSize(122));
        assertThat(allPhones, hasSize(122));
    }


}
