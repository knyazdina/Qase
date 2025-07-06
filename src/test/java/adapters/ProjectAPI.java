package adapters;

import models.ProjectRq;

import static io.restassured.RestAssured.given;

public class ProjectAPI extends BaseAPI{


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
