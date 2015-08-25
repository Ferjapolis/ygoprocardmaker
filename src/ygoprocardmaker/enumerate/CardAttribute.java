package ygoprocardmaker.enumerate;

import javafx.collections.ObservableList;
import ygoprocardmaker.util.CollectionsUtil;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class CardAttribute {

    public static final ObservableList<String> ATTRIBUTES = CollectionsUtil.unmodifiableList("EARTH", "WATER", "FIRE", "WIND", "LIGHT", "DARK", "DIVINE");

    public static int code(String attribute) {
        switch (attribute) {
            case "EARTH":
                return 1;
            case "WATER":
                return 2;
            case "FIRE":
                return 4;
            case "WIND":
                return 8;
            case "LIGHT":
                return 16;
            case "DARK":
                return 32;
            case "DIVINE":
                return 64;
            default:
                return 0;
        }
    }

    public static String attribute(int code) {
        switch (code) {
            case 1:
                return "EARTH";
            case 2:
                return "WATER";
            case 4:
                return "FIRE";
            case 8:
                return "WIND";
            case 16:
                return "LIGHT";
            case 32:
                return "DARK";
            case 64:
                return "DIVINE";
            default:
                throw new IllegalArgumentException();
        }
    }

}
