package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.*;
import top.ityf.domain.Applyout;
import top.ityf.domain.Checkout;
import top.ityf.domain.Zulist;
import top.ityf.service.ApplyoutService;

import java.util.List;

/**
 * ClassName:ApplyoutService
 * Package: top.ityf.service
 * Description: 退租申请的业务层实现类
 *
 * @Date: 2020/4/5 10:12
 * @Author: YanFei
 */
@Service
@Transactional
public class ApplyoutServiceImpl implements ApplyoutService {
    @Autowired
    private ApplyoutDao applyoutDao;

    @Autowired
    private HouselistDao houselistDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private CheckoutDao checkoutDao;

    @Autowired
    private ZulistDao zulistDao;


    @Override
    public void insertApplyout(Zulist zulist) {
        Applyout applyout = new Applyout();
        applyout.setHouse_id(zulist.getHouse_id());
        applyout.setAddress(zulist.getAddress());
        applyout.setStatus("申请中");
        applyout.setUserlist_id(zulist.getUserlist_id());
        applyoutDao.insertApplyout(applyout);
    }

    @Override
    public List<Applyout> findAllApplyout() {
        List<Applyout> list = applyoutDao.findAllApplyout();
        return list;
    }

    @Override
    public void updateApplyout(Applyout applyout) {
        applyoutDao.updateApplyout(applyout);
    }

    /**
     * 管理员同意退租
     * 这个方法分为如下步骤：
     * 首先根据 applyout表的id获取到一条 applyout记录
     * 然后根据记录中的 houseid 删除 houselist表中对应的记录
     * 并删除对应的合同记录
     * 然后根据 applyout的属性插入一条已退租(checkout)记录
     * 最后更新applyout状态，并删除 zulist中对应的记录
     * */
    @Override
    public void agreeApplyout(Integer id) {
        Applyout applyout = applyoutDao.findById(id);
        houselistDao.deleteHouseByhouseId(applyout.getHouse_id());
        contractDao.deleteContract(applyout.getHouse_id());
        Checkout checkout = new Checkout();
        checkout.setHouse_id(applyout.getHouse_id());
        checkout.setAddress(applyout.getAddress());
        checkout.setStatus("已退租");
        checkout.setUserlist_id(applyout.getUserlist_id());
        checkoutDao.insertCheckout(checkout);
        applyout.setStatus("已同意");
        applyoutDao.updateApplyoutByHouse(applyout);
        zulistDao.deleteZulist(applyout.getHouse_id());
    }

    @Override
    public void deleteApplyout(Integer id) {
        applyoutDao.deleteApplyout(id);

    }
}
