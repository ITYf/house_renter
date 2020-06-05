package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.PaidDao;
import top.ityf.dao.TopaidDao;
import top.ityf.domain.Paid;
import top.ityf.domain.QueryVO;
import top.ityf.domain.Topaid;
import top.ityf.service.TopaidService;

import java.util.List;

/**
 * ClassName:TopaidService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:19
 * @Author: YanFei
 */
@Service
@Transactional
public class TopaidServiceImpl implements TopaidService {
    @Autowired
    private PaidDao paidDao;

    @Autowired
    private TopaidDao topaidDao;


    @Override
    public void insertTopaid(Topaid topaid) {
        topaid.setStatus("租金未缴");
        topaidDao.insertToPaid(topaid);
    }

    @Override
    public List<Topaid> findTopaidByUserlist_id(QueryVO vo) {
        List<Topaid> list = topaidDao.findToPaid(vo);
        return list;
    }

    @Override
    public Topaid findById(Integer id) {
        Topaid topaid = topaidDao.findById(id);
        return topaid;
    }

    @Override
    public void goToPay(Integer id, Paid paid) {
        paidDao.insertPaid(paid);
        topaidDao.deleteToPaid(id);
    }
}
