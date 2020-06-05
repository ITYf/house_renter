package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.ityf.domain.*;
import top.ityf.service.ApplyService;
import top.ityf.service.HouselistService;
import top.ityf.service.UserlistService;
import top.ityf.service.ZulistService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:ApplyController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/10 8:23
 * @Author: YanFei
 */
@Controller
public class ApplyController {
    @Autowired
    private UserlistService userlistService;

    @Autowired
    private HouselistService houselistService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private ZulistService zulistService;

    /**
     * 租客申请看房
     * <p>
     * 这个步骤有点复杂，注释一下
     * 第一步：更加登陆的用户信息，从session中获取到 User对象，并拿到id
     * 第二步：通过userid查询这个用户是否在数据库中userlist表中，如果不在，则重定向到houseList页面
     * 如果在，第三步：根据穿到后台的id(也就是 houselist_id)获取到这条houselist记录，把状态改为已被申请，并更新记录
     * 注意：在这里查到的houselist记录都是未被租赁的，因为前面已经过滤了已租赁的记录
     * 最后：把查询到的houselist中的属性值设置到apply对象中，把状态置为申请中，并插入这条记录
     */
    @RequestMapping("/applyCheckUserlist")
    public String applyCheckUserlist(HttpSession httpSession, Model model, Integer id) {
        User user1 = (User) httpSession.getAttribute("user");
        Integer user_id = user1.getId();
        Userlist list = userlistService.findHasUserlist(user_id);
        if (list == null) {
            model.addAttribute("error", "fail");
            return "redirect:houseList.go";
        } else {
            Houselist houselist = houselistService.findById(id);
            houselist.setStatus("已被申请");
            houselistService.updateHouseStatusById(houselist);
            Integer userlist_id = list.getId();
            Apply apply = new Apply();
            apply.setHouse_id(houselist.getHouseid());
            apply.setAddress(houselist.getAddress());
            apply.setPrice(houselist.getPrice());
            apply.setArea(houselist.getArea());
            apply.setStatus("申请中");
            apply.setUserlist_id(userlist_id);
            applyService.insertApply(apply);
            model.addAttribute("error", "applySuccess");
            return "redirect:houseList.go";

        }

    }


    /**
     * 管理员查看申请看房列表
     * <p>
     * 这里使用联合查询，只有当apply记录中的userid字段在userliat中存在时才可以查到。也就是说，用户必须绑定过账户才可以
     */
    @RequestMapping("/findApplyList")
    public String findapplylist(Model model) throws Exception {

        List<Apply> applylist = applyService.findApplyList();
        model.addAttribute("applylist", applylist);
        model.addAttribute("mainPage", "applylist.jsp");
        return "admin/main1";
    }


    /**
     * 管理员同意租赁
     * 当管理员同意之后，就会转发到签订合同页面
     */
    @RequestMapping("/applyChangeHousestatus")
    public String applyChangeHousestatus(HttpSession httpSession, Model model, String house_id) throws Exception {
        User user1 = (User) httpSession.getAttribute("user");
        Integer user_id = user1.getId();
        Userlist userlist = userlistService.findHasUserlist(user_id);
        Houselist houselist = houselistService.findByHouse_id(house_id);
        houselist.setStatus("已租赁");
        houselistService.updateHouseStatusById(houselist);
        Zulist zulist = new Zulist();
        zulist.setHouse_id(house_id);
        zulist.setPrice(houselist.getPrice());
        zulist.setAddress(houselist.getAddress());
        zulistService.insertZulist(zulist);
        model.addAttribute("houselist", houselist);

        //当使用请求或转发关键字来跳转页面的时候，视图解析器就无效了，所以路径要写正确
        return "redirect:zuList/toAddHeTong.go";
    }


    /**
     * 管理员拒绝看房申请
     * 两个步骤，这两个步骤在service中实现
     * 首先更新 houselist中对应记录的状态，表示可以申请看房
     * 然后是删除这条申请
     */
    @RequestMapping("/refuseApply")
    public String refuseapply(String house_id, Model model) {
        Houselist houselist = new Houselist();
        houselist.setHouseid(house_id);
        houselist.setStatus("未租赁");
        applyService.refuseApply(houselist);

        return "redirect:findApplyList.go";
    }


    //租客查看自己的 看房申请
    @RequestMapping("/getMyApply")
    public String getmyapply(Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        Userlist userlist = userlistService.findHasUserlist(user1.getId());
        List<Userlist> list = userlistService.getMyApply(userlist.getId());
        model.addAttribute("userlist", list);
        model.addAttribute("mainPage", "myapply.jsp");
        return "zuke/main";
    }
}
