package com.aps.dao;


import com.aps.pojo.Association;


import java.util.List;

import com.aps.pojo.Association;

public interface AssociationDao {

	public Association findNewAssNews();
	/**
	 * ��������Э�ᶯ̬����ҳ��ʾ
	 */
	public List<Association> findAllAssociation(int page);
	
	/**
	 * ��������Э�ᶯ̬������
	 */
	public int findAllAssociationCount();
	

	/**
	 * ���ݶ�̬Id���Ҹö�̬
	 */
	public Association findAssociationById(int a_Id);
	
	/**
	 * ��Ӷ�̬
	 * @param association
	 */
	public void addAssociation(Association association);
}
