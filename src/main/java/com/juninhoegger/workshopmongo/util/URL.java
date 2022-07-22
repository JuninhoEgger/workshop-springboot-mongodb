package com.juninhoegger.workshopmongo.util;

import java.io.UnsupportedEncodingException;

import static java.net.URLDecoder.decode;

public class URL {

    private URL() {

    }

    public static String decodeParam(String text) {
        try {
            return decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
