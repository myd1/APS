package com.aps.dao;

import java.util.List;

import com.aps.pojo.News;

public interface NewsDao {
	
	/**
	 * �����������Ų���ҳ��ʾ
	 */
	public List<News> findAllNews(int page);
	
	/**
	 * �����������ŵ�����
	 */
	public int findAllNewsCount();
	
	/**
	 * ��������ID���Ҿ�����Ϣ
	 */
	public News findNewsById(int newsId);
	
	/**
	 * �������µ�5������
	 */
	public List<News> findLastFive();
	
	/**
	 * ��������
	 * @param news
	 */
	public void addNews(News news);
	
}
