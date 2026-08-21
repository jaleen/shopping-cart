package org.mercator.shoppingCart;

import java.util.List;
import java.util.function.ToIntFunction;

public class ShoppingCart {

    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";

    public String checkout(List<String> of) {
        int totalInPence = of.stream().mapToInt(getPrice()).sum();
        return getFormatted(totalInPence);
    }

    private static ToIntFunction<String> getPrice() {
        return item -> switch (item) {
            case APPLE -> 60;
            case ORANGE -> 25;
            default -> throw new IllegalArgumentException("Unknown item: " + item);
        };
    }

    private static String getFormatted(int totalInPence) {
        return "£%d.%02d".formatted(totalInPence / 100, totalInPence % 100);
    }
}
