package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.UserDao;
import top.ityf.dao.UserlistDao;
import top.ityf.domain.User;
import top.ityf.domain.UserExample;
import top.ityf.service.UserService;

import java.util.List;

/**
 * ClassName:UserService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:19
 * @Author: YanFei
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> userList() {
        // TODO Auto-generated method stub
        UserExample example = new UserExample();
        List<User> list = userDao.selectByExample(example);
        System.out.println("123" + list);
        return list;
    }

    @Override
    public User login(User user) {
        User user1 = userDao.selectByUser(user);
        return user1;
    }
}
