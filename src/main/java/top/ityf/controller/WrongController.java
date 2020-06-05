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
import top.ityf.service.SolveService;
import top.ityf.service.UserlistService;
import top.ityf.service.ZulistService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName:WrongController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/19 20:52
 * @Author: YanFei
 */
@Controller
@RequestMapping("/wrong")
public class WrongController {
    @Autowired
    private SolveService solveService;

    @Autowired
    private UserlistService userlistService;

    @Autowired
    private PaidService paidService;

    @Autowired
    private ZulistService zulistService;


    /**
     * 管理员查找所有已处理的报障
     */
    @RequestMapping("/findAllSolved")
    public String selectall(Model model, QueryVO vo) {
        List<Solve> list = solveService.getAll(vo);
        Integer count = solveService.getCount(vo);
        model.addAttribute("solve", list);
        model.addAttribute("count", count);
        model.addAttribute("mainPage", "solved.jsp");
        model.addAttribute("vo", vo);
        return "admin/main2";
    }


    /**
     * 租客查找自己已处理的报障
     */
    @RequestMapping("/findMySolved")
    public String findMySolved(HttpSession httpSession, Model model, QueryVO vo) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        vo.setUserlist_id(userlist.getId());
        List<Solve> list = solveService.getAll(vo);
        Integer count = solveService.getCount(vo);
        model.addAttribute("solve", list);
        model.addAttribute("count", count);
        model.addAttribute("mainPage", "mysolved.jsp");
        model.addAttribute("vo", vo);
        return "zuke/main3";
    }


    /**
     * 管理员删除已处理报障记录
     */
    @RequestMapping("/deleteSolved")
    public String deleteSolved(Integer id) {
        solveService.deleteSolve(id);
        return "redirect:findAllSolved.go";
    }

    /**
     * zuke删除自己的已处理报障记录
     */
    @RequestMapping("/deleteMySolved")
    public String deleteMySolved(Integer id) {
        solveService.deleteSolve(id);
        return "redirect:findMySolved.go";
    }

    /**
     * 租客跳到我要报障页面
     * 这里首先展示租客的租房记录，然后租客可以根据对应的记录申请报障
     */
    @RequestMapping("/showAddWrong")
    public String showAddWrong(HttpSession httpSession, Model model) throws Exception {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        List<Zulist> list = zulistService.findZulistByUid(userlist.getId());
        model.addAttribute("zulist", list);
        model.addAttribute("mainPage", "showaddwrong.jsp");
        return "zuke/main3";
    }


    /**
     * 点击报障后跳转到添加报障信息页面
     */
    @RequestMapping("/addWrong")
    public String addWrong(Integer id, Model model) {
        System.out.println(id);
        Zulist zulist = paidService.findZukeZulist(id);
        System.out.println(zulist);
        model.addAttribute("zulist", zulist);
        model.addAttribute("mainPage", "addwrong.jsp");
        return "zuke/main3";
    }

    /**
     * 添加报障信息到wrong表
     *
     * 在遇到java.spl.Date或java.util.Date时，
     * 可能出现的错误：由于被认为是客户端对错误（例如：畸形的请求语法、无效的请求信息帧或者虚拟的请求路由），服务器无法或不会处理当前请求。
     * 原因：客户端传进来的数据类型和实体类的数据类型不一致
     * 解决：方法一是自定义类型转换器，方法二是采用 @DateTimeFormat注解
     */
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @RequestMapping("/insertWrong")
    public String insertWrong(Wrong wrong, Model model) {
        //获取当前的时间，类型为 java.util.Date
        Date date = new Date();
        //将 java.util.Date类型转换成 java.sql.Date类型
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        //将当前时间存入wrong对象
        wrong.setDate(date1);
        solveService.insertWrong(wrong);
        model.addAttribute("error", "insertwrong");
        return "redirect:showAddWrong.go";
    }

    /**
     * 管理员查看所有未处理报障
     */
    @RequestMapping("/wrongList")
    public String wrongList(Model model) {
        QueryVO vo = new QueryVO();
        List<Wrong> list = solveService.findWrong(vo);
        System.out.println(list);
        model.addAttribute("wrong", list);
        model.addAttribute("mainPage", "wrong.jsp");
        return "admin/main2";
    }


    /**
     * 租客查看自己的未处理报障
     */
    @RequestMapping("/myWrongList")
    public String myWrongList(Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        System.out.println(userlist);
        QueryVO vo = new QueryVO();
        vo.setUserlist_id(userlist.getId());
        List<Wrong> list = solveService.findWrong(vo);
        System.out.println(list);
        model.addAttribute("wrong", list);
        model.addAttribute("mainPage", "mywrong.jsp");
        return "zuke/main3";
    }


    /**
     * 管理员处理报障
     */
    @RequestMapping("/goToSolve")
    public String goToSolve(Integer id, Model model) {

        Wrong wrong = solveService.findWrongById(id);
        Solve solve = new Solve();
        solve.setHouse_id(wrong.getHouse_id());
        solve.setAddress(wrong.getAddress());
        solve.setDate(wrong.getDate());
        solve.setDetail(wrong.getDetail());
        solve.setName(wrong.getName());
        solve.setUserlist_id(wrong.getUserlist_id());
        solve.setStatus("已处理");
        solveService.goToSolve(id, solve);
        model.addAttribute("error", "duesucess");
        return "redirect:findAllSolved.go";
    }
}
