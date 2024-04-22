package API_Tasks.task10;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;

public class JiraTest {
    private static final String JIRA_USERNAME = "your_username";
    private static final String JIRA_PASSWORD = "your_password";
    private static final String JIRA_URL = "https://your-jira-url";



    public void createDefectID(){
        RestAssured.baseURI = JIRA_URL;
        Response response = given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .contentType(ContentType.JSON)
                .body("{ \"fields\": { \"project\": { \"key\": \"YOUR_PROJECT_KEY\" }, \"summary\": \"Issue summary\", \"description\": \"Issue description\", \"issuetype\": { \"name\": \"Bug\" } } }")
                .post("/rest/api/2/issue");

        System.out.println("Issue created. Status code: " + response.getStatusCode());
        System.out.println("Issue key: " + response.jsonPath().getString("key"));
    }


    public void updateDefectID(){
        Response response = given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .contentType(ContentType.JSON)
                .body("{ \"fields\": { \"summary\": \"Updated summary\" } }")
                .put("/rest/api/2/issue/DEFECT_ID");
    }

    public void searchDefect(){
        Response response = given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .contentType(ContentType.JSON)
                .get("/rest/api/2/search?jql=summary~\"Issue summary\"");
    }

    public void addAttachements(){
        Response response = given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .multiPart(new File("/path/to/attachment.jpg"))
                .post("/rest/api/2/issue/DEFECT_ID/attachments");
    }


    public void deleteDefect(){
        Response response = given()
                .auth().preemptive().basic(JIRA_USERNAME, JIRA_PASSWORD)
                .delete("/rest/api/2/issue/DEFECT_ID");
    }

    public static void main(String[] args) {
        JiraTest jira = new JiraTest();
        jira.createDefectID();
        jira.updateDefectID();
        jira.searchDefect();
        jira.addAttachements();
        jira.deleteDefect();

    }

}

