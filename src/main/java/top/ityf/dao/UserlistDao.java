package top.ityf.dao;

import top.ityf.domain.Userlist;

import java.util.List;

/**
 * ClassName:UserlistDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/4/1 23:14
 * @Author: YanFei
 */
public interface UserlistDao {
    Userlist findHasUserlist(Integer user_id);

    Userlist checkUserlist(String idcard);

    void insertUserlist(Userlist userlist);

    void updateUserlist(Userlist userlist);

    Userlist findUserlistUpdate(Userlist userlist);

    public List<Userlist> getUserZuList(Integer id);

    public List<Userlist> getMyCheckout(Integer id);

    public List<Userlist> getMyApply(Integer id);

    public List<Userlist> getMyApplyout(Integer id);

    public List<Userlist> findAllUserlist();

    public void deleteUser(Integer id);

    public void deleteUserlist(Integer id);
}
