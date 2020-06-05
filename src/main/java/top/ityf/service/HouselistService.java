package top.ityf.service;

import top.ityf.domain.Houselist;

import java.util.List;

/**
 * ClassName:HouselistService
 * Package: top.ityf.service
 * Description: 房源列表的业务层接口
 *
 * @Date: 2020/4/5 10:15
 * @Author: YanFei
 */
public interface HouselistService {
    List<Houselist> getAll();

    Houselist findByHouse_id(String houseid);

    void insertHouse(Houselist houselist);

    void deleteHouse(int id);

    Houselist findById(int id);

    Houselist findHouse_idUpdate(Houselist houselist);

    void updateHouse(Houselist houselist);

    void updateHouseStatusById(Houselist houselist);

    public void deleteHouseByHouse_id(String house_id);
}
