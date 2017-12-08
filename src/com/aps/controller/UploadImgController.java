package com.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aps.pojo.Animal;
import com.aps.pojo.Association;
import com.aps.service.AnimalService;
import com.aps.service.AssociationService;
import com.aps.util.Token;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

@Controller
public class UploadImgController {
	@Autowired
	private AssociationService associationService;
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping("upload1")
	public String upload1(HttpServletRequest request, HttpServletResponse response,ModelMap map) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//�Ƿ��ϴ��ɹ��ı�ʶ
		boolean isSuccess=true;
		
		//�����ļ��ϴ�����
		DiskFileUpload disk=new DiskFileUpload();
		
		//�趨�ϴ����ݵ��ַ���
		disk.setHeaderEncoding("utf-8");
		
		//����������ʱ�ļ���
		File tempDirectory=new File("d:/temp");
		
		if(!tempDirectory.exists())
		{
			tempDirectory.mkdir();
		}

		//�趨������ʱ�ļ�
		disk.setRepositoryPath("d:/temp");
		
		//�趨�����ļ���С  ��λ�ֽ�
		disk.setSizeThreshold(1024*10);
		
		//�����ϴ��ļ���С
		disk.setSizeMax(1024*1024*100);
		String fileName="";
		List<String> list = new ArrayList<>();
		try
		{
			//��ȡ��������е���������ȡ�ύ���󼯺�
			List<FileItem> fileList=disk.parseRequest(request);
			//�����ύ�Ķ���
			for(FileItem item : fileList)
			{
				//��ȡ�ϴ��ļ���·��(������file)
				//System.out.println(item.getName());
				//��ȡ��Ԫ�ص�name����
				//System.out.println(item.getFieldName());
				//��ȡ�ļ���С
				//System.out.println(item.getSize());
		
				//�ж��ļ��Ƿ����ϴ�����
				//����ֵtrue��ʾ��Ԫ������ͨ�ı�Ԫ�أ��磺text,password,checkbox��
				//����ֵfalse��ʾ��Ԫ����file�ļ���Ԫ��
				if(!item.isFormField())
				{
//					//�ϴ����ļ���
//					System.out.println(item.getName());
					//��ȡ�ϴ��ļ���������
					InputStream input=item.getInputStream();
					//��ȡ�ϴ��ļ����ļ���
					fileName=item.getName();
					//�����ϴ�·��
					String path="C:\\Users\\admin\\workspace\\APS\\WebContent\\image\\newsImages\\"+fileName;
					
					//��ȡ�����
					FileOutputStream output=new FileOutputStream(new File(path));
					
					int data;
					
					while((data=input.read())!=-1)
					{
						output.write(data);
					}
					
					output.flush();
					output.close();
					input.close();
					
				}
				else{
					//��ȡ�ַ�����ʽ���ļ�����  �Ǳ�Ԫ��ͨ���÷�����ȡ��Ԫ�ص�ֵ
					//System.out.println(item.getString());
					//�ı�������������Ҫ�ع��ַ���
					list.add(new String(item.getString("iso-8859-1").getBytes("iso-8859-1"),"utf-8"));
				}
				
			}
			
			
		} catch (FileUploadException e)
		{
			isSuccess=false;
			
			request.setAttribute("error", e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e)
		{
			isSuccess=false;
			
			request.setAttribute("error", e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isSuccess){	
			//��ȡ�����������
			String token = list.get(2);
			//��ȡsession�е�ԭʼ����
			Object serverToken = request.getSession().getAttribute(Token.TOKEN);
			if(serverToken != null && token.equals(serverToken.toString())){
				Association ass = new Association();
				ass.setA_Title(list.get(0));
				ass.setA_Image(fileName);
				ass.setA_content(list.get(1));
				associationService.addAssociation(ass);
				request.getSession().removeAttribute(Token.TOKEN);
			}
			map.put("success", "��ӳɹ�");
		}else{
			map.put("success", "���ʧ��");
		}
		return "page/manage";
	}
	
	@RequestMapping("upload2")
	public String upload2(HttpServletRequest request, HttpServletResponse response,ModelMap map) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		//�Ƿ��ϴ��ɹ��ı�ʶ
		boolean isSuccess=true;
		
		//�����ļ��ϴ�����
		DiskFileUpload disk=new DiskFileUpload();
		
		//�趨�ϴ����ݵ��ַ���
		disk.setHeaderEncoding("utf-8");
		
		//����������ʱ�ļ���
		File tempDirectory=new File("d:/temp");
		
		if(!tempDirectory.exists())
		{
			tempDirectory.mkdir();
		}

		//�趨������ʱ�ļ�
		disk.setRepositoryPath("d:/temp");
		
		//�趨�����ļ���С  ��λ�ֽ�
		disk.setSizeThreshold(1024*10);
		
		//�����ϴ��ļ���С
		disk.setSizeMax(1024*1024*100);
		String fileName="";
		List<String> list = new ArrayList<>();
		try
		{
			//��ȡ��������е���������ȡ�ύ���󼯺�
			List<FileItem> fileList=disk.parseRequest(request);
			//�����ύ�Ķ���
			for(FileItem item : fileList)
			{
				//��ȡ�ϴ��ļ���·��(������file)
				//System.out.println(item.getName());
				//��ȡ��Ԫ�ص�name����
				//System.out.println(item.getFieldName());
				//��ȡ�ļ���С
				//System.out.println(item.getSize());
		
				//�ж��ļ��Ƿ����ϴ�����
				//����ֵtrue��ʾ��Ԫ������ͨ�ı�Ԫ�أ��磺text,password,checkbox��
				//����ֵfalse��ʾ��Ԫ����file�ļ���Ԫ��
				if(!item.isFormField())
				{
//					//�ϴ����ļ���
//					System.out.println(item.getName());
					//��ȡ�ϴ��ļ���������
					InputStream input=item.getInputStream();
					//��ȡ�ϴ��ļ����ļ���
					fileName=item.getName();
					//�����ϴ�·��
					String path="C:\\Users\\admin\\workspace\\APS\\WebContent\\image\\animal\\"+fileName;
					
					//��ȡ�����
					FileOutputStream output=new FileOutputStream(new File(path));
					
					int data;
					
					while((data=input.read())!=-1)
					{
						output.write(data);
					}
					
					output.flush();
					output.close();
					input.close();
					
				}
				else{
					//��ȡ�ַ�����ʽ���ļ�����  �Ǳ�Ԫ��ͨ���÷�����ȡ��Ԫ�ص�ֵ
					//System.out.println(item.getString());
					//�ı�������������Ҫ�ع��ַ���
					list.add(new String(item.getString("iso-8859-1").getBytes("iso-8859-1"),"utf-8"));
				}
				
			}
			
			
		} catch (FileUploadException e)
		{
			isSuccess=false;
			
			request.setAttribute("error", e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e)
		{
			isSuccess=false;
			
			request.setAttribute("error", e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isSuccess)
		{
			//��ȡ�����������
			String token = list.get(6);
			//��ȡsession�е�ԭʼ����
			Object serverToken = request.getSession().getAttribute(Token.TOKEN);
			if(serverToken != null && token.equals(serverToken.toString())){
				Animal animal = new Animal();
				animal.setName(list.get(0));
				animal.setTypeName(list.get(1));
				animal.setVarietyId(Integer.parseInt(list.get(2)));
				animal.setAge(Integer.parseInt(list.get(3)));
				animal.setSex(list.get(4));
				animal.setIntroduction(list.get(5));
				animal.setPicture(fileName);
				animalService.addAnimal(animal);
				request.getSession().removeAttribute(Token.TOKEN);
			}
			map.put("success", "��ӳɹ�");
		}else{
			map.put("success", "���ʧ��");
		}
		return "page/manage";
	}
}
