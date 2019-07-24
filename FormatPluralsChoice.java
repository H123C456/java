package com.nikoer.helloworld.data;
//171
import java.text.ChoiceFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("AO")


public class FormatPluralsChoice extends FormatPlurals {
    //@RequestMapping(value = "/OF",produces = "application/json;charset=UTF-8")

    static double[] limits = { 0, 1, 2};
    static String[] formats = {"reviews","review","reviews"};
    static ChoiceFormat pluralizedFormat = new ChoiceFormat(limits,formats);

    static ChoiceFormat quantizedFormat = new ChoiceFormat("O#no reviews|1#one review|1<many reviews");

    static int[] data = { -1, 0, 1, 2, 3};

    public static void main(String[] argv){
        System.out.println("Pluralized Format");
        for(int i:data){
            System.out.println("Found"+i+" "+pluralizedFormat.format(i));
        }
        System.out.println("Quantized Format");
        for(int i :data){
            System.out.println("Found"+quantizedFormat.format(i));
        }
    }
}
