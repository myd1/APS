package com.aps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aps.form.DonateForm;
import com.aps.pojo.Donate;
import com.aps.pojo.PayInfo;
import com.aps.service.DonateService;
import com.aps.util.PaymentUtil;

@Controller
public class PayController {
	
	private String keyValue="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
	
	@Autowired
	private DonateService donateService;
	
	@RequestMapping("pay")
	public String pay(HttpServletResponse response)throws IOException{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��������
		String pd_FrpId=request.getParameter("pd_FrpId");
		//��ȡ���׽��
		String p3_Amt=request.getParameter("p3_Amt");
		//��ȡ������,�������̻��ж�������Ψһ
		String p2_Order=request.getParameter("p2_Order");
		
		String 	p0_Cmd="Buy",//ҵ������ BuyΪ����֧��
		p1_MerId="10001126856", //�̻���ţ��̻�֧����Ψһ��ʾ�������ױ�֧������
		p4_Cur="CNY",//����
		p5_Pid="",//������ʾ��Ʒ��Ϣ
		p6_Pcat="",//��Ʒ����
		p7_Pdesc="",//��Ʒ����
		p8_Url="http://localhost:9090/APS/payBack.do",//֧���ɹ���Ļص���ַ
		p9_SAF="",//�Ƿ���Ҫ�û����ͻ���ַ�����ױ�֧��ϵͳ�� 1��ʾ������0��ʾ��������Ĭ��Ϊ0
		pa_MP="",//��Ʒ��չ��Ϣ
		pr_NeedResponse="1";//֧���ɹ���Ӧ��֪ͨ �̶�Ϊ1
		//��ȡ���ܺ��֧���ύ����
		String hmac=PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		//�����ύ��URL
		StringBuffer url=new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		url.append("&p0_Cmd="+p0_Cmd);
		url.append("&p1_MerId="+p1_MerId);
		url.append("&p2_Order="+p2_Order);
		url.append("&p3_Amt="+p3_Amt);
		url.append("&p4_Cur="+p4_Cur);
		url.append("&p5_Pid="+p5_Pid);
		url.append("&p6_Pcat="+p6_Pcat);
		url.append("&p7_Pdesc="+p7_Pdesc);
		url.append("&p8_Url="+p8_Url);
		url.append("&p9_SAF="+p9_SAF);
		url.append("&pa_MP="+pa_MP);
		url.append("&pd_FrpId="+pd_FrpId);
		url.append("&pr_NeedResponse="+pr_NeedResponse);
		url.append("&hmac="+hmac);
//		//�ض�����֧������
//		response.sendRedirect(url.toString());
		return "redirect:"+url.toString();
	}
	
	@RequestMapping("payBack")
	public String payBack(HttpServletResponse response,DonateForm donateForm)throws ServletException, IOException{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setCharacterEncoding("utf-8");
		//��ȡ֧����� 1��ʾ֧���ɹ�
		String r1_Code=request.getParameter("r1_Code");
		String url = "";
		//֧��״̬���� 1��ʾ֧���ɹ�
		if(r1_Code.equals("1")){
			//��ȡ�̼ұ��
			String p1_MerId = request.getParameter("p1_MerId");
			//��ȡ֧�����
			String r3_Amt = request.getParameter("r3_Amt");
			//��ȡ��Ʒ����
			String r5_Pid = request.getParameter("r5_Pid");
			//��ȡ������
			String r6_Order = request.getParameter("r6_Order");
			//��ȡ��������
			String rb_BankId = request.getParameter("rb_BankId");
			//��ȡ֧��ʱ��
			String rp_PayDate = request.getParameter("rp_PayDate");
			//��װ��������
			PayInfo info = new PayInfo(p1_MerId, r3_Amt, r5_Pid, r6_Order, rb_BankId, rp_PayDate);
			request.setAttribute("payInfo", info);
			url = "page/success";
			Donate donate = new Donate();
			donate.setDonateMoney(Double.parseDouble(donateForm.getDonateMoney()));
			donate.setDonateName(donateForm.getDonateName());
			donate.setEmail(donateForm.getEmail());
			donate.setPhone(donateForm.getPhone());
			donate.setMessage(donateForm.getMessage());
			donateService.addDonate(donate);
		}
		else{
			request.setAttribute("error", "֧��ʧ�ܣ�");
			url = "page/failure";
		}
		return url;
	}
}
