package tpjdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import tpjdbc.entity.Pizza;
import tpjdbc.entity.PizzaDAO;

/**
 *
 * @author dmr
 */
public class TPJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            PizzaDAO dao = new PizzaDAO();
            List<Pizza> pizzas = dao.findAll();

            for (Pizza p : pizzas) {
                System.out.println(p);
            }

            dao.close();

        } catch (IOException e) {
            System.err.println("Erreur : " + e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
            e.printStackTrace();
        }

    }

}
