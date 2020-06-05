package top.ityf.dao;

import top.ityf.domain.Zulist;

import java.util.List;

/**
 * ClassName:ZulistDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:19
 * @Author: YanFei
 */
public interface ZulistDao {
    public void insertZulist(Zulist zulist);

    public List<Zulist> findZuUserlist();

    Zulist findZulist(String house_id);

    public void deleteZulist(String house_id);

    public List<Zulist> findZulistByUid(Integer userlist_id);

    public Zulist findZukeZulist(Integer id);
}
