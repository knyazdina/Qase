package adapters;

import models.CaseRq;

import static io.restassured.RestAssured.given;

public class CaseAPI extends BaseAPI{

    static public String createCase(CaseRq rq) {
        return
                given()
                        .log().all()
                        .spec(spec)
                        .body(gson.toJson(rq))
                        .when()
                        .post("https://api.qase.io/v1/case/QASE")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().path("result.id","result.code");
    }

    static public void deleteCase(String id, String code) {
        given()
                .log().all()
                .spec(spec)
                .when()
                .delete("https://api.qase.io/v1/case/QASE" + code + id)
                .then()
                .log().all()
                .statusCode(200);
    }
}

