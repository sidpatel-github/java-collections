package collection_operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffle {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(ProductFixtures.floorPanel);
        productList.add(ProductFixtures.door);
        productList.add(ProductFixtures.window);

        System.out.println(productList);
        System.out.println();

        Collections.shuffle(productList);
        System.out.println(productList);
        System.out.println();

        Collections.shuffle(productList);
        System.out.println(productList);
    }
}
