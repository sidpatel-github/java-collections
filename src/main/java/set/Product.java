package set;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class Product {

    public static final Comparator<Product> BY_NAME = comparing(Product::getName);
    public static final Comparator<Product> BY_WEIGHT = comparing(Product::getWeight);
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) return false;

        final Product product = (Product) obj;

        return Objects.equals(weight, product.weight) && Objects.equals(name, product.name);

    }
}
