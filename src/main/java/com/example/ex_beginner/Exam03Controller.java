package com.example.ex_beginner;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(){
        return "exam03";
    }

    @PostMapping("/result")
    public String result(String item1,String item2,String item3){
        int price1 = Integer.parseInt(item1);
        int price2 = Integer.parseInt(item2);
        int price3 = Integer.parseInt(item3);

        application.setAttribute("item1",price1);
        application.setAttribute("item2",price2);
        application.setAttribute("item3",price3);

        int notTaxPrice = price1 + price2 + price3;
        int taxPrice = (price1 + price2 + price3) * 11/10;

        application.setAttribute("notTaxPrice",String.format("%,d", notTaxPrice));
        application.setAttribute("taxPrice",String.format("%,d", taxPrice));

        return "exam03-result";
    }
}
