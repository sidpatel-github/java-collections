package set_test;

import set.Product;
import set.Supplier;

public class ProductFixtures
{
    public static Product door = new Product("Wooden Door", 70);
    public static Product floorPanel = new Product("Floor Panel", 65);
    public static Product window = new Product("Glass Window", 30);


    public static Supplier sids = new Supplier("Sid's Household Supplies");
    public static Supplier toms = new Supplier("Tom's Home Goods");

    static
    {
        sids.products().add(door);
        sids.products().add(floorPanel);

        toms.products().add(window);
       // toms.products().add(door);

        //this will consider a different object if we don't implement hashcode and equal error
        toms.products().add(new Product("Glass Window", 30));
    }
}
