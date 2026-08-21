package org.mercator.shoppingCart;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingCartTest {

    private final ShoppingCart cart = new ShoppingCart();

    @Test
    void emptyCartCostsNothing(){
        assertEquals("£0.00", cart.checkout(List.of()));
    }

    @Test
    void oneAppleCosts60p(){
        assertEquals("£0.60", cart.checkout(List.of("Apple")));
    }

    @Test
    void oneOrangeCosts25p(){
        assertEquals("£0.25", cart.checkout(List.of("Orange")));
    }

    @Test
    void calculatesTheTotalForMultipleItems() {
        assertEquals(
                "£2.05",
                cart.checkout(List.of("Apple", "Apple", "Orange", "Apple"))
        );
    }

    //test assumption
    @Test
    void rejectsUnknownItemsAssumingOnlyApplesAndOrangesAreValid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> cart.checkout(List.of("Banana"))
        );
    }
}
