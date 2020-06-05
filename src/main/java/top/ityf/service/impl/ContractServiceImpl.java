package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.ContractDao;
import top.ityf.domain.Contract;
import top.ityf.service.ContractService;

/**
 * ClassName:ContractServiceImpl
 * Package: top.ityf.service.impl
 * Description: 合同的业务层实现类
 *
 * @Date: 2020/4/19 10:08
 * @Author: YanFei
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;

    @Override
    public void insertContract(Contract contract) {
        contractDao.insertContract(contract);
    }

    @Override
    public Contract findContract(String house_id) {
        Contract contract = contractDao.findContract(house_id);
        return contract;
    }

    /**
     * 此方法是根据house_id来更新的
     * */
    @Override
    public void updateContract(Contract contract) {
        contractDao.updateContract(contract);
    }

    @Override
    public void deleteContract(String house_id) {
        contractDao.deleteContract(house_id);
    }
}
