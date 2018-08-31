package collection_operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollection {
    private final List<Product> productList = new ArrayList<>();
    private int totalWeight = 0;

    public void add(Product product) {
        productList.add(product);
        totalWeight += product.getWeight();
     //   System.out.println("inside add");
    }

    public List<Product> getProductList() {
//        return productList;
        //this will not allow to modify the list and will throw a exception
        return Collections.unmodifiableList(productList);
    }

    @Override
    public String toString() {
        return "UnmodifiableCollection{" +
                "productList=" + productList +
                ", totalWeight=" + totalWeight +
                '}';
    }

    public static void main(String[] args) {
        UnmodifiableCollection unmodifiableCollection = new UnmodifiableCollection();
        unmodifiableCollection.add(ProductFixtures.door);
        System.out.println(unmodifiableCollection);

        unmodifiableCollection.getProductList().add(ProductFixtures.floorPanel);
        System.out.println(unmodifiableCollection);
    }
}
