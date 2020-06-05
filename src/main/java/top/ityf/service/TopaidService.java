package top.ityf.service;

import top.ityf.domain.Paid;
import top.ityf.domain.QueryVO;
import top.ityf.domain.Topaid;

import java.util.List;

/**
 * ClassName:TopaidService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:19
 * @Author: YanFei
 */
public interface TopaidService {
    public void insertTopaid(Topaid topaid);

    public List<Topaid> findTopaidByUserlist_id(QueryVO vo);

    public Topaid findById(Integer id);

    public void goToPay(Integer id, Paid paid);
}
