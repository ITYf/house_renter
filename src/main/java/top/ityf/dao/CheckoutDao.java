package top.ityf.dao;

import top.ityf.domain.Checkout;

import java.util.List;

/**
 * ClassName:CheckoutDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:15
 * @Author: YanFei
 */
public interface CheckoutDao {
    public void insertCheckout(Checkout checkout);

    public List<Checkout> findAllCheckout();

    public void deleteCheckout(Integer id);
}
