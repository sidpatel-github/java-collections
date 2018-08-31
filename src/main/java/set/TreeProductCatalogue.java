package set;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeProductCatalogue implements Iterable<Product> {

    private static final int LIGHT_VAN_MAX_WEIGHT = 50;

    // if we don't pass constructor here then there will be error as it don't know the sorting method
    private SortedSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);
    //private Set<Product> products = new TreeSet<>(Product.BY_NAME);

    public void isSuppliedBy(Supplier supplier) {
        products.addAll(supplier.products());
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public SortedSet<Product> lightVanProducts() {
        Product lightestHeavyVanProduct = findLightestHeavyVanProduct();
        return products.headSet(lightestHeavyVanProduct);
    }

    public SortedSet<Product> heavyVanProducts() {
        Product lightestHeavyVanProduct = findLightestHeavyVanProduct();
        return products.tailSet(lightestHeavyVanProduct);
    }

    private Product findLightestHeavyVanProduct() {
        for (Product product : products) {
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return product;
            }
        }
        return products.last();
    }
}
