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
    public List<Product> shoeOrder = new ArrayList<>();
    private String username;
    private String password;
    private int userChoice;
    private String userInput;
    private Boolean isCustomer = false;

    public Demo(){
        test();
    }

    public void test() {

        while (!isCustomer) {
            System.out.println("Välkommen till webshoppen! \nAnge ditt användarnamn: ");
            username = sc.nextLine();
            System.out.println("Ange ditt lösenord: ");
            password = sc.nextLine();

            for (int i = 0; i < r.customers.size(); i++) {
                if (username.equalsIgnoreCase(r.customers.get(i).getName()) && password.equalsIgnoreCase(r.customers.get(i).getPassword())) {
                    isCustomer = true;
                    r.printShoes();
                    addShoesToOrder();

                } else
                    System.out.println("Du har angett fel användarnamn eller lösenord.");
                break;
            }
        }
    }

    public void addShoesToOrder() {
        try {
            System.out.println("Välj vilken sko du vill lägga till din order, Ange sko nr:" +
                    "\nOm du vill gå vidare med ordern ange \"d\", ange \"q\" om du vill avbryta ordern ");
            userChoice = sc.nextInt();
            userInput = sc.nextLine();

            while (true) {
                if (userInput.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if (userInput.equalsIgnoreCase("d")) {
                    System.out.println("Du är nu klar med beställningen. Vill du se din order j/n");
                    if (userInput.equalsIgnoreCase("j")) {
                        printOrder();
                    } else if (userInput.equalsIgnoreCase("n")) {
                        System.out.println("Tack för ditt köp.");
                        break;
                    } else
                        System.out.println("Försök igen.");
                } else if (userChoice > 0 && userChoice < 10) {
                    shoeOrder.add(r.products.get(userChoice));
                } else
                    System.out.println("Fel inmatning, testa igen");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void printOrder() {
        int x = 0;
        for (int i = 0; i < shoeOrder.size(); i++) {
            System.out.println("Order:\nSko nr: " + "\n" + shoeOrder.get(x).getBrand().getName() + ", " + shoeOrder.get(x).getModel().getName() + "\nfärg: " +
                    shoeOrder.get(x).getColor().getType() + "\nstorlek: " + shoeOrder.get(x).getSize().getSize()
                    + "\npris: " + shoeOrder.get(x).getPrice().getAmount() + "\n");
        }
    }

    public static void main(String[] args) {
        new Demo();
    }

}

