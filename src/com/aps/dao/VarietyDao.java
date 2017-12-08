package com.aps.dao;

import java.util.List;

import com.aps.pojo.Variety;

public interface VarietyDao {

	/**
	 * ��ѯ����Ʒ��
	 * @return
	 */
	public List<Variety> findAllVariety();
	
	/**
	 * ��ѯ����èƷ��
	 * @return
	 */
	public List<Variety> findAllCartVariety();
	
	/**
	 * ��ѯ���й�Ʒ��
	 * @return
	 */
	public List<Variety> findAllDogVariety();
	
	/**
	 *����id��ѯ��è��Ʒ�� 
	 */
	public String findTypeById(int varietyId);
}
