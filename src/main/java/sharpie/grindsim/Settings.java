package sharpie.grindsim;

import java.security.*;
import java.util.*;

public abstract class Settings {

    public static Random random;


    public static void initialize() {

        try {
            
            random = SecureRandom.getInstance("NativePRNGNonBlocking");
            // System.out.println("faster pls");
        } catch (NoSuchAlgorithmException nsae) {

            random = new SecureRandom();
        }
    }
}