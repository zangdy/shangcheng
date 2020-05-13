package com.offfcn.util;

import java.util.Random;

import javax.servlet.http.HttpSession;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SendSmsUtil {
	
	 //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIxgp0t6zp7zFi";
    static final String accessKeySecret = "JYMeXTaX9QrffLPE2htsQkvNQjlfgz";

    
    
    
    
    //发送短信的主要方法
    public static String sendSms(String phone,HttpSession session) {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		
	        IAcsClient acsClient = new DefaultAcsClient(profile);
	
	        //组装请求对象-具体描述见控制台-文档部分内容
	        SendSmsRequest request = new SendSmsRequest();
	        //必填:待发送手机号 根据真实手机号填写
	        request.setPhoneNumbers(phone);
	        //必填:短信签名-可在短信控制台中找到 
	        request.setSignName("优就业");
	        //必填:短信模板-可在短信控制台中找到
	        request.setTemplateCode("SMS_177257767");
	        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	        //真实开发需要将code他替换成 真实的随机数 0-999999 之间随机
	        Integer code = new Random().nextInt(899999)+100000;
	        //使用个人的手机号作为存储session的属性名 避免多人冲突
	        session.setAttribute(phone, code);
	        request.setTemplateParam("{ \"code\":\""+code+"\"}");
	        System.out.println(code+"---验证码----");
	        //hint 此处可能会抛出异常，注意catch
	        //SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
	        //System.out.println("Code=" + sendSmsResponse.getCode());
	        //return sendSmsResponse.getCode();
	        return "OK";
        } catch (ClientException e) {
			
			e.printStackTrace();
			return "";
		}
    }


}
