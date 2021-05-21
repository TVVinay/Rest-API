package User.getUser.request;

public class UserRequest {

    private int userId;
    public final String uri = "https://reqres.in/api/users/";

    public UserRequest(int userId){
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }

    public String getUri(){
        return uri;
    }

}
