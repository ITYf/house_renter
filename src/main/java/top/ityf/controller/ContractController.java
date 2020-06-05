package top.ityf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ityf.domain.*;
import top.ityf.service.*;

/**
 * ClassName:HeTongController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/19 9:18
 * @Author: YanFei
 */
@Controller
@RequestMapping("/Contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private HouselistService houselistService;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ZulistService zulistService;
    @Autowired
    private CheckoutService checkoutService;

    /**
     * 这个方法是提交合同表单之后的操作
     * 首先，新增合同信息，
     * 然后，修改房屋列表的状态，为已租赁
     * 最后，从申请列表中删除，增添到租赁列表当中
     */
    @RequestMapping("/insertContract")
    public String insertContract(Model model, Contract contract) {
        //新增合同信息
        contractService.insertContract(contract);
        //修改房屋列表状态
        Houselist houselist = houselistService.findByHouse_id(contract.getHouse_id());
        houselist.setStatus("已租赁");
        houselistService.updateHouseStatusById(houselist);
        //删除申请列表中的记录
        Apply apply = applyService.findByHouse_id(contract.getHouse_id());
        //添加到租赁列表当中
        Zulist zulist = new Zulist();
        zulist.setHouse_id(contract.getHouse_id());
        zulist.setUserlist_id(apply.getUserlist_id());
        Contract contract1 = contractService.findContract(contract.getHouse_id());
        zulist.setContract_id(contract1.getId());
        zulist.setPrice(apply.getPrice());
        zulist.setAddress(apply.getAddress());
        zulistService.insertZulist(zulist);
        //从申请列表中删除
        applyService.deleteByHouse_id(contract1.getHouse_id());
        model.addAttribute("error", "zusuccess");
        return "redirect:/zuList/findZulist.go";

    }

    /**
     * 管理员查看合同
     */
    @RequestMapping("/seeContract")
    public String seeContract(String house_id, Model model) {
        Contract contract = contractService.findContract(house_id);
        model.addAttribute("contract", contract);
        model.addAttribute("mainPage", "hetong.jsp");
        return "admin/main2";
    }

    /**
     * 跳转到管理员修改合同的页面
     */
    @RequestMapping("/updateContract")
    public String updatehetong(String house_id, Model model) {
        Contract contract = contractService.findContract(house_id);
        model.addAttribute("contract", contract);
        System.out.println(contract);
        model.addAttribute("mainPage", "updatehetong.jsp");
        return "admin/main2";
    }

    /**
     * 修改合同页面提交表单之后，跳转到这里
     */
    @RequestMapping("/changeContract")
    public String changehetong(Contract contract) {
        contractService.updateContract(contract);

        return "redirect:/zuList/findZulist.go";
    }


    /**
     * 管理员终止合同
     * 首先删除合同，并且删除在租列表中对应的记录，最后把记录添加到已退租列表
     * */
    @RequestMapping("/deleteContract")
    public String deletehetong(String house_id, Model model) {
        contractService.deleteContract(house_id);
        Zulist zulist = zulistService.findZulist(house_id);
        Checkout checkout = new Checkout();
        checkout.setHouse_id(house_id);
        checkout.setAddress(zulist.getAddress());
        checkout.setStatus("已退租");
        checkout.setUserlist_id(zulist.getUserlist_id());
        checkoutService.insertCheckout(checkout);
        houselistService.deleteHouseByHouse_id(house_id);
        zulistService.deleteZulist(house_id);

        model.addAttribute("error", "checkoutsuccess");
        return "redirect:/zuList/findZulist.go";
    }


    /**
     * 租客查看合同
     * */
    @RequestMapping("/zukeSeeContract")
    public String zukeseehetong(String house_id, Model model) {
        Contract contract = contractService.findContract(house_id);
        model.addAttribute("contract", contract);
        model.addAttribute("mainPage", "showcontract.jsp");
        return "zuke/main3";
    }
}
