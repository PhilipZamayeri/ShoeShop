import java.util.List;
import java.util.Scanner;

/**
 * Created by Philip Zamayeri
 * Date: 2021-02-20
 * Time: 10:42
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Demo {

    private Repository r = new Repository();
    private Scanner sc = new Scanner(System.in);
    private String username;
    private String password;
    private String userInput;
    private String userInput2;
    private Boolean isCustomer = false;
    public static int currentCustomerID;

    public Demo(){
        logIn();
    }

    public void logIn() {
        while (!isCustomer) {
            System.out.print("Välkommen till webshoppen! \nAnge ditt användarnamn: ");
            System.out.flush();
            username = sc.nextLine();
            System.out.print("Ange ditt lösenord: ");
            System.out.flush();
            password = sc.nextLine();
            System.out.println();

            List<Customer> customerList = r.getAllCustomers();

            for (int i = 0; i < customerList.size(); i++) {
                if (username.equalsIgnoreCase(customerList.get(i).getName())
                        && password.equalsIgnoreCase(customerList.get(i).getPassword())) {
                    isCustomer = true;
                    currentCustomerID = customerList.get(i).getId();

                    System.out.println("Vill du handla, ange 1" +
                            "\nVill du betygsätta en produkt, ange 2" +
                            "\nVill du se betyg på en produkt, ange 3");
                    int val = sc.nextInt();
                    sc.nextLine();

                    if (val == 1){
                        r.printShoes();
                        addShoesToOrder();
                    }
                    else if (val == 2){
                        addReview();
                    }
                    else if (val == 3){
                        getReview();
                    }
                    else System.out.println("Fel inmatning");
                }
            }
            if (!isCustomer){
                System.out.println("Du har angett fel användarnamn eller lösenord, försök igen! \n");
            }
        }
    }

    public void addShoesToOrder() {
        try {
            while (true) {
                chooseOption();
                userInput = sc.nextLine();

                if (userInput.equalsIgnoreCase("q")) {
                    cancelOrder();
                }
                else if (userInput.equalsIgnoreCase("d")) {
                    doneWithOrder();
                }
                else if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) < 10) {
                    chooseShoe();
                }
                else{
                    System.out.println("Fel inmatning, testa igen");
                }
            }
        }
        catch (NumberFormatException e){
            System.out.println("Fel inmatning");
            addShoesToOrder();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void chooseOption(){
        System.out.print("\nVälj vilken sko du vill lägga till din order, Ange sko nr:" +
                "\nOm du vill gå vidare med ordern ange \"d\", ange \"q\" om du vill avbryta ordern: ");
        System.out.flush();
    }

    public void cancelOrder(){
        System.out.println("\nDu har valt att avbryta ordern.");
        System.exit(0);
    }

    public void doneWithOrder(){
        System.out.print("\nDu är nu klar med beställningen. Vill du se din order j/n: ");
        System.out.flush();
        userInput2 = sc.nextLine();
        if (userInput2.equalsIgnoreCase("j")) {
            r.printOrder(r.getOrders(r.lastInsertedID));
            System.exit(0);
        } else if (userInput2.equalsIgnoreCase("n")) {
            System.out.println("Tack för ditt köp.");
            System.exit(0);
        } else
            System.out.println("Försök igen.");
    }

    public void chooseShoe(){
        System.out.println(r.addToCart(currentCustomerID ,Integer.parseInt(userInput), r.lastInsertedID));
    }

    public void addReview(){
        r.printShoes();
        Repository r = new Repository();
        Scanner sc = new Scanner(System.in);
        String comment;
        int rating;
        int customer_id = currentCustomerID; //ändra till rätt
        int shoe_id;                          //koppla till vald sko

        while (true) {
            System.out.println("\nWrite a comment: ");
            comment = sc.nextLine().trim();
            System.out.println("How many points? 1-4 ");
            rating = sc.nextInt();
            System.out.println("Välj vilken sko du vill betygsätta: ");
            shoe_id = sc.nextInt();
            System.out.println(r.addReview(comment, rating, customer_id, shoe_id));
            break;
            }
    }

    public void getReview(){
        r.printShoes();
        int shoe_id;
        System.out.print("\nVälj vilken sko du vill se betyg på: ");
        System.out.flush();
        shoe_id = sc.nextInt();
        System.out.println(r.getReview(shoe_id));
    }

    public static void main(String[] args) {
        new Demo();
    }

}

