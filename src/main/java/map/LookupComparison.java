package map;

import java.util.*;

public class LookupComparison {

    private static final int ITERATIONS = 5;
    private static final int NO_OF_PRODUCTS = 20000;

    private static final List<Product> products = generateProducts();

    private static List<Product> generateProducts() {
        final List<Product> products = new ArrayList<>();
        final Random weightGenerator = new Random();
        for (int i = 0; i < NO_OF_PRODUCTS; i++) {
            products.add(new Product(i, "Product " + i, 10 + weightGenerator.nextInt(10)));
        }
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

    private static void runLookups(final ProductLookupTable productLookupTable) {
        final List<Product> products = LookupComparison.products;

        System.out.println("checking performance using " + productLookupTable.getClass().getSimpleName());

        for (int i = 0; i < ITERATIONS; i++) {
            final long startTime = System.currentTimeMillis();

            for (Product product : products)
            {
                productLookupTable.addProduct(product);
            }
            for (Product product : products)
            {
                final Product result = productLookupTable.lookupById(product.getId());
                if (result != product)
                {
                    throw new IllegalStateException("Lookup Table returned wrong result for " + product);
                }
            }
            productLookupTable.clear();
            System.out.println(System.currentTimeMillis() - startTime + "ms");

        }
    }
    public static void main(String[] args)
    {
        runLookups(new MapProductLookUp());
        runLookups(new ArrayListProductLookUp());
    }

}
