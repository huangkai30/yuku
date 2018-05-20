package com.lastcompany.haiwaicang.util;

import java.util.HashMap;
import java.util.Map;

public class MYSQLEncoder {

    private static Map<String,String> referencesMap = new HashMap<String,String>();
    private static Map<String,String> decodeReferencesMap = new HashMap<String,String>();

    static{
        referencesMap.put("'","\\'");
        referencesMap.put("\"","\\\"");
        referencesMap.put("\\","\\\\");

        referencesMap.put("\n","\\\n");
        referencesMap.put("\0","\\\0");
        referencesMap.put("\b","\\\b");
        referencesMap.put("\r","\\\r");
        referencesMap.put("\t","\\\t");
        referencesMap.put("\f","\\\f");
    }

    static{
        decodeReferencesMap.put("\\'","'");
        decodeReferencesMap.put("\\\"","\"");
        decodeReferencesMap.put("\\\\","\\");

        decodeReferencesMap.put("\\\n","\n");
        decodeReferencesMap.put("\\\0","\0");
        decodeReferencesMap.put("\\\b","\b");
        decodeReferencesMap.put("\\\r","\r");
        decodeReferencesMap.put("\\\t","\t");
        decodeReferencesMap.put("\\\f","\f");
    }

    //escape sql tag with the source code.
    public static String encode(String source) {
        if (source == null)
            return "";

        StringBuffer sbuffer = new StringBuffer(source.length());

        for (int i = 0; i < source.length(); i++) {
            String c = source.substring(i,i+1);


            if (referencesMap.get(c) != null) {
                sbuffer.append(referencesMap.get(c));
            } else {
                sbuffer.append(c);
            }
        }
        return sbuffer.toString();
    }

    public static String decode(String source) {
        if (source == null)
            return "";

        StringBuffer sbuffer = new StringBuffer(source.length());

        for (int i = 0; i < source.length(); i++) {
            String c = source.substring(i,i+1);


            if (decodeReferencesMap.get(c) != null) {
                sbuffer.append(decodeReferencesMap.get(c));
            } else {
                sbuffer.append(c);
            }
        }
        return sbuffer.toString();
    }


}