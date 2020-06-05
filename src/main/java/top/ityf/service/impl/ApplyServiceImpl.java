package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.ApplyDao;
import top.ityf.dao.HouselistDao;
import top.ityf.domain.Apply;
import top.ityf.domain.Houselist;
import top.ityf.service.ApplyService;

import java.util.List;

/**
 * ClassName:ApplyServiceImpl
 * Package: top.ityf.service.impl
 * Description: 看房申请的业务层实现类
 *
 * @Date: 2020/4/6 13:34
 * @Author: YanFei
 */
@Service
@Transactional
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyDao applyDao;

    @Autowired
    HouselistDao houselistDao;

    /**
     * 注意：这里所调用的dao接口所用的查询是联合查询，所以只有联合主键都存在记录时的记录才能查到
     * */
    @Override
    public void insertApply(Apply apply) {
        applyDao.insertApply(apply);
    }

    @Override
    public List<Apply> findApplyList()  {
        List<Apply> apply = applyDao.findAllApply();
        return apply;
    }

    @Override
    public Apply findByHouse_id(String house_id) {
        Apply apply = applyDao.findByHouse_Id(house_id);
        return apply;
    }

    @Override
    public void deleteByHouse_id(String house_id) {
        applyDao.deleteByHouse_Id(house_id);
    }

    /**
     * 首先更新 houselist中对应记录的状态，表示可以申请看房
     * 然后是删除这条申请
     * */
    @Override
    public void refuseApply(Houselist houselist) {
        houselistDao.updateHouseStatusByHouseid(houselist);
        applyDao.deleteByHouse_Id(houselist.getHouseid());
    }
}
