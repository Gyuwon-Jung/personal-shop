package com.gyuwon.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String introduce(){
        return "Hell";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "mypage";
    }

    @GetMapping("/date")
    @ResponseBody
    String date1(){
        Date date = new Date();
        return ZonedDateTime.now().toString();
    }
}
