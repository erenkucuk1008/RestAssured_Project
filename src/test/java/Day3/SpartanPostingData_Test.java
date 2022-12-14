package Day3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Spartan;
import test_util.BreakingBadBaseTest;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("POST /spartans with String")
public class SpartanPostingData_Test extends SpartanNoAuthBaseTest{

    @DisplayName("POST /spartans with String")
    @Test
    public void testPostDataWithStringBody(){

        /*
            {
                "name" : "Eren",
                "gender" : "Male",
                "phone" : 8083494130
            }
         */

        String postStrBody = "{\n" +
                "                \"name\" : \"Eren\",\n" +
                "                \"gender\" : \"Male\",\n" +
                "                \"phone\" : 8083494130\n" +
                "            }";

        given()
                .log().all()
//                .header("Content-Type", "application/json")
//                .contentType("application/json")
                .contentType(ContentType.JSON) // this is providing header for request
                .body(postStrBody).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(is(201))
                .contentType(ContentType.JSON) // this is asserting response header is json
                .body("success",is("A Spartan is Born!"))
                .body("data.name", is("Eren"))
                .body("data.id", is(131))
        ;
    }

    @DisplayName("POST /spartans with external file")
    @Test
    public void testPostDataWithJsonFileAsBody(){

        /* singleSpartan.json with below content
            {
                "name" : "Arzum",
                "gender" : "Female",
                "phone" : 8083511830
            }
         */

        File jsonFile = new File("singleSpartan.json");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(jsonFile).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
                ;
    }

    @DisplayName("POST /spartans with Map Object")
    @Test
    public void testPostDataWithMapObjectAsBody(){

        /*
            {
                "name" : "Abigale",
                "gender" : "Female",
                "phone" : 1800233323
            }
         */
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "Abigale");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", 1800233323L);

        System.out.println("bodyMap = " + bodyMap);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
        ;
    }

    @DisplayName("POST /spartans with POJO")
    @Test
    public void testPostDataWithPOJOAsBody(){

        Spartan sp = new Spartan("Abigale","Female",1800233323L) ;
        /*
            {
                "name" : "Abigale",
                "gender" : "Female",
                "phone" : 1800233323
            }
         */
        System.out.println("sp = " + sp);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(sp).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
        ;
    }
}
