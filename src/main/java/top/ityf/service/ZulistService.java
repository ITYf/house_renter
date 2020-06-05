package top.ityf.service;

import top.ityf.domain.Applyout;
import top.ityf.domain.Zulist;

import java.util.List;

/**
 * ClassName:ZulistService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:19
 * @Author: YanFei
 */
public interface ZulistService {
    public void insertZulist(Zulist zulist);

    public List<Zulist> findZuUserlist();

    public Zulist findZulist(String house_id);

    public void deleteZulist(String houseZ_id);

    public List<Zulist> findZulistByUid(Integer userlist_id);

}
