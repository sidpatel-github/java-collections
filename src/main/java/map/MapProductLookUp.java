package map;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookUp implements ProductLookupTable {

    private final Map<Integer, Product> mapProduct = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return mapProduct.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        final int id = productToAdd.getId();
        if (mapProduct.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate Id for " + productToAdd);
        }

        mapProduct.put(id, productToAdd);
    }

    @Override
    public void clear() {
        mapProduct.clear();
    }
}
