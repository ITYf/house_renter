package top.ityf.dao;

import top.ityf.domain.QueryVO;
import top.ityf.domain.Wrong;

import java.util.List;

/**
 * ClassName:WrongDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:19
 * @Author: YanFei
 */
public interface WrongDao {
    public List<Wrong> findWrong(QueryVO vo);

    public Wrong findById(Integer id);

    public void insertWrong(Wrong wrong);

    public void deleteWrong(Integer id);
}
