import java.util.Scanner;

public class AddReview {

    public AddReview() {
        try {
            Repository r = new Repository();
            Scanner sc = new Scanner(System.in);
            String comment;
            int rating;
            // int review_id;

            //if()

            while (true) {
                System.out.println("Write a comment: ");
                comment = sc.nextLine().trim();
                System.out.println("How many points? 1-4 ");
                rating = sc.nextInt();
                System.out.println();
               // System.out.println(r.addReview(comment));
                System.out.println(r.addReview(comment, rating, 1));
                break;
            }

//        System.out.println(present);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddReview();
    }
}
