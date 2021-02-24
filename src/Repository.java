import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    public int lastInsertedID = 0;

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

    public Connection addConnection(){
        Connection con = null;
        try {
           con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
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
                String stock = rs.getString("stock");

                products.add(new Product(id, price, color, size, model, brand, stock));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
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
        return customers;
    }

    public List<Product> getOrders(int orderId){
        List<Product> orders = new ArrayList<>();
        try (Connection con = addConnection();
             PreparedStatement pStat = con.prepareStatement("SELECT * FROM orders "+
                     "JOIN added ON added.order_id = orders.id "+
                     "JOIN shoe ON shoe.id = added.shoe_id "+
                     "JOIN has ON shoe.id = has.shoe_id "+
                     "JOIN color ON has.color_id = color.id "+
                     "JOIN sizing ON has.sizing_id = sizing.id "+
                     "JOIN price ON shoe.price_id = price.id " +
                     "JOIN model ON shoe.model_id = model.id "+
                     "JOIN brand On shoe.brand_id = brand.id "+
                     "WHERE added.order_id = ?")){

                            pStat.setInt(1, orderId);
                            ResultSet rs = pStat.executeQuery();


            while(rs.next()){
                int id = rs.getInt("id");
                Price price = new Price(rs.getInt("price_id"), rs.getInt("amount"));
                Color color = new Color(rs.getInt("color_id"), rs.getString("type"));
                Sizing size = new Sizing(rs.getInt("sizing_id"), rs.getString("sizing_sys"), rs.getInt("size"));
                Model model = new Model(rs.getInt("model_id"), rs.getString("name"), rs.getInt("year"));
                Brand brand = new Brand(rs.getInt("brand_id"), rs.getString("brand_name"));
                String stock = rs.getString("quantity");

                orders.add(new Product(id, price, color, size, model, brand, stock));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void printOrder(List<Product> orders){
        int x = 0;
        int totalAmount = 0;
        System.out.println("\nDin order: ");
        for (int i = 0; i < orders.size(); i++){
            System.out.println(orders.get(x).getBrand().getName() + ", " + orders.get(x).getModel().getName() + " Färg: " +
                    orders.get(x).getColor().getType() + " Storlek: " + orders.get(x).getSize().getSize()
                    + " Pris: " + orders.get(x).getPrice().getAmount() + " SEK" + " Antal: " + orders.get(x).getStock());
            x++;
        }
    }

    public void printShoes(){
        int x = 0;
        int y = 1;
        for (int i = 0; i < 9; i++){
            System.out.println("Sko nr: " + y + " " +products.get(x).getBrand().getName() + ", " + products.get(x).getModel().getName() + " Färg: " +
                    products.get(x).getColor().getType() + " Storlek: " + products.get(x).getSize().getSize()
                    + " Pris: " + products.get(x).getPrice().getAmount() + " SEK");
            x++;
            y++;
        }
    }

    public String addToCart(int customer_id, int shoe_id, int order_id){
        try{
            Connection con = addConnection();

            CallableStatement stmt = con.prepareCall("CALL AddToCart(?, ?, ?, ?)");

            stmt.setInt(1, customer_id);
            stmt.setInt(2, shoe_id);
            stmt.setInt(3, order_id);
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.execute();

            if (lastInsertedID == 0){
                lastInsertedID = stmt.getInt(4);
            }
            //System.out.println(lastInsertedID);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Shoe added to order";
    }

    public String addReview(String comment, int rating_id, int customer_id, int shoe_id){
        try {
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));

            CallableStatement stmt = con.prepareCall("CALL addReview(?, ?, ?, ?)");

            stmt.setString(1, comment);
            stmt.setInt(2, rating_id);
            stmt.setInt(3, customer_id);
            stmt.setInt(4, shoe_id);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "You have added a comment";
    }

    public ReviewObject getReview(int shoe_id){
        List<String> comments = new ArrayList<>();
        int averageScore = 0;
        ReviewObject ro = null;

        try {
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));

            CallableStatement stmt = con.prepareCall("{? = CALL get_average_rating_from_shoe(?)}");
            PreparedStatement pstmt = con.prepareStatement("SELECT review.comment, shoe.id FROM review\n" +
                    "    JOIN receives ON review.id = receives.review_id\n" +
                    "    JOIN shoe ON receives.shoe_id = shoe.id\n" +
                    "    WHERE shoe.id = ?");

            pstmt.setInt(1, shoe_id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                String comment = rs.getString("comment");
                comments.add(comment);

            }


            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setInt(2, shoe_id);
            stmt.execute();
            averageScore = stmt.getInt(1);
            ro = new ReviewObject(comments, averageScore, shoe_id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ro;
    }

    public static void main(String[] args) { new Repository();}
}


