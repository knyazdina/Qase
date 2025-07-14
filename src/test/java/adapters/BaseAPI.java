package adapters;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    static Gson gson = new Gson();
    static String token = System.getProperty("token", PropertyReader.getProperty("token"));

    static RequestSpecification spec =
            given()
                    .contentType(ContentType.JSON)
                    .header("Token", token);

}
