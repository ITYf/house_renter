package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.HouselistDao;
import top.ityf.domain.Houselist;
import top.ityf.service.HouselistService;

import java.util.List;


/**
 * ClassName:HouselistService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:15
 * @Author: YanFei
 */
@Service
@Transactional
public class HouselistServiceImpl implements HouselistService {
    @Autowired
    private HouselistDao houselistDao;

    @Override
    public List<Houselist> getAll() {
        List<Houselist> houselist = houselistDao.selectAll();
        return houselist;
    }

    @Override
    public Houselist findByHouse_id(String houseid) {
        Houselist houselist = houselistDao.findByHouse_id(houseid);
        return houselist;
    }

    @Override
    public Houselist findById(int id) {
        Houselist list = houselistDao.findById(id);
        return list;
    }

    @Override
    public void insertHouse(Houselist houselist) {
        houselistDao.insertHouse(houselist);
    }

    @Override
    public void deleteHouse(int id) {
        houselistDao.deleteHouse(id);
    }


    @Override
    public Houselist findHouse_idUpdate(Houselist houselist) {
        Houselist list = houselistDao.findHouseIdUpdate(houselist);
        return list;
    }

    @Override
    public void updateHouse(Houselist houselist) {
        houselistDao.updateHouse(houselist);
    }

    /**
     * 根据参数 houselist的id属性查询
     * */
    @Override
    public void updateHouseStatusById(Houselist houselist) {
        houselistDao.updateHouseStatusById(houselist);
    }

    @Override
    public void deleteHouseByHouse_id(String house_id) {
        houselistDao.deleteHouseByhouseId(house_id);
    }
}
