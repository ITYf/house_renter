package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.ityf.domain.Applyout;
import top.ityf.domain.User;
import top.ityf.domain.Userlist;
import top.ityf.domain.Zulist;
import top.ityf.service.ApplyoutService;
import top.ityf.service.UserlistService;
import top.ityf.service.ZulistService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:ApplyoutController
 * Package: top.ityf.controller
 * Description: 退租申请的表现层实现类
 *
 * @Date: 2020/4/19 19:16
 * @Author: YanFei
 */
@Controller
@RequestMapping("/applyout")
public class ApplyoutController {
    @Autowired
    private ZulistService zulistService;

    @Autowired
    private ApplyoutService applyoutService;

    @Autowired
    private UserlistService userlistService;


    /**
     * 当租客提交退租申请后，
     */
    @RequestMapping("/insertApplyout")
    public String insertApplyout(String house_id, Model model) {
        Zulist zulist = zulistService.findZulist(house_id);
        applyoutService.insertApplyout(zulist);
        model.addAttribute("error", "applysuccess");
        return "redirect:/zuList/myZulist.go";
    }

    /**
     * 管理员查看退租申请
     */
    @RequestMapping("/findAllApplyout")
    public String findAllApplyout(Model model) {
        List<Applyout> applyout = applyoutService.findAllApplyout();
        model.addAttribute("applyout", applyout);
        model.addAttribute("mainPage", "applyout.jsp");
        return "admin/main2";
    }


    /**
     * 租客查看自己的 退房申请
     */
    @RequestMapping("/getMyApplyout")
    public String getMyApplyout(Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        List<Userlist> list = userlistService.getMyApplyout(userlist.getId());
        model.addAttribute("userlist", list);
        model.addAttribute("mainPage", "myapplyout.jsp");
        return "zuke/main3";
    }


    /**
     * 管理员同意退租申请
     */
    @RequestMapping("/agreeApplyout")
    public String agreeApplyout(Model model, Integer id) {
        applyoutService.agreeApplyout(id);
        model.addAttribute("error", "applyoutsucess");
        return "redirect:findAllApplyout.go";
    }


    /**
     * 管理员拒绝退租申请
     */
    @RequestMapping("/refuseApplyout")
    public String refuseApplyout(Model model, Integer id) {
        Applyout applyout = new Applyout();
        applyout.setId(id);
        applyout.setStatus("已拒绝");
        applyoutService.updateApplyout(applyout);
        model.addAttribute("mainPage", "applyout.jsp");
        return "redirect:findAllApplyout.go";
    }


    /**
     * 管理员删除申请退租列表
     */
    @RequestMapping("/deleteApplyout")
    public String deleteApplyout(Model model, Integer id) {
        applyoutService.deleteApplyout(id);
        model.addAttribute("error", "deletesucess");
        return "redirect:findAllApplyout.go";
    }


    /**
     * 租客删除申请退租列表
     */
    @RequestMapping("/deleteMyApplyout")
    public String deleteMyApplyout(Model model, Integer id) {
        applyoutService.deleteApplyout(id);
        model.addAttribute("error", "deletesucess");
        return "redirect:getMyApplyout.go";
    }
}
