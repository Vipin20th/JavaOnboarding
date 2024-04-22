package API_Tasks.task3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PetStoreTest {

    public void createaPet(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        given()
                .contentType(ContentType.JSON)
                .body("{ \"id\": 12345, \"category\": { \"id\": 1, \"name\": \"dog\" }, \"name\": \"snoopie\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"pending\" }")
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }

    public void getCalls(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Test for GET /pet/12345
        given()
                .when()
                .get("/pet/12345")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("category.name", equalTo("dog"))
                .body("name", equalTo("snoopie"))
                .body("status", equalTo("pending"));
    }


    public void usersGetCall(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(3))
                .body("find { it.name == 'Ervin Howell' }", is(notNullValue()));
    }







    public static void main(String[] args) {
        PetStoreTest pet = new PetStoreTest();
        pet.createaPet();


    }



}
