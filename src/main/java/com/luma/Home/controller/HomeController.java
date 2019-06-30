package com.luma.Home.controller;

import com.luma.Common.pojos.Users;
import com.luma.Common.utils.EDcrypt;
import com.luma.Home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("home/")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @Autowired
    private HttpSession httpSession;

    /**
     *
     * @param modelMap
     * @return String ==> html page
     */
    @RequestMapping("index.php")
    //@ResponseBody
    public String index(ModelMap modelMap) {
        //modelMap.addAttribute("msg","hello");

        return "login";
    }

    @RequestMapping("login.php")
    @ResponseBody
    public HashMap<String, Object> login(String uname, String upass) {
        //测试xssfilter是否起作用
        //System.out.println(uname+":"+upass);
        String url = "login";
        String code = "400";
        String msg = "bad";
        uname = EDcrypt.md5(uname);
        upass = EDcrypt.md5(upass);
        Users user = homeService.getUserByNameAndPwd(uname, upass);
        HashMap<String, Object> response = new HashMap<>();
        if(user!=null){
            httpSession.setAttribute("login", "admin");
            //modelMap.addAttribute("msg","hello, admin");
            url = "/home/user.php";
            code = "200";
            msg = "good";
        }
        response.put("url",url);
        response.put("code",code);
        response.put("msg",msg);

        return response;
    }

    @RequestMapping("user.php")
    //@ResponseBody
    public String user(ModelMap modelMap) {
        //modelMap.addAttribute("msg","hello");
        String url = "login";
        if(httpSession.getAttribute("login").equals("admin")){
            //modelMap.addAttribute("msg","hello, admin");
            url = "demo";
        }

        return url;
    }


    /**
     *
     * @param modelMap
     * @return String ==> html page
     */
    @RequestMapping("error.php")
    //@ResponseBody
    public String error(ModelMap modelMap) {
        modelMap.addAttribute("msg","hello");

        return "404";
    }
}
