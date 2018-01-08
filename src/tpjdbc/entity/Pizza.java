package tpjdbc.entity;

/**
 *
 * @author dmr
 */
public class Pizza {

    private final int id;
    private String name;
    private float prix;

    public Pizza() {
        this.id = 0;
        this.name = null;
        this.prix = 0.0f;
    }

    public Pizza(int id, String name, float prix) {
        this.id = id;
        this.name = name;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Pizza{ id = " + id +
                           ", name = " + name + 
                           ", prix = " + prix + " }";
    }

}
