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

                orders.add(new Product(id, price, color, size, model, brand));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void printOrder(List<Product> orders){
        int x = 0;
        for (int i = 0; i < orders.size(); i++){
            System.out.println(orders.get(x).getBrand().getName() + ", " + orders.get(x).getModel().getName() + "\nfärg: " +
                    orders.get(x).getColor().getType() + "\nstorlek: " + orders.get(x).getSize().getSize()
                    + "\npris: " + orders.get(x).getPrice().getAmount() + "\n");
            x++;
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
            System.out.println(lastInsertedID);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "You added shoe to order";
    }


/*    public String getProductsFromOrder(Orders order_id_input){
        Added a = new Added();
        if(order_id_input.equals(a.getOrderId())){
            if (getAllShoes().)
        }
    }*/

    //for var el :


    List<Product> getShoesFromOrder(List<>)

    public static void main(String[] args) { new Repository();}
}


