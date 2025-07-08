package adapters;

import models.CaseRq;

import static io.restassured.RestAssured.given;

public class CaseAPI extends BaseAPI {

    static public int createCase(String code, CaseRq rq) {
        return
                given()
                        .log().all()
                        .spec(spec)
                        .body(gson.toJson(rq))
                        .when()
                        .post("https://api.qase.io/v1/case/" + code)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().path("result.id");
    }

    static public void deleteCase(int id, String code) {
        given()
                .log().all()
                .spec(spec)
                .when()
                .delete("https://api.qase.io/v1/case/" + code + "/" + id)
                .then()
                .log().all()
                .statusCode(200);
    }
}

