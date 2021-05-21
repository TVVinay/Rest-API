package User.getUser.response;

public class UserResponse {

        private Data data;
        private Support support;
        private int statudCode;


        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Support getSupport() {
            return support;
        }

        public void setSupport(Support support) {
            this.support = support;
        }

    public int getStatudCode() {
        return statudCode;
    }

    public void setStatudCode(int statudCode) {
        this.statudCode = statudCode;
    }
}