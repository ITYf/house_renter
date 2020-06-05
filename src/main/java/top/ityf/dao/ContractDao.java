package top.ityf.dao;

import top.ityf.domain.Contract;

/**
 * ClassName:ContractDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/4/19 9:54
 * @Author: YanFei
 */
public interface ContractDao {
    public void insertContract(Contract contract);

    public Contract findContract(String house_id);

    public void updateContract(Contract contract);

    public void deleteContract(String house_id);
}
