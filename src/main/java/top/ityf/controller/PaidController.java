package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.ityf.domain.*;
import top.ityf.service.PaidService;
import top.ityf.service.TopaidService;
import top.ityf.service.UserlistService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName:PaidController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/20 18:14
 * @Author: YanFei
 */
@Controller
@RequestMapping("/paid")
public class PaidController {
    @Autowired
    private PaidService paidService;

    @Autowired
    private TopaidService topaidService;

    @Autowired
    private UserlistService userlistService;


    /**
     * 管理员查找所有已缴租金列表
     */
    @RequestMapping("/findAllPaid")
    public String findAllPaid(Model model, QueryVO vo) {
        List<Paid> list = paidService.getByVo(vo);
        Double sum = paidService.getSumByVo(vo);
        model.addAttribute("paid", list);
        model.addAttribute("sum", sum);
        model.addAttribute("mainPage", "paid.jsp");
        model.addAttribute("vo", vo);
        return "admin/main2";
    }


    /**
     * 租客查找自己已缴租金列表
     */
    @RequestMapping("/findAllMyPaid")
    public String findAllMyPaid(HttpSession httpSession, Model model, QueryVO vo) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        vo.setUserlist_id(userlist.getId());
        List<Paid> list = paidService.getByVo(vo);
        Double sum = paidService.getSumByVo(vo);
        model.addAttribute("paid", list);
        model.addAttribute("sum", sum);
        model.addAttribute("mainPage", "mypaid.jsp");
        model.addAttribute("vo", vo);
        return "zuke/main3";
    }

    /**
     * 管理员删除已缴租金记录
     */
    @RequestMapping("/deletePaid")
    public String deletePaid(Integer id) {
        paidService.deletePaid(id);
        return "redirect:findAllPaid.go";
    }

    /**
     * 租客删除已缴租金记录
     */
    @RequestMapping("/deleteMyPaid")
    public String deleteMyPaid(Integer id) {
        paidService.deletePaid(id);
        return "redirect:findAllMyPaid.go";
    }

    /**
     * 管理员：我要收租页面
     */
    @RequestMapping("/showAddPaid")
    public String showAddPaid(Model model) throws Exception {
        List<Zulist> list = paidService.findZuUserlist();
        model.addAttribute("zulist", list);
        model.addAttribute("mainPage", "showaddpaid.jsp");
        return "admin/main2";
    }

    /**
     * 管理员点击收租后跳转到添加租金信息页面
     */
    @RequestMapping("/addPaid")
    public String addPaid(Integer id, Model model) {
        Zulist zulist = paidService.findZukeZulist(id);
        model.addAttribute("zulist", zulist);
        model.addAttribute("mainPage", "addpaid.jsp");
        return "admin/main2";
    }


    /**
     * 管理员添加租金信息到toPaid表(未缴租金)
     */
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @RequestMapping("/insertToPaid")
    public String insertToPaid(Topaid topaid, Model model) {
        //获取当前的时间，类型为 java.util.Date
        Date date = new Date();
        //将 java.util.Date类型转换成 java.sql.Date类型
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        //将当前时间存入wrong对象
        topaid.setDate(date1);
        topaidService.insertTopaid(topaid);
        model.addAttribute("error", "inserttopaid");
        return "redirect:showAddPaid.go";
    }


    /**
     * 管理员查看所有未缴租金信息
     */
    @RequestMapping("/toPaidList")
    public String toPaidList(Model model) {
        QueryVO vo = new QueryVO();
        List<Topaid> list = topaidService.findTopaidByUserlist_id(vo);
        model.addAttribute("topaid", list);
        model.addAttribute("mainPage", "topaid.jsp");
        return "admin/main2";
    }


    /**
     * 租客查看自己的未缴租金
     */
    @RequestMapping("/myTopaidList")
    public String myTopaidList(Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        QueryVO vo = new QueryVO();
        vo.setUserlist_id(userlist.getId());
        List<Topaid> topaid = topaidService.findTopaidByUserlist_id(vo);
        model.addAttribute("topaid", topaid);
        model.addAttribute("mainPage", "mytopaid.jsp");
        return "zuke/main3";
    }


    /**
     * 租客进行支付操作
     */
    @RequestMapping("/goToPay")
    public String goToPay(Integer id, Model model) {
        Date dt = new Date();
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
        String paydate = matter1.format(dt);
        Topaid topaid = topaidService.findById(id);
        Paid paid = new Paid();
        paid.setHouse_id(topaid.getHouse_id());
        paid.setAddress(topaid.getAddress());
        paid.setPrice(topaid.getPrice());
        paid.setDate(topaid.getDate());
        paid.setPaydate(paydate);
        paid.setName(topaid.getName());
        paid.setUserlist_id(topaid.getUserlist_id());
        paid.setStatus("租金已缴");
        topaidService.goToPay(id, paid);
        model.addAttribute("error", "paysucess");
        return "redirect:findAllMyPaid.go";
    }
}
