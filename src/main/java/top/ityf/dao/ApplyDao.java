package top.ityf.dao;

import top.ityf.domain.Apply;
import top.ityf.domain.Applyout;

import java.util.List;

/**
 * ClassName:ApplyDao
 * Package: top.ityf.dao
 * Description: 看房申请的持久层接口
 *
 * @Date: 2020/3/31 21:14
 * @Author: YanFei
 */
public interface ApplyDao {
    /**
     * 插入看房申请记录
     * */
    void insertApply(Apply apply);

    /**
     * 查询整个申请列表
     * */
    public List<Apply> findAllApply();

    /**
     * 根据房屋id查询
     * 这里要注意，Apply有两个主键：apply_id 和 house_id
     * */
    Apply findByHouse_Id(String house_id);

    /**
     * 根据房屋id删除
     * */
    public void deleteByHouse_Id(String house_id);

}
