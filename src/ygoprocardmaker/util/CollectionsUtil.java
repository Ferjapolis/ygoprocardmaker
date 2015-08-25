package ygoprocardmaker.util;

import java.util.Arrays;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class CollectionsUtil {

    public static ObservableList<String> unmodifiableList(String... array) {
        return FXCollections.observableArrayList(Collections.unmodifiableList(Arrays.asList(array)));
    }
    
}
