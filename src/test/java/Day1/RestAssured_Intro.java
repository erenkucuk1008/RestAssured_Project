package Day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Intro to RestAssured")
public class RestAssured_Intro {

    @DisplayName("Testing hello endpoint")
    @Test
    public void testHelloEndpoint(){

        //Postman da ki Day1 de Hello yu yapiyoruz
        //http://3.91.182.164:8000/api/hello
        //save the response into a object with type Response
        Response response = get("http://3.91.182.164:8000/api/hello");

        //extracting information from Response object
        //getting status code -- 2 farkli yolla -- same
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        //getting spesific header
        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));
        System.out.println("response.header(\"Date\") = " + response.header("Date"));

        //getting content type header using ready method
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());

        //getting the time spent for execution
        System.out.println("response.time() = " + response.time());
        System.out.println("response.getTime() = " + response.getTime());

        //getting body as String
        System.out.println("response.asString() = " + response.asString());

        assertThat(response.statusCode(), is(200));
        assertThat(response.contentType(), is("text/plain;charset=UTF-8"));
        assertThat(response.contentType(), startsWith("text/plain"));
        assertThat(response.asString(), is("Hello from Sparta"));

        //printing the result
        //prettyPrint() -> print and return String
        //prettyPeek() -> print and return same Response Object
        response.prettyPrint();
        response.prettyPeek();

    }

    @DisplayName("Testing GET /api/spartans/{id} Endpoint")
    @Test
    public void testSingleSpartan(){

        //save the response and print out whole response
        Response response =
                        get("http://3.91.182.164:8000/api/spartans/16")
                        .prettyPeek();

        assertThat(response.statusCode(), is(200));
        assertThat(response.contentType(), is("application/json"));
        assertThat(response.header("Connection"), equalTo("keep-alive"));

        System.out.println("response.asString() = " + response.asString());

        //path ile Json body de istedigimiz value yu cekebiliyoruz
        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        int myID = response.path("id");
        String myName = response.path("name");
        long myPhone = response.path("phone");

        System.out.println("myID = " + myID);
        System.out.println("myName = " + myName);
        System.out.println("myPhone = " + myPhone);
    }


}
