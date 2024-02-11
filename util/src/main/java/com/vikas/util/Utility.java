package com.vikas.util;

import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    public static int getNum(){
        return ThreadLocalRandom.current().nextInt();
    }
}
