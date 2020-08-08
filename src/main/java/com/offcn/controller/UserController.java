package com.offcn.controller;



import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;


    /*
         查询用户列表 add by
*/
    @GetMapping("/")
    public String findUserList(Model model){
      List userList = userService.findUserList();
      model.addAttribute("userList",userList);
      return "list";
    }
        @RequestMapping("/toAdd")
        public String toAdd(){
        return "userAdd";
        }


    @RequestMapping("/add")
    public String addUser(User user){
        try {
            userService.addUser(user);
            //资源重定向  页面发生二次跳转
            return "redirect:/user/";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable(name = "id")Long id,Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "userEdit";
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.updateUser(user,user.getId());
        return "redirect:/user/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Long id){
            userService.delete(id);
            return "redirect:/user/";
    }
}
