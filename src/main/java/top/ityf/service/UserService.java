package top.ityf.service;

import top.ityf.domain.User;

import java.util.List;

/**
 * ClassName:UserService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:19
 * @Author: YanFei
 */
public interface UserService {
    public List<User> userList();

    public User login(User user);
}
