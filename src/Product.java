import java.util.Objects;

public class Product {
    private final String name;
    private double price;
    private int quantity;
    private boolean isBought;

    public Product(String name, double price, Integer quantity) {
        this.name = name;
        this.price = price;
        if(quantity == (null) || quantity <= 0) {
            this.quantity = 1;
        } else {
        this.quantity = quantity;}
        this.isBought = false;
    }



    public Product(String name, double quantity) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Double.compare(product.quantity, quantity) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
