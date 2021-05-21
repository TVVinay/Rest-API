package User;

import User.createUser.request.CreateUserRequest;
import User.createUser.response.CreateUserReponse;
import User.deleteUser.DeleteUserRequest;
import User.deleteUser.DeleteUserResponse;
import User.getUser.request.UserRequest;
import User.getUser.response.UserResponse;
import User.getUsers.AllUserResponse;
import User.updateUser.UpdateUserRequest;
import User.updateUser.UpdateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public final String baseUri = "https://reqres.in/api/users";

    public AllUserResponse getUsersResponse() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseUri).as(AllUserResponse.class);
    }

    public UserResponse getSpecificUserResponse(UserRequest request) {
          String uri =  request.getUri()+"{user}";
             Response user = given()
                .contentType(ContentType.JSON)
                .pathParam("user", request.getUserId())
                .when()
                .get(uri);

        UserResponse userResponse = user.as(UserResponse.class);
        userResponse.setStatudCode(user.getStatusCode());

        return userResponse;
    }


    public CreateUserReponse createUserResponse(CreateUserRequest createUserRequest) {
        String uri = createUserRequest.getUri();
        Response createUser = given().contentType(ContentType.JSON)
                .body(createUserRequest)
                .post(baseUri);
        CreateUserReponse userResponse =createUser.as(CreateUserReponse.class);
        return userResponse;
    }

    public UpdateUserResponse UpdateUser(UpdateUserRequest updateUserRequest){
       String uri = baseUri+"/"+updateUserRequest.getUserID();
      Response updateUser = given().contentType(ContentType.JSON)
               .body(updateUserRequest)
               .put(uri);

      UpdateUserResponse updateUserResponse=updateUser.as(UpdateUserResponse.class);
      updateUserResponse.setStatusCode(updateUser.getStatusCode());
      return updateUserResponse;
    }

    public DeleteUserResponse DeleteUserResponse(DeleteUserRequest deleteUserRequest){
        String uri = baseUri+"/"+deleteUserRequest.getUserID();
        Response deleteuser = given()
                .delete(uri);

        DeleteUserResponse delUser=deleteuser.as(DeleteUserResponse.class);
        delUser.setStatusCode(deleteuser.getStatusCode());
        return delUser;

    }


}


