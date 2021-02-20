import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:32
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Repository {
    public Properties p = new Properties();
    public List<Product> products = new ArrayList<>();
    public List<Customer> customers = new ArrayList<>();

    public Repository() {
        try {
            p.load(new FileInputStream("src/config.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        getAllShoes();
        getAllCustomers();
    }

    public Connection addConnection() throws SQLException {
        Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
        return con;
    }


    public void getAllShoes() {

        try (Connection con = addConnection();
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM shoe " +
                     "JOIN has ON shoe.id = has.shoe_id " +
                     "JOIN color ON has.color_id = color.id " +
                     "JOIN sizing ON has.sizing_id = sizing.id " +
                     "JOIN price ON shoe.price_id = price.id " +
                     "JOIN model ON shoe.model_id = model.id " +
                     "JOIN brand On shoe.brand_id = brand.id")){


            while(rs.next()){
                int id = rs.getInt("id");
                Price price = new Price(rs.getInt("price_id"), rs.getInt("amount"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("type"));
                Sizing size = new Sizing(rs.getInt("sizing_id"), rs.getString("sizing_sys"), rs.getInt("size"));
                Model model = new Model(rs.getInt("model_id"), rs.getString("name"), rs.getInt("year"));
                Brand brand = new Brand(rs.getInt("brand_id"), rs.getString("brand_name"));

                products.add(new Product(id, price, color, size, model, brand));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getAllCustomers(){

        try (Connection con = addConnection();
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM customer " +
                     "JOIN payment ON customer.payment_id = payment.id")){


            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String ssn = rs.getString("ssn");
                String number = rs.getString("number");
                String password = rs.getString("password");
                Payment payment = new Payment(rs.getInt("payment_id"), rs.getString("method"));

                customers.add(new Customer(id, name, ssn, number, password, payment));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printShoes(){
        int x = 0;
        int y = 1;
        for (int i = 0; i < 9; i++){
            System.out.println("Sko nr: " + y + "\n"+products.get(x).getBrand().getName() + ", " + products.get(x).getModel().getName() + "\nfärg: " +
                    products.get(x).getColor().getType() + "\nstorlek: " + products.get(x).getSize().getSize()
                    + "\npris: " + products.get(x).getPrice().getAmount() + "\n");
            x++;
            y++;
        }
    }

    public void printCustomers(){
        int x = 0;
        for (int i = 0; i < 5; i++){
            System.out.println(customers.get(x).getName() + ", " + customers.get(x).getSsn() + "\nnummer: " +
                    customers.get(x).getNumber() + "\nbetalningsmetod: " + customers.get(x).getPaymentId().getMethod()
                    + "\n");
            x++;
        }
    }

    /*
    public void printOrder(){
            ResultSet rs = null;
            try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"))){
                CallableStatement stmt = con.prepareCall("call AddToCart(?)");
                stmt.setString(1,name);
                stmt.execute();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
     */



    public static void main(String[] args) { new Repository();}
}


