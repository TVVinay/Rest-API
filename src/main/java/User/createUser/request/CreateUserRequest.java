package User.createUser.request;

public class CreateUserRequest {

    public final String uri = "https://reqres.in/api/users";
    private String name;
    private String job;


  public String getUri() {
       return uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }





}
