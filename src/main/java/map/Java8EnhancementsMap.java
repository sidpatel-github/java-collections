package map;

import java.util.HashMap;
import java.util.Map;

public class Java8EnhancementsMap {

    public static void main(String[] args) {
        final Product defaultProduct = new Product(-1, "default name", 99);

        final Map<Integer, Product> mapProduct = new HashMap<>();
        mapProduct.put(1, ProductFixtures.door);
        mapProduct.put(2, ProductFixtures.floorPanel);
        mapProduct.put(3, ProductFixtures.window);

        System.out.println("==== get ====");
        Product result = mapProduct.get(5);
        System.out.println(result);
        System.out.println();

        System.out.println("==== get or default ====");
        //default value will not added on to original map
        result = mapProduct.getOrDefault(5, defaultProduct);
        System.out.println(result);
        System.out.println(mapProduct.get(5));
        System.out.println();

        System.out.println("==== replace ====");
        result = mapProduct.replace(1, new Product(1, "Second Door", 70));
        System.out.println(result);
        System.out.println(mapProduct.get(1));
        System.out.println();

        System.out.println("==== replace all ====");
        // this replace all will double the weight of all the existing products
        mapProduct.replaceAll((id, oldProduct) ->
                new Product(id, oldProduct.getName(), oldProduct.getWeight() * 2));
        System.out.println(mapProduct);
        System.out.println();

        System.out.println("==== compute if absent ====");
        //if the element is missing then it will add it otherwise give the existing one
        result = mapProduct.computeIfAbsent(10, (id) -> new Product(id, "Custom Product", 10));
        System.out.println(result);
        System.out.println(mapProduct.get(10));
        System.out.println();

        System.out.println("==== iteration from map ====");
        //iteration of map
        mapProduct.forEach((key, value) ->
        {
            System.out.println(key + " , " + value);
        });
    }
}
