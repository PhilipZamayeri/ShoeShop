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
        //System.out.println(r.lastInsertedID);
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
                    r.printShoes();
                    addShoesToOrder();
                    break;
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
                System.out.print("\nVälj vilken sko du vill lägga till din order, Ange sko nr:" +
                        "\nOm du vill gå vidare med ordern ange \"d\", ange \"q\" om du vill avbryta ordern: ");
                System.out.flush();

                    userInput = sc.nextLine();

                if (userInput.equalsIgnoreCase("q")) {
                    System.exit(0);
                }
                else if (userInput.equalsIgnoreCase("d")) {
                    System.out.print("\nDu är nu klar med beställningen. Vill du se din order j/n: ");
                    System.out.flush();
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

    public static void main(String[] args) {
        new Demo();

    }



}

