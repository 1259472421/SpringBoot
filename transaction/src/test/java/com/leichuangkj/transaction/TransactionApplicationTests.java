package com.leichuangkj.transaction;

import com.leichuangkj.transaction.dao.po.Transfer;
import com.leichuangkj.transaction.service.impl.TransferImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TransactionApplicationTests {

	@Resource
    TransferImpl transferImpl;

	@Test
	void contextLoads() {
        transferImpl.transfer();
	}

}
