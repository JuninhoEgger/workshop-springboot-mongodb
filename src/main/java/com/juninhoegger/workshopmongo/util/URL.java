package com.juninhoegger.workshopmongo.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.net.URLDecoder.decode;
import static java.util.TimeZone.getTimeZone;

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

    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(getTimeZone("GMT"));
        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

}
