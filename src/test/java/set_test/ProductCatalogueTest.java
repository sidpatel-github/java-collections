package set_test;

import org.junit.Test;
import set.ProductCatalogue;
import set.TreeProductCatalogue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static set_test.ProductFixtures.*;

public class ProductCatalogueTest {

    @Test
    public void shouldOnlyHoldUniqueProducts() throws Exception {
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(sids);
        catalogue.isSuppliedBy(toms);
        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
    }
    
    @Test
    public void treeShouldOnlyHoldUniqueProducts() throws Exception {
        TreeProductCatalogue catalogue = new TreeProductCatalogue();

        catalogue.isSuppliedBy(sids);
        catalogue.isSuppliedBy(toms);
        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
    }

    @Test
    public void shouldFindLightVanProducts() throws Exception {
        TreeProductCatalogue catalogue = new TreeProductCatalogue();

        catalogue.isSuppliedBy(sids);
        catalogue.isSuppliedBy(toms);
        assertThat(catalogue.lightVanProducts(), containsInAnyOrder(window));
    }


    @Test
    public void shouldFindHeavyVanProducts() throws Exception {
        TreeProductCatalogue catalogue = new TreeProductCatalogue();

        catalogue.isSuppliedBy(sids);
        catalogue.isSuppliedBy(toms);
        assertThat(catalogue.heavyVanProducts(), containsInAnyOrder(door, floorPanel));
    }
}
