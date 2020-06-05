package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.UserlistDao;
import top.ityf.domain.Userlist;
import top.ityf.service.UserlistService;

import java.util.List;

/**
 * ClassName:UserlistService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:18
 * @Author: YanFei
 */
@Service
@Transactional
public class UserlistServiceImpl implements UserlistService {
    @Autowired
    private UserlistDao userlistDao;


    @Override
    public Userlist findHasUserlist(Integer user_id) {
        Userlist userlist = userlistDao.findHasUserlist(user_id);
        return userlist;
    }

    @Override
    public Userlist checkUserlist(String idcard) {
        Userlist userlist = userlistDao.checkUserlist(idcard);
        return userlist;
    }

    @Override
    public void insertUserlist(Userlist userlist) {
        userlistDao.insertUserlist(userlist);
    }

    @Override
    public void updateUserlist(Userlist userlist) {
        userlistDao.updateUserlist(userlist);
    }

    @Override
    public Userlist findUserlistUpdate(Userlist userlist) {
        Userlist list = userlistDao.findUserlistUpdate(userlist);
        return list;
    }

    @Override
    public List<Userlist> getUserZulist(Integer id) {
        List<Userlist> userlist = userlistDao.getUserZuList(id);
        for (Userlist list : userlist) {
            System.out.println(list);
        }
        return userlist;
    }

    @Override
    public List<Userlist> getMyCheckout(Integer id) {
        List<Userlist> list = userlistDao.getMyCheckout(id);
        return list;
    }

    @Override
    public List<Userlist> getMyApply(Integer id) {
        List<Userlist> list = userlistDao.getMyApply(id);
        return list;
    }

    @Override
    public List<Userlist> getMyApplyout(Integer id) {
        List<Userlist> list = userlistDao.getMyApplyout(id);
        return list;
    }

    @Override
    public List<Userlist> findAllUserlist() {
        List<Userlist> list = userlistDao.findAllUserlist();
        return list;
    }

    @Override
    public void deleteUserlist(Integer id) {
        userlistDao.deleteUserlist(id);
        userlistDao.deleteUser(id);
    }
}
