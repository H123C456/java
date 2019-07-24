package com.nikoer.helloworld;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("apple")
public class ThreeController {
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")

    public String hiHandle(HttpServletRequest request){

        String leng = request.getParameter("length");
        String star = request.getParameter("start");

        int starInt=Integer.parseInt(star);
        int lengInt=Integer.parseInt(leng);
        int length = 100;
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(100) + 1; // 1-100的随机数（此处100必须比length大，否则会死循环)
            System.out.println(number + ":" + list.size());
            if (!list.contains(number)) {
                list.add(number);
            } else {
                i--; // 保证生成的随机数个数足够，防止有重复随机数时造成空位
            }
        }

        ThreeController sorter = new ThreeController();
        sorter.sortHandle(list);
        List<Integer> targetList= new ArrayList<Integer>();


        for (int i = starInt;starInt+lengInt>i;i++){
            if(starInt+lengInt>list.size()) {
               break;
            }
            targetList.add(list.get(i));

        }



        return JSON.toJSONString(targetList);
    }

    public void sortHandle(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = 0; j < array.size() - i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
        ShowArray(array);
    }

    public void ShowArray(ArrayList<Integer> array) {
        for (int i : array) {
            System.out.print("<" + i);
        }

        System.out.println();
    }
}




