package top.ityf.dao;

import top.ityf.domain.QueryVO;
import top.ityf.domain.Topaid;

import java.util.List;

/**
 * ClassName:TopaidDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:18
 * @Author: YanFei
 */
public interface TopaidDao {
    public void insertToPaid(Topaid topaid);

    public List<Topaid> findToPaid(QueryVO vo);

    public Topaid findById(Integer id);

    public void deleteToPaid(Integer id);
}
