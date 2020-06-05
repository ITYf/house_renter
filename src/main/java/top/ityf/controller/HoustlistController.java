package top.ityf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.ityf.domain.Houselist;
import top.ityf.domain.User;
import top.ityf.service.HouselistService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:HouselistController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/12 19:18
 * @Author: YanFei
 */
@Controller
public class HoustlistController {
    @Autowired
    private HouselistService houselistService;

    @RequestMapping("/ahouseList")
    public String ahouselist(Model model) {

        //这里我们用AdminLTE自带的插件，所以PageHelper就没用了
//        PageHelper.startPage(page, pageSize);
        List<Houselist> houselist = houselistService.getAll();
//        PageInfo<Houselist> p = new PageInfo<Houselist>(houselist);


//        model.addAttribute("p", p);
        model.addAttribute("houselist", houselist);
        model.addAttribute("mainPage", "ahouselist.jsp");
        return "admin/main1";
    }

    @RequestMapping("/findById")
    public String findid(Integer id, Model model) {
        Houselist list = houselistService.findById(id);
        model.addAttribute("houselist", list);
        model.addAttribute("mainPage", "changehouse.jsp");
        return "admin/main1";
    }

    @RequestMapping(value = "/findHouse_idUpdate", method = {RequestMethod.POST})
    public String findhouseidupdate(Houselist houseList, Model model) {
        System.out.println(houseList);
        Houselist list = houselistService.findHouse_idUpdate(houseList);
        System.out.println(list);
        if (list != null) {
            model.addAttribute("houseList", houseList);
            model.addAttribute("mainPage", "changehouse.jsp");
            model.addAttribute("error", "该房屋id已存在");

            return "admin/main1";
        } else {
            houselistService.updateHouse(houseList);
            System.out.println("else后面的" + houseList);
            model.addAttribute("houseList", houseList);
            model.addAttribute("mainPage", "changehouse.jsp");
            model.addAttribute("error", "更新成功");
            return "admin/main1";
        }
    }


    @RequestMapping("/deleteHouse")
    public String deletehouse(Integer id) {
        houselistService.deleteHouse(id);
        return "redirect:ahouseList.go";
    }

    @RequestMapping("/houseList")
    public String houselist(Model model) {
        List<Houselist> houseList = houselistService.getAll();

        model.addAttribute("houselist", houseList);
        model.addAttribute("mainPage", "houselist.jsp");
        return "zuke/main";
    }

    @RequestMapping("/addHouse")
    public String addHouse(Model model, Houselist houselist) {

        String houseid = houselist.getHouseid();
        Houselist houselist1 = houselistService.findByHouse_id(houseid);
        if (houselist1 != null) {
            model.addAttribute("error", "该房屋id已存在");
            model.addAttribute("houselist", houselist);
            model.addAttribute("mainPage", "addhouse.jsp");
            return "admin/main1";
        } else {
            model.addAttribute("error", "添加成功");
            houselistService.insertHouse(houselist);
            model.addAttribute("houselist", houselist);
            model.addAttribute("mainPage", "addhouse.jsp");
            return "admin/main1";
        }
    }

    @RequestMapping("/toAddHouse")
    public String toAddHoust(Model model) {
        model.addAttribute("mainPage", "addhouse.jsp");

        return "admin/main1";
    }

    @RequestMapping("/toAhouseList")
    public String toAhouseList() {
        return "redirect:ahouseList.go";
    }

}
