package top.ityf.service;

import top.ityf.domain.Userlist;

import java.util.List;

/**
 * ClassName:UserlistService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:18
 * @Author: YanFei
 */
public interface UserlistService {
    Userlist findHasUserlist(Integer user_id);

    Userlist checkUserlist(String idcard);

    void insertUserlist(Userlist userlist);

    void updateUserlist(Userlist userlist);

    Userlist findUserlistUpdate(Userlist userlist);

    public List<Userlist> getUserZulist(Integer id);

    public List<Userlist> getMyCheckout(Integer id);

    public List<Userlist> getMyApply(Integer id);

    public List<Userlist> getMyApplyout(Integer id);

    public List<Userlist> findAllUserlist();

    public void deleteUserlist(Integer id);
}
