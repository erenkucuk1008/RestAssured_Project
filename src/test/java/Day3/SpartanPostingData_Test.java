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
                .contentType(ContentType.JSON)
                .body(postStrBody).
        when()
                .post("/spartans");
        //then()

    }
}
