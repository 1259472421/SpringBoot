package com.leichuangkj.transaction.dao.mapper;

import com.leichuangkj.transaction.dao.po.Transfer;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferMapper {
    int updateAccount(Transfer user);
}
