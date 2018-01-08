package tpjdbc.entity;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author dmr
 */
public class PizzaDAO {

    Connection connection;

    public PizzaDAO() throws Exception {

        Properties conf = new Properties();
        conf.load(new FileReader("src\\tpjdbc\\mysql.properties"));
        
        String driver = conf.getProperty("driver");
        String url = conf.getProperty("url");
        String user = conf.getProperty("user");
        String password = conf.getProperty("password");

        Class.forName(driver).newInstance();

        this.connection = DriverManager.getConnection(url, user, password);
    }

    public List<Pizza> findAll() throws SQLException {
            /* Création de l'objet gérant la requête préparée définie */
            PreparedStatement ps = connection.prepareStatement("SELECT id, nom, prix FROM pizzas");
            /* Execution de la requête préparée */
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Pizza> arrayPizza = new ArrayList();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String nomPizza = rs.getString(2);
                float prixPizza = rs.getFloat(3);
                Pizza pizza = new Pizza(id, nomPizza, prixPizza);
                
                arrayPizza.add(pizza);
            }
            
            return arrayPizza;
    }
    
    public void close() throws SQLException {
        this.connection.close();
    }
}
