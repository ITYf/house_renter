package top.ityf.service;

import top.ityf.domain.Paid;
import top.ityf.domain.QueryVO;
import top.ityf.domain.Zulist;

import java.util.List;

/**
 * ClassName:PaidService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:16
 * @Author: YanFei
 */
public interface PaidService {
    public List<Paid> getByVo(QueryVO vo);

    public Double getSumByVo(QueryVO vo);

    public void deletePaid(Integer id);

    public List<Zulist> findZuUserlist();

    public Zulist findZukeZulist(Integer id);
}
