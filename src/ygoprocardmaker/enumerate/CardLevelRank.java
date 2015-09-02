package ygoprocardmaker.enumerate;

import javafx.collections.ObservableList;
import ygoprocardmaker.util.CollectionsUtil;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class CardLevelRank {
    
    public static final ObservableList<String> LEVEL_RANKS = CollectionsUtil.unmodifiableList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");

    public static int code(String rank) {
        int code;
        try {
            code = Integer.parseInt(rank);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (code < 0 || code > 13) {
            throw new IllegalArgumentException();
        }
        return code;
    }

    public static String rank(int code) {
        if (code < 0 || code > 13) {
            throw new IllegalArgumentException();
        }
        return Integer.toString(code);
    }
}
