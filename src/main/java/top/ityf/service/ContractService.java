package top.ityf.service;

import top.ityf.domain.Contract;

/**
 * ClassName:ContractService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/19 10:06
 * @Author: YanFei
 */
public interface ContractService {
    public void insertContract(Contract contract);

    public Contract findContract(String house_id);

    public void updateContract(Contract contract);

    public void deleteContract(String house_id);
}
