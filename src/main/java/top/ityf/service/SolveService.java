package top.ityf.service;

import top.ityf.domain.QueryVO;
import top.ityf.domain.Solve;
import top.ityf.domain.Wrong;

import java.util.List;

/**
 * ClassName:SolveService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:17
 * @Author: YanFei
 */
public interface SolveService {
    public List<Solve> getAll(QueryVO vo);

    public Integer getCount(QueryVO vo);

    public void deleteSolve(Integer id);

    public List<Wrong> findWrong(QueryVO vo);

    public Wrong findWrongById(Integer id);

    public void insertWrong(Wrong wrong);

    public void goToSolve(Integer id, Solve solve);
}
