package top.ityf.service;

import top.ityf.domain.Applyout;
import top.ityf.domain.Zulist;

import java.util.List;

/**
 * ClassName:ApplyoutService
 * Package: top.ityf.service
 * Description: 退租申请的业务层接口
 *
 * @Date: 2020/4/5 10:12
 * @Author: YanFei
 */
public interface ApplyoutService {
    public void insertApplyout(Zulist zulist);

    List<Applyout> findAllApplyout();

    public void updateApplyout(Applyout applyout);

    public void agreeApplyout(Integer id);

    public void deleteApplyout(Integer id);
}
