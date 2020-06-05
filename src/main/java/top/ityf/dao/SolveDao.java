package top.ityf.dao;

import top.ityf.domain.QueryVO;
import top.ityf.domain.Solve;

import java.util.List;

/**
 * ClassName:ApplyDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:14
 * @Author: YanFei
 */
public interface SolveDao {
    public List<Solve> selectAll(QueryVO vo);

    public Integer selectCount(QueryVO vo);

    public void deleteSolve(Integer id);

    public void insertSolve(Solve solve);
}
