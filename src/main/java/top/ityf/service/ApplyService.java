package top.ityf.service;

import top.ityf.domain.Apply;
import top.ityf.domain.Houselist;

import java.util.List;

/**
 * ClassName:ApplyService
 * Package: top.ityf.service
 * Description: 看房申请的业务层接口
 *
 * @Date: 2020/4/5 10:14
 * @Author: YanFei
 */
public interface ApplyService {

    public void insertApply(Apply apply);

    public List<Apply> findApplyList();

    Apply findByHouse_id(String house_id);

    public void deleteByHouse_id(String house_id);

    public void refuseApply(Houselist houselist);
}
