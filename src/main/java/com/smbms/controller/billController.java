package com.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("bill")
public class billController {
    @RequestMapping("/billList")
    public  String billList(){
        return "jsp/billlist";
    }
}
