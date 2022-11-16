import java.util.*;

public class Main {

    static Set<Product> products = new HashSet<>();

    static List<Recipe> recipes = new ArrayList<>();

    static Set<Passport> passports = new HashSet<>();

    public static void main(String[] args) {

        // task ProductList & Recipes

        Product milk = new Product("Молоко", 89.99, 1);
        Product bananas = new Product("Бананы", 70.00, 5);
        Product bread = new Product("Хлеб", 39.50, 3);
        Product eggs = new Product("Яйца", 109.99, 5);
        Product cheese = new Product("Сыр", 210.00, 2);
        Product butter = new Product("Масло сливочное", 200.50, 1);


//        Recipe omelette = new Recipe(List.of(milk, butter, eggs), "Омлет");
//        Recipe milkshake = new Recipe(List.of(milk, bananas), "Банановый милкшейк");
//        Recipe sandwich = new Recipe(List.of(bread, cheese), "Бутерброд с сыром");
//        Recipe omelet = new Recipe(List.of(eggs, milk), "Омлет");
//
//        recipes.add(omelette);
//        recipes.add(milkshake);
//        recipes.add(sandwich);
//        addRecipe(omelet);

        HashMap<Product, Integer> omeletteRecipe = new HashMap<>();
        omeletteRecipe.put(milk, 1);
        omeletteRecipe.put(eggs, 2);
        omeletteRecipe.put(butter, 1);

        HashMap<Product, Integer> milkshakeRecipe = new HashMap<>();
        milkshakeRecipe.put(milk, 2);
        milkshakeRecipe.put(bananas, 2);

        HashMap<Product, Integer> sandwichRecipe = new HashMap<>();
        sandwichRecipe.put(bread, 1);
        sandwichRecipe.put(cheese, 1);

        System.out.println(getTotalProductsCost(omeletteRecipe));
        System.out.println(getTotalProductsCost(milkshakeRecipe));
        System.out.println(getTotalProductsCost(sandwichRecipe));

        //task Passport

        Passport ivan = new Passport("4514657897", "Иван", "Иванов", "Иванович", "05.08.1980");
        Passport maria = new Passport("4502718829", "Мария", "Сидорова", "Петровна", "07.09.1991");
        Passport maxim = new Passport("4516078365", "Максим", "Петров", "Алексеевич", "15.02.1999");
        Passport katya = new Passport("4515879463", "Екатерина", "Лебедева", "Викторовна", "25.05.1985");
        Passport vova = new Passport("4515879463", "Владимир", "Воробьев", "Сергеевич", "25.08.1988");
//        Passport bubble = new Passport("4515768463", null, "Воробьев", "Сергеевич", "25.08.1988");

        passports.add(ivan);
        passports.add(maria);
        passports.add(maxim);
        passports.add(katya);

        System.out.println(passports);

        System.out.println(findPassport("4515879463"));
        addPassport(vova, passports);
        System.out.println(passports);


    }
    public static double getTotalProductsCost(HashMap<Product, Integer> map) {
        double cost = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
          cost += entry.getKey().getPrice() * entry.getValue();
        }
        return cost;
    }


    public static void addProduct(Product product) {
        if (products.contains(product)) {
            throw new RuntimeException("Такой продукт уже есть в списке!");
        } else if (product.getName() == null || product.getPrice() <= 0 || product.getQuantity() <= 0) {
            throw new RuntimeException("Заполните карточку товара полностью!");
        } else {
            products.add(product);
        }
    }

    public static void removeProduct(Product product) {
        products.remove(product);
    }

    public static void buyProduct(Product product) {
        product.setBought(true);
        products.remove(product);
    }


    public static void addRecipe(Recipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipe.getName().equals(recipes.get(i).getName())) {
                throw new RuntimeException("Рецепт с таким названием уже существует!");
            } else {
                recipes.add(recipe);
            }
        }
    }

    public static Passport findPassport(String number) {
        for (Passport passport : passports) {
            if (number.equals(passport.getNumber())) {
                return passport;
            }
        }
        return null;
    }

    public static void addPassport(Passport passport, Set<Passport> set) {
        Iterator<Passport> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNumber().equals(passport.getNumber())) {
                iterator.remove();
            }
        }
        set.add(passport);

    }

}




