package collection_operations;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rotate {

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(ProductFixtures.floorPanel);
        productList.add(ProductFixtures.door);
        productList.add(ProductFixtures.window);

        System.out.println(productList);
        System.out.println();

        Collections.rotate(productList, 1);
        System.out.println(productList);
        System.out.println();

        Collections.rotate(productList, 1);
        System.out.println(productList);
        System.out.println();

        Collections.rotate(productList, 1);
        System.out.println(productList);
    }
}
