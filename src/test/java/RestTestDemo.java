import User.UsersClient;
import User.createUser.request.CreateUserRequest;
import User.createUser.response.CreateUserReponse;
import User.deleteUser.DeleteUserRequest;
import User.deleteUser.DeleteUserResponse;
import User.getUser.request.UserRequest;
import User.getUser.response.UserResponse;
import User.getUsers.AllUserResponse;
import User.updateUser.UpdateUserRequest;
import User.updateUser.UpdateUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestTestDemo {

    UsersClient usersClient ;

    @BeforeTest
    public void initialize(){
        usersClient = new UsersClient();
    }

    @Test
    public void getAllUsers(){
        AllUserResponse allUserresponse =usersClient.getUsersResponse();
        Assert.assertTrue(allUserresponse.getData().length>0);

    }

    @Test
    public void getSpecificUserFirstname(){
        UserRequest userRequest = new UserRequest(2);
       UserResponse specificUserResponse = usersClient.getSpecificUserResponse(userRequest);
             String firstName = specificUserResponse.getData().getFirst_name();
        System.out.println(firstName);
        Assert.assertEquals(firstName,"Janet");

    }

    @Test
    public void getSpecificUserLastName(){
        UserRequest userRequest = new UserRequest(4);
            UserResponse specificUserResponse =usersClient.getSpecificUserResponse(userRequest);
            String lastName = specificUserResponse.getData().getLast_name();
            Assert.assertEquals(lastName,"Holt");
            Assert.assertEquals(specificUserResponse.getStatudCode(),200);
    }

    @Test
    public void createUser(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Vinay");
        createUserRequest.setJob("SDET");

       CreateUserReponse createUserResp=usersClient.createUserResponse(createUserRequest);
       String ID = createUserResp.getId();
        System.out.println(ID);
       Assert.assertTrue(ID!=null);
       Assert.assertEquals(createUserResp.getName(),"Vinay");
       Assert.assertEquals(createUserResp.getJob(),"SDET");

    }

    @Test
    public void updateUser(){
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setUserID(3);
        updateUserRequest.setName("Vinay1");
        updateUserRequest.setJob("SDET1");

        UpdateUserResponse response = usersClient.UpdateUser(updateUserRequest);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getName(),"Vinay1");
        Assert.assertEquals(response.getJob(),"SDET1");
    }

    @Test
    public void deleteUser(){
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUserID(5);

        DeleteUserResponse response  =usersClient.DeleteUserResponse(deleteUserRequest);
        Assert.assertEquals(response.getStatusCode(),204);
    }


}
