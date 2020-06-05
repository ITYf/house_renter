package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.CheckoutDao;
import top.ityf.domain.Checkout;
import top.ityf.service.CheckoutService;

import java.util.List;

/**
 * ClassName:CheckoutServiceImpl
 * Package: top.ityf.service.impl
 * Description: 已退租的业务层实现类
 *
 * @Date: 2020/4/6 14:22
 * @Author: YanFei
 */
@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CheckoutDao checkoutDao;

    @Override
    public void insertCheckout(Checkout checkout) {
        checkoutDao.insertCheckout(checkout);
    }

    @Override
    public List<Checkout> findAllCheckout() {
        List<Checkout> checkout = checkoutDao.findAllCheckout();
        return checkout;
    }

    @Override
    public void deleteCheckout(Integer id) {
        checkoutDao.deleteCheckout(id);
    }
}
