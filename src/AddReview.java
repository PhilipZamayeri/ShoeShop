import java.util.Scanner;

public class AddReview {

    public AddReview() {
        try {
            Repository r = new Repository();
            Scanner sc = new Scanner(System.in);
            String comment;

            //if()

            while (true) {
                System.out.println("Write a comment: ");
                comment = sc.nextLine().trim();
               // System.out.println(r.addReview(comment));
                System.out.println(r.addReview(comment, 1, 1));
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
