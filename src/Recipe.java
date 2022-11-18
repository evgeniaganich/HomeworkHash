import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Recipe {
    private static HashMap<Product, Integer> products;
    private final String name;

    public Recipe(HashMap<Product, Integer> products, String name) {
        for (Integer value : products.values()) {
            if (value == null) {
                value = 1;
            }
        }
        Recipe.products = products;
        this.name = name;
    }


    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public static double getTotalCost(HashMap<Product, Integer> map) {
        double cost = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            cost += entry.getKey().getPrice() * entry.getValue();
        }
        return cost;
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
        return Objects.hash(name);
    }


}
