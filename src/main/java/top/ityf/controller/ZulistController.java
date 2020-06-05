package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ityf.domain.Contract;
import top.ityf.domain.User;
import top.ityf.domain.Userlist;
import top.ityf.domain.Zulist;
import top.ityf.service.UserlistService;
import top.ityf.service.ZulistService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName:ZulistController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/16 20:00
 * @Author: YanFei
 */
@Controller
@RequestMapping("/zuList")
public class ZulistController {
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private UserlistService userlistService;

    /**
     * 当管理员在看房申请列表里面，同意租赁后，页面跳转到添加合同这个Controller
     */
    @RequestMapping("/toAddContract")
    public String toAddHetong(Model model, String house_id) {
        Contract contract = new Contract();
        contract.setHouse_id(house_id);
        model.addAttribute("contract", contract);
        model.addAttribute("mainPage", "addhetong.jsp");

        return "admin/main2";
    }

    /**
     * 管理员查看所有在租列表
     */
    @RequestMapping("/findZulist")
    public String findZulist(Model model) throws Exception {
        List<Zulist> zulist = zulistService.findZuUserlist();
        model.addAttribute("zulist", zulist);
        model.addAttribute("mainPage", "zulist.jsp");
        return "admin/main2";
    }


    /**
     * 查看我的在租列表
     */
    @RequestMapping("/myZulist")
    public String myZulist(Model model, HttpServletRequest request) throws Exception {

        User user1= (User) request.getSession().getAttribute("user");
//        System.out.println(user1);
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
//        System.out.println(userlist);
        List<Userlist> list = userlistService.getUserZulist(userlist.getId());
//        System.out.println(list);
        model.addAttribute("userlistzu", list);
        model.addAttribute("mainPage", "myzulist.jsp");
        return "zuke/main3";
    }
}
