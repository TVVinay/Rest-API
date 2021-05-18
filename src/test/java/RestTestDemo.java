import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

public class RestTestDemo {

    UsersClient usersClient ;
    @BeforeTest
    public void initialize(){
        usersClient = new UsersClient();
    }

    @Test
    public void getAllUsersFirstName(){

    AllUserResponse allUserresponse =usersClient.getResponse();
       Iterator<Data> itr = Arrays.stream(allUserresponse.getData()).iterator();
       while (itr.hasNext()){
           System.out.println(itr.next().getFirst_name());
    }

           /* allUserresponse.then()
                .log().all().assertThat().statusCode(200);*/
    }

    @Test
    public void getSpecificUserFirstname(){

       UserResponse specificUserResponse = usersClient.getSpecificUserResponse(2);
             String firstName = specificUserResponse.getData().getFirst_name();
        System.out.println(firstName);
        Assert.assertEquals(firstName,"Janet");

    }

    @Test
    public void getSpecificUserLastName(){
            UserResponse specificUserResponse =usersClient.getSpecificUserResponse(4);
            String lastName = specificUserResponse.getData().getLast_name();
            Assert.assertEquals(lastName,"Weaver");

    }




}
