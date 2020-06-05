package top.ityf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import top.ityf.domain.User;
import top.ityf.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ClassName:UserController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/10 8:28
 * @Author: YanFei
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String userList() {
        return "login";
    }


    /**
     * 当点击登陆按钮时，会根据表单传过来的User和数据库中的User匹配
     * 如果匹配到，则根据用户type返回对应的管理员/租客页面
     */
    @RequestMapping("/logincheck")
    public String login(User user, Model model, HttpSession httpSession) throws Exception {
        User user1 = userService.login(user);
        if (user1 != null) {
            httpSession.setAttribute("user",user1);
            if (user1.getType().equals("zuke")) {
                return "zuke/main";
            } else {
                return "admin/main1";
            }
        } else {
            String error = "error";
            model.addAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/toIndex")
    public String toIndex(HttpSession httpSession) throws Exception {
        User user = (User) httpSession.getAttribute("user");
        if (user.getType().equals("admin"))
            return "admin/main1";
        else
            return "zuke/main";
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:login.go";
    }
}
