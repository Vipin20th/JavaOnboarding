package java8.secondExercise;

public class Response {

    private String body;
    private int statusCode;
    private String responseType;

    public Response(String body, int statusCode, String responseType) {
        this.body = body;
        this.statusCode = statusCode;
        this.responseType = responseType;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseType() {
        return responseType;
    }
}
