package com.aps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.dao.VarietyDao;
import com.aps.pojo.Variety;

@Service
public class VarietyService {
	@Autowired
	private VarietyDao varietyDao;
	
	/**
	 * ��ѯ����Ʒ��
	 * @return
	 */
	public List<Variety> findAllVariety(){
		return varietyDao.findAllVariety();
	}
	
	/**
	 * ��ѯ����èƷ��
	 * @return
	 */
	public List<Variety> findAllCartVariety(){
		return varietyDao.findAllCartVariety();
	}
	
	/**
	 * ��ѯ���й�Ʒ��
	 * @return
	 */
	public List<Variety> findAllDogVariety(){
		return varietyDao.findAllDogVariety();
	}
	
	/**
	 * ���ݱ�Ų�ѯ����
	 */
	public String findTypeById(int varietyId){
		return varietyDao.findTypeById(varietyId);
	} 
}
