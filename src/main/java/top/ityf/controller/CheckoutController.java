package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.ityf.domain.Checkout;
import top.ityf.domain.User;
import top.ityf.domain.Userlist;
import top.ityf.service.CheckoutService;
import top.ityf.service.UserlistService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:CheckoutController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/19 17:49
 * @Author: YanFei
 */
@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private UserlistService userlistService;


    /**
     * 管理员获取已退租列表
     */
    @RequestMapping("/getAllCheckout")
    public String getallcheckout(Model model) {
        List<Checkout> checkout = checkoutService.findAllCheckout();
        model.addAttribute("checkout", checkout);
        model.addAttribute("mainPage", "checkout.jsp");
        return "admin/main2";
    }


    /**
     * 租客获取自己已退租的记录
     */
    @RequestMapping("/getMyCheckout")
    public String getMyCheckout(Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        List<Userlist> list = userlistService.getMyCheckout(userlist.getId());
        model.addAttribute("userlistcheck", list);
        model.addAttribute("mainPage", "mycheckout.jsp");
        return "zuke/main3";
    }

    /**
     * 租客删除自己已退租列表
     */
    @RequestMapping("/deleteCheckout")
    public String deleteCheckout(Integer id) {
        checkoutService.deleteCheckout(id);
        return "redirect:/checkout/getMyCheckout.go";
    }

    /**
     * 管理员删除已退租列表
     */
    @RequestMapping("/adminDeleteCheckout")
    public String adminDeleteCheckout(Integer id) {
        checkoutService.deleteCheckout(id);
        return "redirect:/checkout/getAllCheckout.go";
    }
}
