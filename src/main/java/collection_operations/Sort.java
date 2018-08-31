package collection_operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(ProductFixtures.floorPanel);
        productList.add(ProductFixtures.door);
        productList.add(ProductFixtures.window);

        System.out.println(productList);

        // This is introduced in Java 8
       // productList.sort(Product.BY_NAME);
        Collections.sort(productList, Product.BY_NAME);
        System.out.println(productList);

        Collections.sort(productList, Product.BY_WEIGHT);
        System.out.println(productList);

    }
}
