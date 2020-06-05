package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import top.ityf.domain.User;
import top.ityf.domain.Userlist;
import top.ityf.service.UserlistService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:UserlistController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/16 15:35
 * @Author: YanFei
 */
@Controller
public class UserlistController {
    @Autowired
    private UserlistService userlistService;

    @RequestMapping("/findHasUserlist")
    public String findhasuserlist(HttpSession httpSession, Model model) throws Exception {
        User user1 = (User) httpSession.getAttribute("user");
        Integer user_id = user1.getId();
        Userlist userlist = userlistService.findHasUserlist(user_id);
        model.addAttribute("userlist", userlist);
        model.addAttribute("mainPage", "updateuserlist.jsp");
        return "zuke/main";

    }

    /**
     * 查找并更新用户信息
     */
    @RequestMapping("/checkUserlist")
    public String checkuserlist(Model model, Userlist userlist, HttpSession httpSession) throws Exception {
        //首先判断表单提交过来的User对象，id是否为空，如果为空则用Idcard查询
        //因为userlist表中有两个主键，分别是id和idcard
        if (userlist.getId() == null) {
            System.out.println("使用idcard查询");
            String idcard = userlist.getIdcard();
            Userlist list = userlistService.checkUserlist(idcard);
            if (list != null) {
                model.addAttribute("error", "该身份证已被绑定,一个身份证号码只能被一个账户绑定！");
                model.addAttribute("mainPage", "updateuserlist.jsp");
                model.addAttribute("userlist", userlist);
            } else {
                User user1 = (User) httpSession.getAttribute("user");
                Integer user_id = user1.getId();
                userlist.setUser_id(user_id);
                userlistService.insertUserlist(userlist);
                Userlist list1 = userlistService.checkUserlist(idcard);
                model.addAttribute("error", "资料完善成功!");
                model.addAttribute("mainPage", "updateuserlist.jsp");
                model.addAttribute("userlist", list1);
            }
        } else {
            System.out.println("使用id和idcard两个主键查询");
            Userlist list = userlistService.findUserlistUpdate(userlist);
            if (list != null) {
                model.addAttribute("error", "该身份证号码已被绑定");
                model.addAttribute("mainPage", "updateuserlist.jsp");
                model.addAttribute("userlist", userlist);
            } else {
                userlistService.updateUserlist(userlist);
                model.addAttribute("error", "更新成功");
                model.addAttribute("mainPage", "updateuserlist.jsp");
                model.addAttribute("userlist", userlist);
            }

        }
        return "zuke/main";
    }

    /**
     * 管理员查看用户列表
     */
    @RequestMapping("/findAllUserlist")
    public String findAllUserlist(Model model) {
        List<Userlist> userlist = userlistService.findAllUserlist();
        model.addAttribute("userlist", userlist);
        model.addAttribute("mainPage", "userlist.jsp");
        return "admin/main1";
    }


    /**
     * 管理员在用户列表页面删除用户信息，同时删除 User表和 Userlist表中对应的信息
     * */
    @RequestMapping("/deleteUserlist")
    public String deleteuserlist(Model model,Integer id) {
        userlistService.deleteUserlist(id);
        model.addAttribute("error", "deletesuccess");
        return "redirect:findAllUserlist.go";
    }

    /**
     * 管理员添加新用户，在 User表中插入记录
     * */
}
