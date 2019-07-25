package com.nikoer.helloworld.data.Datas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//220
import static sun.security.krb5.internal.ktab.KeyTab.map;

public class HashMapDemo {
    public static void main(String[] argv){
        Map<String,String> map = new HashMap<String, String>();
        map.put("Adobe", "Mountain View, CA");
        map.put("IBM","While Plains, NY");
        map.put("Learnig Tree","Los Angeles, CA");
        map.put("O'Reilly", "Sebastopl, CA");
        map.put("sun", "Mountain View, CA");


        String queryString ="0'Reilly";
        System.out.println("you asked about "+ queryString+".");
        String resultString = map.get(queryString);
        System.out.println("They are located in:" + resultString);
        System.out.println();

        for(String key : map.keySet()){
            System.out.println("Key"+key+";Value"+map.get(key));
        }
        map.entrySet().forEach(mE -> System.out.println("Key+"+mE.getKey()+";Value"+mE.getValue()));

    }
}
