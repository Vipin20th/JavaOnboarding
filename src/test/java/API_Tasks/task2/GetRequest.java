package API_Tasks.task2;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class GetRequest {

        @BeforeAll
        public static void setup() {
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        }

        @Test
        public void getRequest() {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/posts")
                    .then()
                    .extract().response();

            assertEquals(200, response.statusCode());
            assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
        }

}
