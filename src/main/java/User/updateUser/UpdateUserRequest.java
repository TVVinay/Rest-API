    package User.updateUser;

    import com.fasterxml.jackson.annotation.JsonIgnore;

    public class UpdateUserRequest {

        private int userID;

        @JsonIgnore
        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
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

        private String name;
        private String job;




    }
