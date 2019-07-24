package com.nikoer.helloworld;

import java.util.ArrayList;
import java.util.Random;

public class Four {
    public static void main(String[] args) {
        int length = 50; // 50个随机数
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(100) + 1; // 1-100的随机数（此处100必须比length大，否则会死循环）
            if (!list.contains(number)) {
                list.add(number);
            } else {
                i--; // 保证生成的随机数个数足够，防止有重复随机数时造成空位
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(list.get(i) + "\t");

            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }
    }
}

