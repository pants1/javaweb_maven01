package com.smbms.controller;
import com.alibaba.fastjson.JSON;
import com.smbms.entity.Role;
import com.smbms.entity.User;
import com.smbms.service.RoleMapperService;
import com.smbms.service.userMapperService;
import com.smbms.until.LoginSession;
import com.smbms.until.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    userMapperService userMapperService;
    @Autowired
    RoleMapperService roleMapperService;
    @RequestMapping("/add")
    public  String  add(Model model){
        User user = userMapperService.getByid(1);
        model.addAttribute("user",user);
        return "../user-view";
    }
    //供应管理
    @RequestMapping("/user.do")
//    @ResponseBody
    public  String  user(@ModelAttribute  User user,
                         HttpServletRequest request,
                         @RequestParam(value ="path",required=false) MultipartFile file) throws IOException {
        //1.获取项目实际路径
        String realPath = request.getServletContext().getRealPath("/statics/images/");
        //2.保存图片
        file.transferTo(new File(realPath+File.separator+file.getOriginalFilename()));
        //给User的IdPicPath赋值
        user.setIdPicPath("statics/images/"+file.getOriginalFilename());
        int count= userMapperService.addUser(user);
        System.out.println("count"+count);
        return "jsp/userview";
    }

    //    跳转添加用户页面
    @RequestMapping("/addUser.do")
    public  String    addUser(Model model){
        return "jsp/useradd";
    }
    //    异步展示role角色
    @RequestMapping("/RoleShow.do")
    @ResponseBody
    public  String  RoleShow(Model model){
        List<Role> all=userMapperService.getRoles();
        System.out.println("我到了");
        if(all.size()>0){
            return JSON.toJSONString(all);
        }
        return  null;
    }
    //展示列表页
    @RequestMapping("/userList.do")
    public  String  userList(Model model){
        List<Role> getroles = roleMapperService.getroles();
        model.addAttribute("roleList",getroles);
        return "jsp/userlist";
    }
    //验证 UserCode
    @RequestMapping("/UserCode.do")
    @ResponseBody
    public  String  UserCode(String userCode,Model model){
        User user= userMapperService.getByuserCode(userCode);
        if(user!=null){
            return  "false";
        }else{
            return  "true";
        }
    }
    @RequestMapping("/pswModify.do")
    public  String  pswModify(String rnewpassword,Model model,HttpSession session){
        User user = (User) session.getAttribute(LoginSession.SESSION_USER);
        Integer integer = userMapperService.pswModify(rnewpassword, user.getId());
        if(integer>0){
            return "../login";
        }else{
            return "jsp/pwdmodify";
        }
    }
    @RequestMapping("/login.do")
    public  String  login(@RequestParam String userCode,
                          @RequestParam String userPassword,
                          Model model, HttpSession httpSession){

        User user =userMapperService.getByuserCodeAnduserPassword(userCode,userPassword);
        if(user!=null){
            httpSession.setAttribute(LoginSession.SESSION_USER,user);
            model.addAttribute("userSession",user);
            return "jsp/frame";
        }else{
            model.addAttribute("error","用户名或者密码错误！");
            return "../login";
        }
    }
    @RequestMapping("/testingpwd.do")
    @ResponseBody
    public  String  testingpwd(String oldPassword, Model model,
                               HttpSession httpSession,
                               HttpServletResponse httpResponse,
                               HttpServletRequest httpRequest) throws IOException {
        if(httpSession.getAttribute(LoginSession.SESSION_USER)==null){
            String contextPath = httpRequest.getContextPath();
            httpResponse.sendRedirect(contextPath+"/login.jsp");
        }else{
            User user= (User) httpSession.getAttribute(LoginSession.SESSION_USER);
            if(user.getUserPassword().equals(oldPassword)){
                return "true";
            }else{
                return "false";
            }
        }
        return  null;
    }

    //模糊查询
    @RequestMapping("/queryList.do")
    public  String queryList(Model model,
                             String queryname,
                             Integer queryUserRole,
                             @RequestParam(defaultValue ="1")Integer beginPage,
                             @RequestParam(defaultValue="5")  Integer pagesize){
        List<Role> getroles = roleMapperService.getroles();
        model.addAttribute("roleList",getroles);
        //将数据模糊查询并且分页展示
        System.out.println("------------"+beginPage);
        Page page = userMapperService.PageSize(queryname, queryUserRole,beginPage, pagesize);
        List<Object> newsList = page.getNewsList();
        model.addAttribute("queryname",queryname);
        model.addAttribute("queryUserRole",queryUserRole);
        if(newsList.size()>0){
            model.addAttribute("userList",newsList);
            model.addAttribute("page",page);
        }else{
            model.addAttribute("data","暂无数据");
        }
        return "jsp/userlist";
    }
    //跳转到修改页面
    @RequestMapping("/pwdmodify.do")
    public  String    pwdmodify(Model model){
        return "jsp/pwdmodify";
    }

    // 删除用户操作
    @RequestMapping("/delectUser.do")
    @ResponseBody
    public  String    delectUser(String userid,Model model){
        Integer cout=userMapperService.delectUser(userid);
        if(cout>0){
            return "true";
        }else{
            return "false";
        }
    }
    //    修改用户操作    modifyUser
    @RequestMapping("/modifyUser.do")
    public  String    modifyUser(Integer userid,Model model){
        //更具id获得用户信息
        User user = userMapperService.getByid(userid);
        model.addAttribute("user",user);
        return "jsp/usermodify";
    }

    //修改用户操作modify
    @RequestMapping("/modify.do")
    public  String    modify(User user,Integer uid,Model model){
        user.setId(uid);
        Integer count=userMapperService.modify(user);
        return "redirect:/User/queryList.do" ;
    }
    //跳转到用户展示页面
    @RequestMapping("/UserView.do")
    public  String    UserView(Model model){
        return "jsp/userview";
    }

    //实现查看
    @RequestMapping("/ view.do{id}")
    public  String    view(@PathVariable("id")Integer userid,Model model){
        User user = userMapperService.getByid(userid);
        model.addAttribute("user",user);
        return "jsp/userview";
    }
}
