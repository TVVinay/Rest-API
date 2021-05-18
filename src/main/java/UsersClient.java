import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public AllUserResponse getResponse() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users").as(AllUserResponse.class);
    }

    public UserResponse getSpecificUserResponse(int userID) {
       return given()
                .contentType(ContentType.JSON)
                .pathParam("user",2)
                .when()
                .get("https://reqres.in/api/users/{user}").as(UserResponse.class);

    }
}
