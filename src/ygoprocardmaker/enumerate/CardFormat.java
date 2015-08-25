package ygoprocardmaker.enumerate;

import javafx.collections.ObservableList;
import ygoprocardmaker.util.CollectionsUtil;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class CardFormat {

    public static final ObservableList<String> FORMATS = CollectionsUtil.unmodifiableList("OCG", "TCG", "OCG/TCG", "Anime");

    public static int code(String format) {
        try {
            int index = FORMATS.indexOf(format);
            if (index == -1) {
                throw new IllegalArgumentException();
            }
            return index;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static String format(int code) {
        try {
            return FORMATS.get(code);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
