package org.deeplearning4j.optimize.listeners.stats.impl;

import java.nio.charset.Charset;

/**
 * Created by Alex on 02/10/2016.
 */
public class SbeUtil {

    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final byte[] EMPTY_BYTES = new byte[0];    //Also equivalent to "".getBytes(UTF8);

    public static int length(byte[] bytes) {
        if (bytes == null) return 0;
        return bytes.length;
    }

    public static int length(byte[][] bytes) {
        if (bytes == null) return 0;
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != null) count += bytes[i].length;
        }
        return count;
    }

    public static int length(String str) {
        if (str == null) return 0;
        return str.length();
    }

    public static int length(String[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        for (String s : arr) sum += length(s);
        return sum;
    }

    public static byte[] toBytes(boolean present, String str) {
        if (!present || str == null) return EMPTY_BYTES;
        return str.getBytes(UTF8);
    }

    public static byte[][] toBytes(boolean present, String[] str) {
        if (str == null) return null;
        byte[][] b = new byte[str.length][0];
        for (int i = 0; i < str.length; i++) {
            if (str[i] == null) continue;
            b[i] = toBytes(present, str[i]);
        }
        return b;
    }

}
