package auxiliarEntities;

public class UserReviewsQuantity implements Comparable<UserReviewsQuantity>{
        String username;
        int quantity;

        public UserReviewsQuantity(String username, int quantity) {
            this.username = username;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(UserReviewsQuantity userReviewsQuantity) {
            if(quantity > userReviewsQuantity.getQuantity()){
                return 1;
            }
            else if(quantity < userReviewsQuantity.getQuantity()){
                return -1;
            }
            else{
                return 0;
            }
        }

        public String getUsername() {
            return username;
        }

        public int getQuantity() {
            return quantity;
        }
    }
