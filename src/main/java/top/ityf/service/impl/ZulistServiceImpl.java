package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.ZulistDao;
import top.ityf.domain.Zulist;
import top.ityf.service.ZulistService;

import java.util.List;

/**
 * ClassName:ZulistService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:19
 * @Author: YanFei
 */
@Service
@Transactional
public class ZulistServiceImpl implements ZulistService {

    @Autowired
    private ZulistDao zulistDao;

    @Override
    public void insertZulist(Zulist zulist) {
        zulistDao.insertZulist(zulist);
    }

    @Override
    public List<Zulist> findZuUserlist()  {
        List<Zulist> zulist = zulistDao.findZuUserlist();
        return zulist;
    }

    @Override
    public Zulist findZulist(String house_id) {
        Zulist zulist = zulistDao.findZulist(house_id);
        return zulist;
    }

    @Override
    public void deleteZulist(String houseZ_id) {
        zulistDao.deleteZulist(houseZ_id);
    }

    @Override
    public List<Zulist> findZulistByUid(Integer userlist_id) {
        List<Zulist> zulist = zulistDao.findZulistByUid(userlist_id);
        return zulist;
    }
}
