package top.ityf.dao;

import top.ityf.domain.Paid;
import top.ityf.domain.QueryVO;

import java.util.List;

/**
 * ClassName:PaidDao
 * Package: top.ityf.dao
 * Description: 已缴租金实体类
 *
 * @Date: 2020/3/31 21:15
 * @Author: YanFei
 */
public interface PaidDao {
    public List<Paid> selectAll(QueryVO vo);

    public Double selectSum(QueryVO vo);

    public void deletePaid(Integer id);

    public void insertPaid(Paid paid);
}
