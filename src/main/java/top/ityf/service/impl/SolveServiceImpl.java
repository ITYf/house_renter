package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.SolveDao;
import top.ityf.dao.WrongDao;
import top.ityf.domain.QueryVO;
import top.ityf.domain.Solve;
import top.ityf.domain.Wrong;
import top.ityf.service.SolveService;

import java.util.List;

/**
 * ClassName:SolveService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:17
 * @Author: YanFei
 */
@Service
@Transactional
public class SolveServiceImpl implements SolveService {
    @Autowired
    private SolveDao solveDao;

    @Autowired
    private WrongDao wrongDao;


    @Override
    public List<Solve> getAll(QueryVO vo) {
        List<Solve> list = solveDao.selectAll(vo);
        return list;
    }

    @Override
    public Integer getCount(QueryVO vo) {
        Integer count = solveDao.selectCount(vo);
        return count;
    }

    @Override
    public void deleteSolve(Integer id) {
        solveDao.deleteSolve(id);
    }

    @Override
    public List<Wrong> findWrong(QueryVO vo) {
        List<Wrong> list = wrongDao.findWrong(vo);
        return list;
    }

    @Override
    public Wrong findWrongById(Integer id) {
        Wrong wrong = wrongDao.findById(id);
        return wrong;
    }

    @Override
    public void insertWrong(Wrong wrong) {
        wrong.setStatus("待处理");
        wrongDao.insertWrong(wrong);
    }

    @Override
    public void goToSolve(Integer id, Solve solve) {
        solveDao.insertSolve(solve);
        wrongDao.deleteWrong(id);
    }
}
