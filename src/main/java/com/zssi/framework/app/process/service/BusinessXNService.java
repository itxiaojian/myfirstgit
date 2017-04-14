package com.zssi.framework.app.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.process.dao.TestProcessDao;
import com.zssi.framework.app.process.model.TestProcess;

@Service
public class BusinessXNService {
	
	@Autowired
	private TestProcessDao testProcessDao;
	
	/**
	 * 流程结束更新主表状态
	 * @param businessKey
	 */
	@Transactional
	public void updateTestProcess(String businessKey) {
		
		TestProcess test = testProcessDao.get(businessKey);
		test.setProcessStatus("3");
		testProcessDao.update(test);
	}

}
