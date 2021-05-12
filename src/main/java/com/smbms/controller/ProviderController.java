package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.entity.Provider;
import com.smbms.entity.User;
import com.smbms.service.impl.ProviderMapperServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/provider")
public class ProviderController{
    @Autowired
    ProviderMapperServiceimpl providerimpl;
    @RequestMapping("/show")
    public  String showList(Model model){
        List<Provider> list = providerimpl.getList();
        model.addAttribute("list",list);
        return "Provider/Provider_view";
    }
    @RequestMapping("/add")
    public  String add(Provider provider,Model model){
        Integer integer=providerimpl.addProvider(provider);
        if(integer>0){
            model.addAttribute("provider",provider);
            return "../jsp/providerview";
        }
        return "jsp/provideradd";
    }
    @RequestMapping("/pro.do")
    @ResponseBody
    public String JSON(String value,Model model){
        Provider provider = providerimpl.getBYCode(value);
        if(provider!=null){ //不能够添加，重复了
            return  "false";
        }else{
            return  "true";
        }
    }
    @RequestMapping("/query")
    public  String query(Integer id,Model model){
        Provider provider = providerimpl.queryBid(id);
        model.addAttribute("provider",provider);
        return "success";
    }

    //转发到供应商管理页面
    @RequestMapping("/ProviderList.do")
    public  String ProviderList(Integer id,Model model){
        return "jsp/providerlist";
    }
}
