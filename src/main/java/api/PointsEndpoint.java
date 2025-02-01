package api;

import io.restassured.response.Response;
import properties.PropertiesUtils;

import static io.restassured.RestAssured.given;

public class PointsEndpoint {

    private static final String BASE_URL = PropertiesUtils.getProperty("apiUrl") + "/points";

    public Response getParcelLockersByCity(String city) {
        return getParcelLockersByCity(city, 1);
    }

    public Response getParcelLockersByCity(String city, int page) {
        return given()
                .param("page", page)
                .param("type", "parcel_locker")
                .param("city", city)
                .when()
                .get(BASE_URL);
    }

}
