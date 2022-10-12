package Day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.http.ContentType;
import pojo.Spartan;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class SpartanUpdatingData_Test extends SpartanNoAuthBaseTest {

    @DisplayName("PUT /spartans/{id} body as Map")
    @Test
    public void testUpdateDataWithMap(){

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "ARzumK");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", 1800233323L);

        given()
                .log().all()
                .pathParam("id",33)
                .contentType(ContentType.JSON)
                .body(bodyMap).
        when()
                .put("/spartans/{id}").
        then()
                .statusCode(204)
        ;
    }

    @DisplayName("PUT /spartans/{id} body as POJO")
    @Test
    public void testUpdateDataWithPOJO(){

        Spartan sp = new Spartan("Arzumm","Female",8889993321L);

        given()
                .log().all()
                .pathParam("id",33)
                .contentType(ContentType.JSON)
                .body(sp).
        when()
                .put("/spartans/{id}").
        then()
                .statusCode(204)
        ;
    }

    @DisplayName("PATCH /spartans/{id} body as String")
    @Test
    public void testPartialUpdateDataWithString(){

        String patchBody = " {\"phone\":8083494130} ";
        System.out.println(patchBody);

        given()
                .log().all()
                .pathParam("id",33)
                .contentType(ContentType.JSON)
                .body(patchBody).
        when()
                .patch("/spartans/{id}").
        then()
                .statusCode(204)
        ;
    }

    @DisplayName("DELETE /spartans/{id}")
    @Test
    public void testDelete(){

        given()
                .log().uri()
                .pathParam("id",134).
        when()
                .delete("/spartans/{id}").
        then()
                .statusCode(204)
        ;
    }
}
