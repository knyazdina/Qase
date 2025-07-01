package adapters;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.ProjectRq;
import org.openqa.selenium.devtools.v135.network.model.Request;

import static io.restassured.RestAssured.given;

public class ProjectAPI {

    static Gson gson = new Gson();

    static RequestSpecification spec =
            given()
                    .contentType(ContentType.JSON)
                    .header("Token", "92518fa5eebe5acf8ce57a36881f46f6f669b8c6467fdb1b434d9fe9752fa091");

    static public String createProject(ProjectRq rq) {
        return
                given()
                        .log().all()
                        .spec(spec)
                        .body(gson.toJson(rq))
                        .when()
                        .post("https://api.qase.io/v1/project")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().path("result.code");
    }

    static public void deleteProject(String code) {
        given()
                .log().all()
                .spec(spec)
                .when()
                .delete("https://api.qase.io/v1/project/" + code)
                .then()
                .log().all()
                .statusCode(200);
    }

    static public void getProject(String code) {
        given()
                .log().all()
                .spec(spec)
                .when()
                .get("https://api.qase.io/v1/project/" + code)
                .then()
                .log().all()
                .statusCode(200);
    }
}
