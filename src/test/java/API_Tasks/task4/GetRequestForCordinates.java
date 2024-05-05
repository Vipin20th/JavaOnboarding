package API_Tasks.task4;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetRequestForCordinates {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.openweathermap.org";
    }

    @Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/data/2.5/weather?lat=44.34&lon=10.99&appid=b3e0887f96f91aefd1e0245318d6b290")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("Hyderabad", response.jsonPath().getString("name"));
        assertEquals("IN", response.jsonPath().getString("sys.country"));
        assertEquals("0", response.jsonPath().getString("main.temp"));
    }
}
