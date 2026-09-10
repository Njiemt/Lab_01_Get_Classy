
import java.util.Objects;

public class Product {

    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }

    public String toJSON() {
        return "{\"name\":\"" + name +
                "\",\"description\":\"" + description +
                "\",\"ID\":\"" + ID +
                "\",\"cost\":" + cost + "}";
    }

    public String toXML() {
        return "<Product>" +
                "<name>" + name + "</name>" +
                "<description>" + description + "</description>" +
                "<ID>" + ID + "</ID>" +
                "<cost>" + cost + "</cost>" +
                "</Product>";
    }

    @Override
    public String toString() {
        return name + " - " + description + " - " + ID + " - $" + cost;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product other = (Product) obj;

        return name.equals(other.name)
                && description.equals(other.description)
                && ID.equals(other.ID)
                && cost == other.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ID, cost);
    }
}

