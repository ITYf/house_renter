package top.ityf.service;

import top.ityf.domain.Checkout;

import java.util.List;

/**
 * ClassName:CheckoutService
 * Package: top.ityf.service
 * Description: 已退租的业务层接口
 *
 * @Date: 2020/4/5 10:14
 * @Author: YanFei
 */
public interface CheckoutService {

    public void insertCheckout(Checkout checkout);

    public List<Checkout> findAllCheckout();

    public void deleteCheckout(Integer id);
}
