package com.aps.dao;

import java.util.Date;
import java.util.List;

import com.aps.pojo.Apply;

public interface ApplyDao {

	public List<Apply> findAllApply();
	/**
	 * �����ֻ������ѯ��¼
	 */
	public Apply findAdoptByTel(String applyPhone);

	
	/**
	 * ������������
	 */
	public void addApplyAdopt(Apply apply);

	
	/**
	 * ��ѯ���ݿ⵱ǰʱ��
	 */
	public Date findNowDate();
	

}
