import java.util.ArrayList;
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
        test();
        System.out.println(r.lastInsertedID);
    }

    public void test() {

        while (!isCustomer) {
            System.out.println("Välkommen till webshoppen! \nAnge ditt användarnamn: ");
            username = sc.nextLine();
            System.out.println("Ange ditt lösenord: ");
            password = sc.nextLine();

            List<Customer> customerList = r.getAllCustomers();

            for (int i = 0; i < customerList.size(); i++) {
                if (username.equalsIgnoreCase(customerList.get(i).getName())
                        && password.equalsIgnoreCase(customerList.get(i).getPassword())) {
                    isCustomer = true;
                    currentCustomerID = customerList.get(i).getId();
                    r.printShoes();
                    addShoesToOrder();
                    break;
                }
            }
            if (!isCustomer){
                System.out.println("Du har angett fel användarnamn eller lösenord, försök igen!");
            }
        }
    }

    public void addShoesToOrder() {
        try {
            while (true) {
                System.out.println("Välj vilken sko du vill lägga till din order, Ange sko nr:" +
                        "\nOm du vill gå vidare med ordern ange \"d\", ange \"q\" om du vill avbryta ordern \n");
                //userChoice = sc.nextInt();
                userInput = sc.nextLine();

                if (userInput.equalsIgnoreCase("q")) {
                    System.exit(0);
                }
                else if (userInput.equalsIgnoreCase("d")) {
                    System.out.println("Du är nu klar med beställningen. Vill du se din order j/n \n");
                    // hämta från added eller orders
                    userInput2 = sc.nextLine();
                    if (userInput2.equalsIgnoreCase("j")) {
                        r.printOrder(r.getOrders(r.lastInsertedID));
                        break;
                    } else if (userInput2.equalsIgnoreCase("n")) {
                        System.out.println("Tack för ditt köp.");
                        break;
                    } else
                        System.out.println("Försök igen.");
                }
                else if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) < 10) {
                    r.addToCart(currentCustomerID ,Integer.parseInt(userInput), r.lastInsertedID);
                    System.out.println("funkar");
                } else
                    System.out.println("Fel inmatning, testa igen");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Demo();

    }



}

