import java.util.Scanner;

public class AddReview {

    public AddReview() {
        try {
            Repository r = new Repository();
            Scanner sc = new Scanner(System.in);
            String comment;
            int rating;
            int customer_id = Demo.currentCustomerID; //ändra till rätt
            int shoe_id = 1;                          //koppla till vald sko

            while (true) {
                System.out.println("Write a comment: ");
                comment = sc.nextLine().trim();
                System.out.println("How many points? 1-4 ");
                rating = sc.nextInt();
                System.out.println();
                // System.out.println(r.addReview(comment));
                System.out.println(r.addReview(comment, rating, customer_id, shoe_id));
                break;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //addReview();

    }


/*    public void addReview(){
        try {
            Repository r = new Repository();
            Scanner sc = new Scanner(System.in);
            String comment;
            int rating;
            int customer_id = Demo.currentCustomerID; //ändra till rätt
            int shoe_id = 0;                          //koppla till vald sko

            while (true) {
                System.out.println("Write a comment: ");
                comment = sc.nextLine().trim();
                System.out.println("How many points? 1-4 ");
                rating = sc.nextInt();
                System.out.println();
                // System.out.println(r.addReview(comment));
                System.out.println(r.addReview(comment, rating, customer_id, shoe_id));
                break;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/



    public static void main(String[] args) {
        new AddReview();
    }
}
