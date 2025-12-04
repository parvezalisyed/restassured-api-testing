import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    static { RestAssured.baseURI = "https://reqres.in/api"; }

    @Test
    public void getUserSuccess() {
        given()
        .when()
            .get("/users/2")
        .then()
            .statusCode(200)
            .body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void createUser() {
        given()
            .header("Content-Type", "application/json")
            .body("{\"name\": \"Parvez\", \"job\": \"QA Engineer\"}")
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Parvez"));
    }
}
