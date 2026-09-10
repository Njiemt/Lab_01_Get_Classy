
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        product = new Product(
                "Laptop",
                "Gaming Laptop",
                "123456",
                799.99
        );
    }

    @Test
    void testConstructor() {
        assertEquals("Laptop", product.getName());
        assertEquals("Gaming Laptop", product.getDescription());
        assertEquals("123456", product.getID());
        assertEquals(799.99, product.getCost());
    }

    @Test
    void testSetName() {
        product.setName("Desktop");
        assertEquals("Desktop", product.getName());
    }

    @Test
    void testSetDescription() {
        product.setDescription("Office Desktop");
        assertEquals("Office Desktop", product.getDescription());
    }

    @Test
    void testSetCost() {
        product.setCost(999.99);
        assertEquals(999.99, product.getCost());
    }

    @Test
    void testToCSV() {
        assertEquals(
                "Laptop,Gaming Laptop,123456,799.99",
                product.toCSV()
        );
    }

    @Test
    void testToJSON() {
        assertEquals(
                "{\"name\":\"Laptop\",\"description\":\"Gaming Laptop\",\"ID\":\"123456\",\"cost\":799.99}",
                product.toJSON()
        );
    }

    @Test
    void testToXML() {
        assertEquals(
                "<Product><name>Laptop</name><description>Gaming Laptop</description><ID>123456</ID><cost>799.99</cost></Product>",
                product.toXML()
        );
    }

    @Test
    void testToString() {
        assertEquals(
                "Laptop - Gaming Laptop - 123456 - $799.99",
                product.toString()
        );
    }

    @Test
    void testEquals() {
        Product product2 = new Product(
                "Laptop",
                "Gaming Laptop",
                "123456",
                799.99
        );

        assertEquals(product, product2);
    }
}
