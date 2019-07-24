package com.nikoer.helloworld.data.CSV;

import java.util.List;

public class CSVSimple {
    public static void main (String[] args){
        CSVImport parser = new CSVSImport();
        List<String> list = parser.parse("\"LU\",86.25,\"11/4/1998\",\"2:19PM\",+4.0625");
        for(String word :list){
            System.out.println(word);
        }
       // parser=new CSVImport('|');
        list=parser.parse("\"LU\"|86.25|\"11/4/1998\"|\"2:19PM\"|+4.0625");
        for(String word :list){
            System.out.println(word);
        }
    }

    private static class CSVImport {


        public List<String> parse(String s) {
            this.parse(s);
            return null;
        }
    }
    private static class CSVSImport extends CSVImport {
    }
}
