package top.ityf.dao;

import top.ityf.domain.Houselist;
import top.ityf.domain.QueryVO;

import java.util.List;

/**
 * ClassName:HouselistDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:15
 * @Author: YanFei
 */
public interface HouselistDao {
    List<Houselist> selectAll();

    public Integer findHouselistByVoCount(QueryVO vo);

    Houselist findByHouse_id(String houseid);

    void insertHouse(Houselist houselist);

    void deleteHouse(int id);

    Houselist findById(int id);

    Houselist findHouseIdUpdate(Houselist houselist);

    void updateHouse(Houselist houselist);

    void updateHouseStatusById(Houselist houselist);

    public void deleteHouseByhouseId(String house_id);

    public void updateHouseStatusByHouseid(Houselist houselist);
}
