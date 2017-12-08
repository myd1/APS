package com.aps.dao;

import java.util.List;

import com.aps.pojo.Donate;

public interface DonateDao {
	/**
	 * ���������
	 * @return
	 */
	public int findDonatePeopleCount();
	
	/**
	 * �����Ǯ��
	 * @return
	 */
	public double findDonateMoneyCount();
	/**
	 * չ�����еľ����Ϣ
	 */
	public List<Donate> findAllDonate();
	/**
	 * ����һ�������Ϣ
	 */
	public void addDonate(Donate donate);
}
