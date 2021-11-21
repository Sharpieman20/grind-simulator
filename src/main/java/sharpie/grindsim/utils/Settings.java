
package sharpie.grindsim.utils;

import sharpie.grindsim.splits.overworld.monument.MonumentWorldSampler;

import java.security.*;
import java.util.*;

public abstract class Settings {

    public static Random random;

    public static final double WORLDGEN_TIME = 6.0;

    public static final double OCEAN_TRAVEL_CONSTANT = 5.0;


    public static void initialize() {

        try {
            
            random = SecureRandom.getInstance("NativePRNGNonBlocking");
            // System.out.println("faster pls");
        } catch (NoSuchAlgorithmException nsae) {

            random = new SecureRandom();
        }

//        MonumentWorldSampler.init();
    }
}