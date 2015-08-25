package ygoprocardmaker.util;

import java.io.File;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class FileUtils {
    
    public static String getApplicationPath() {
        return new File(".").getAbsolutePath();
    }
    
}
