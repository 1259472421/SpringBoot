package com.leichuangkj.transaction.service.impl;

import com.leichuangkj.transaction.dao.mapper.TransferMapper;
import com.leichuangkj.transaction.dao.po.Transfer;
import com.leichuangkj.transaction.service.ITransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferImpl implements ITransfer {
    @Autowired
    TransferMapper transferMapper;

    @Transactional
    @Override
    public void transfer() {
        Transfer id1 = new Transfer();
        id1.setId(1);
        id1.setUsername("mike");
        id1.setTransfer(-200);
        transferMapper.updateAccount(id1);
        int i = 1/0;
        Transfer id2 = new Transfer();
        id2.setId(2);
        id2.setUsername("steven");
        id2.setTransfer(+200);
        transferMapper.updateAccount(id2);
    }
}
