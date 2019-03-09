package com.hmc.zntc.admin.utils.chuanglansms;

import com.alibaba.fastjson.JSON;
import com.hmc.zntc.admin.utils.chuanglansms.request.SmsSendRequest;
import com.hmc.zntc.admin.utils.chuanglansms.request.SmsVariableRequest;
import com.hmc.zntc.admin.utils.chuanglansms.response.SmsSendResponse;
import com.hmc.zntc.admin.utils.chuanglansms.response.SmsVariableResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;

/**
 * 创蓝短信工具类
 * @author peng
 * @since 2018-04-26
 */
public class ChuangLanSmsUtil {

	// 创蓝API账号
	private static final String ACCOUNT = "N8111552";
	// 创蓝API密码(非登录密码)
	private static final String PASSWORD = "ZH317sqbS";
	// 变量短信发送的URL
	private static final String VARIABLE_REQUEST_URL = "http://smssh1.253.com/msg/variable/json";
	// 单条短信发送的URL
	private static final String SINGLE_REQUEST_URL = "http://smssh1.253.com/msg/send/json";

	private static SecureRandom random = new SecureRandom();
	/**
	 * 发送短信
	 * @param phone 电话号码
	 * @param message 短信内容
	 * @return
	 */
	public static boolean send(String phone, String message) {
		SmsSendRequest request = new SmsSendRequest(ACCOUNT, PASSWORD, message, phone, "true");
		String result = sendSmsByPost(SINGLE_REQUEST_URL, JSON.toJSONString(request));
		SmsSendResponse response = JSON.parseObject(result, SmsSendResponse.class);

		if ("0".equals(response.getCode())) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 生成6位数的短信验证码
	 *
	 * @return
	 */
	public static String generateVerifyCode() {
		String str = String.valueOf(Math.abs(random.nextLong()));
		return str.substring(0, 6);
	}
	/**
	 * 动态发送短信
	 * @param phone 电话号码
	 * @param message 短信内容
	 * <p>内容格式：【有金兑】尊敬的{$var}，您好！您的验证码是{$var}，{$var}分钟内有效</p>
	 * @param params 参数
	 * <p>参数数量要与内容中的点位符数量相等</p>
	 * @return
	 */
	public static boolean send(String phone, String message, String... params) {
		String param = buildParam(params, phone);
		return sendVariable(message, param);
	}

	/**
	 * 动态发送多条短信
	 * @param phones 电话号码
	 * @param message 短信内容
	 * <p>内容格式：【有金兑】尊敬的{$var}，您好！您的验证码是{$var}，{$var}分钟内有效</p>
	 * @param params 参数
	 * <p>参数数量要与内容中的点位符数量相等</p>
	 * @return
	 */
	public static boolean send(String[] phones, String message, String... params) {
		String param = buildParam(params, phones);
		return sendVariable(message, param);
	}

	private static boolean sendVariable(String message, String param) {
		SmsVariableRequest request = new SmsVariableRequest(ACCOUNT, PASSWORD, message, param, "true");
		String result = ChuangLanSmsUtil.sendSmsByPost(VARIABLE_REQUEST_URL, JSON.toJSONString(request));
		SmsVariableResponse response = JSON.parseObject(result, SmsVariableResponse.class);

		if ("0".equals(response.getCode())) {
			return true;
		} else {
			return false;
		}
	}

	private static String buildParam(String[] params, String... phones) {
		StringBuilder builder = new StringBuilder();
		for (String phone : phones) {
			builder.append(phone);
			for (String param : params) {
				builder.append(',');
				builder.append(param);
			}
			builder.append(';');
		}

		return builder.toString();
	}

	/**
	 * @param path
	 * @param postContent
	 * @return
	 */
	private static String sendSmsByPost(String path, String postContent) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");// 提交模式
			httpURLConnection.setConnectTimeout(10000);// 连接超时 单位毫秒
			httpURLConnection.setReadTimeout(10000);// 读取超时 单位毫秒

			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/json");

			httpURLConnection.connect();
			OutputStream os = httpURLConnection.getOutputStream();
			os.write(postContent.getBytes("UTF-8"));
			os.flush();

			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				// 开始获取数据
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
