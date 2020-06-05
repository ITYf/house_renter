package top.ityf.dao;

import top.ityf.domain.Applyout;

import java.util.List;

/**
 * ClassName:ApplyoutDao
 * Package: top.ityf.dao
 * Description: 退租申请的持久层接口
 *
 * @Date: 2020/3/31 17:00
 * @Author: YanFei
 */
public interface ApplyoutDao {
    /**
     * 根据Id查找
     * */
    public Applyout findById(Integer id);

    /**
     * 查询所有
     * */
    public List<Applyout> findAllApplyout();

    /**
     * 插入操作
     * */
    public void insertApplyout(Applyout applyout);

    /**
     * 根据申请信息id修改申请状态(已拒绝/已同意)
     * 这里需要创建的applyout对象id必须是在表结构中
     * */
    public void updateApplyout(Applyout applyout);

    /**
     * 根据所申请的房屋的id修改申请状态(已拒绝/已同意)
     * 这里需要创建的applyout对象id必须是在表结构中
     * */
    public void updateApplyoutByHouse(Applyout applyout);

    /**
     * 根据Id删除退房申请
     * */
    public void deleteApplyout(Integer id);

}
