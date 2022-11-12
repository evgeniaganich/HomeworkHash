import java.util.List;
import java.util.Objects;

public final class Recipe {
    private List<Product> products;
    private double totalCost;
    private String name;

    public Recipe(List<Product> products, int totalCost, String name) {
        this.products = products;
        this.totalCost = totalCost;
        this.name = name;
    }

    public Recipe(List<Product> products, String name) {
        this.products = products;
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalCost() {
        for (int i = 0; i < (products.size() + 1); i++) {
            totalCost += products.get(i).getPrice();
        }
        return totalCost;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalCost, name);
    }
}
