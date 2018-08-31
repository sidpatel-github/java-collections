package collection_operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilities {
    public static void main(String[] args) {
        Product door = ProductFixtures.door;
        Product floorPanel = ProductFixtures.floorPanel;
        Product window = ProductFixtures.window;

        List<Product> productList = new ArrayList<>();
        Collections.addAll(productList, door, floorPanel, window);
        System.out.println(productList);

        Product max = Collections.max(productList, Product.BY_WEIGHT);
        System.out.println(max);


        Product min = Collections.min(productList, Product.BY_WEIGHT);
        System.out.println(min);
    }
}
