package com.nikoer.helloworld.data;
//114
public class Soundex {
    static boolean debug =false;

    public static final char[] MAP = {
            '0','1','2','3','0','1','2','0','0','2','2','4','5',

            '5','0','1','2','6','2','3','0','1','0','2','0','2',
    };
    public static String soundex (String s){
        String t = s.toUpperCase();

        StringBuffer res=new StringBuffer();
        char c,prev ='?',prevOutput = '?';

        for (int i=0;i<t.length()&&res.length()<4&&(c = t.charAt(i))!=',';i++){
            if(c>='A'&&c<='Z'&&c!=prev){
                prev=c;

                if(i==0){
                    res.append(c);
                }else {
                    char m=MAP[c-'A'];
                    if(debug){
                        System.out.println(c+"-->"+m);
                    }
                    if(m!='0'&&m!=prevOutput){
                        res.append(m);
                        prevOutput = m;
                    }
                }
            }
        }
        if(res.length()==0)
            return null;
        for(int i=res.length();i<4;i++)
            res.append('0');
        return res.toString();
        }
    }

