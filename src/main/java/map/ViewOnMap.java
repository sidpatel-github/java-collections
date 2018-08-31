package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewOnMap {
    public static void main(String[] args) {
        final Map<Integer, Product> mapProduct = new HashMap<>();
        mapProduct.put(1, ProductFixtures.door);
        mapProduct.put(2, ProductFixtures.floorPanel);
        mapProduct.put(3, ProductFixtures.window);

        final Set<Integer> ids = mapProduct.keySet();
        System.out.println("======= original ids and map =======");
        System.out.println(ids);
        System.out.println(mapProduct);

        System.out.println("======= ids and map after remove =======");
        ids.remove(1);
        System.out.println(ids);
        System.out.println(mapProduct);
        System.out.println();
        // This will throw an error
        //ids.add(4);
        System.out.println("======= values and map =======");
        final Collection<Product> values = mapProduct.values();
        System.out.println(values);
        System.out.println(mapProduct);

        values.remove(ProductFixtures.floorPanel);

        System.out.println("======= values and map after remove =======");
        System.out.println(values);
        System.out.println(mapProduct);

        System.out.println();
        System.out.println("======= map after set operation =======");
        final Set<Map.Entry<Integer, Product>> entries = mapProduct.entrySet();
        for (Map.Entry<Integer, Product> entry : entries) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
            entry.setValue(ProductFixtures.floorPanel);
        }

        System.out.println(mapProduct);
    }
}
