package ygoprocardmaker.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class RegexUtils {

    final private static Pattern POSITIVE_INTEGER = Pattern.compile("^[0-9]*([,]{1}[0-9]{0,2}){0,1}$");

    public static boolean isPositiveInteger(String input) {
        Matcher matcher = POSITIVE_INTEGER.matcher(input);
        return matcher.matches();
    }
}
