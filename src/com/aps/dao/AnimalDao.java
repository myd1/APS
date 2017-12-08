package com.aps.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aps.pojo.Animal;

public interface AnimalDao {
	
//	/**
//	 * �������ж��ﲢ��ҳ��ʾ
//	 * @param page
//	 * @return
//	 */
//	public List<Animal> findAnimals(int page);
//	
//	public int animalCount();
//	
//	/**
//	 * �������Ͳ�ѯ
//	 * @param type
//	 * @param page
//	 * @return
//	 */
//	public List<Animal> findAnimals(String type,int page);
//	
//	public int animalCount(String type,int page);
//	/**
//	 * ����Ʒ�ֲ�ѯ
//	 * @param variety
//	 * @param page
//	 * @return
//	 */
//	public List<Animal> findAnimals(int variety,int page);
//	
//	public int animalCount(int variety,int page);
	/**
	 * ����Ʒ�ֺ����Ͳ�ѯ
	 * @param type
	 * @param variety
	 * @param page
	 * @return
	 */
	public List<Animal> findAnimals(@Param("type")String type,@Param("variety")int variety,@Param("page")int page);
	
	public int animalCount(@Param("type")String type,@Param("variety")int variety);
	
	//û�б���������
	public int notAdopt();
	
	//�Ѿ�������
	public int haveAdopt();

	
	//����Id���Ҷ���
	public Animal findAniInfoById(int animalId);

	
	/**
	 * ����flagΪ0����С��3��İ�ʱ�併�����еĹ�
	 */
	public List<Animal> findDogByRule();
	
	/**
	 * ����flagΪ0����С��3��İ�ʱ�併�����е�è
	 */
	public List<Animal> findCatByRule();
	

	/**
	 * ��Ӷ���
	 * @param animal
	 */
	public void addAnimal(Animal animal);

	/**
	 * ���ݶ���Id���Ҷ�������
	 */
	public String findAnimalVarietyById(int animalId);
	
	/**
	 * ����flagΪ0����ʱ������ǰ6����
	 */
	public List<Animal> findSixDog();
	
	/**
	 * ����flagΪ0����ʱ������ǰ6��è
	 */
	public List<Animal> findSixCat();
	
	/**
	 * �����Ѿ��������Ķ���
	 */
	public List<Animal> findHaveOwnerAnimal();
	
	
}
