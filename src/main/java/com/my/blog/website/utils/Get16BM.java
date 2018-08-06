package com.my.blog.website.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Get16BM {
    private static int counter = 1;
    private static String currentTime = "";
    private static String machineNum="1";

    public Get16BM() {
    }

    protected static String format(int intval) {
        String formatted = String.valueOf(intval);
        StringBuffer buf = new StringBuffer("000");
        buf.replace(3 - formatted.length(), 3, formatted);
        return buf.toString();
    }

    private static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        return sdf.format(new Date());
    }

    public static String getUnquieID() {
        String currentTime;
        int c;
        do {
            currentTime = getCurrentTime();
            c = getCount(currentTime);
        } while(c == -1);

        return currentTime + machineNum + format(c);
    }

    protected short getHiTime() {
        return (short)((int)(System.currentTimeMillis() >>> 32));
    }

    protected int getLoTime() {
        return (int)System.currentTimeMillis();
    }

    protected static int getCount(String currentTime) {
        Class var1 = Get16BM.class;
        synchronized(Get16BM.class) {
            if(counter >= 1000 && currentTime.equals(currentTime)) {
                return -1;
            } else {
                if(counter < 1) {
                    counter = 1;
                }

                if(!currentTime.equals(currentTime)) {
                    currentTime = currentTime;
                    counter = 1;
                }

                return counter++;
            }
        }
    }

}