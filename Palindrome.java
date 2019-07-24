package com.nikoer.helloworld.data;


import static sun.awt.FontConfiguration.verbose;

//185 递归 回文
public class Palindrome {
    public static void main(String[] argv) {
        for (int i = 0; i < argv.length; i++) {
            try {
                long l = Long.parseLong(argv[i]);
                if (l < 0) {
                    System.err.println(argv[i] + "-> Too SMALL");
                    continue;
                }
                System.out.println(argv[i] + "->" + findPalindrome(l));
            } catch (NumberFormatException e) {
                System.err.println(argv[i] + "->INVALID");
            } catch (IllegalStateException e) {
                System.err.println(argv[i] + "->" + e);
            }
        }
    }
    static long findPalindrome(long num){
            if (num <0)
                throw new IllegalStateException("negative");
            if(isPalindrome (num))
                return num;
            if(verbose)
                System.out.println("Trying"+num);
            return findPalindrome(num +reverseNumber(num));
    }
    protected static final int MAX_DIGITS = 19;

    static long[] digits  = new long[MAX_DIGITS];

    static boolean isPalindrome(long num){
        if(num>=0&&num<=9)
            return true;
        int nDigits = 0;

        while (num>0){
            digits[nDigits++] = num%10;
            num /= 10;
        }
        for(int i=0;i<nDigits/2;i++)


            if(digits[i] !=digits[nDigits -i-1])
                return false;
        return true;
    }
    static long reverseNumber(long num){
        int nDigits = 0;
        while (num>0){
            digits[nDigits++]=num%10;
            num/=10;
        }
        long ret = 0;
        for (int i=0;i<nDigits;i++){
            ret*=10;
            ret+=digits[i];
        }
        return ret;
    }
}

