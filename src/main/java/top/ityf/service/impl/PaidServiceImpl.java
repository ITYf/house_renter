package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.PaidDao;
import top.ityf.dao.ZulistDao;
import top.ityf.domain.Paid;
import top.ityf.domain.QueryVO;
import top.ityf.domain.Zulist;
import top.ityf.service.PaidService;

import java.util.List;

/**
 * ClassName:PaidService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:16
 * @Author: YanFei
 */
@Service
@Transactional
public class PaidServiceImpl implements PaidService {
    @Autowired
    private PaidDao paidDao;

    @Autowired
    private ZulistDao zulistDao;

    /**
     * 模糊查询
     * 把符合条件的都查询出来
     * */
    @Override
    public List<Paid> getByVo(QueryVO vo) {
        List<Paid> list = paidDao.selectAll(vo);
        return list;
    }

    /**
     * 查询符合条件的记录的总租金
     * */
    @Override
    public Double getSumByVo(QueryVO vo) {
        Double sum = paidDao.selectSum(vo);
        return sum;
    }

    @Override
    public void deletePaid(Integer id) {
        paidDao.deletePaid(id);
    }

    @Override
    public List<Zulist> findZuUserlist() {
        List<Zulist> list = zulistDao.findZuUserlist();
        return list;
    }

    @Override
    public Zulist findZukeZulist(Integer id) {
        Zulist zulist = zulistDao.findZukeZulist(id);
        return zulist;
    }
}
