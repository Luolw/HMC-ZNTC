package com.hmc.zntc.admin.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class PayUtil {





	/**
	 * 生成订单号
	 *
	 * @return
	 */
	public static String getTradeNo() {
		// 随机8位数
		Integer randomNum = new Random().nextInt(90000000) + 10000000;
		return "T" + System.currentTimeMillis() + randomNum;
	}

	/**
	 * 提现单号
	 *
	 * @return
	 */
	public static String getCashNo() {
		// 随机8位数
		Integer randomNum = new Random().nextInt(90000000) + 10000000;
		return "C" + System.currentTimeMillis() + randomNum;
	}

	/**
	 * 红包id
	 *
	 * @return
	 */
	public static String getredApackNumber() {
		// 随机8位数
		Integer randomNum = new Random().nextInt(90000000) + 10000000;
		return "R" + System.currentTimeMillis() + randomNum;
	}


	/**
	 * 返回客户端ip
	 *
	 * @param request
	 * @return
	 */
	public static String getRemoteAddrIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	/**
	 * 获取服务器的ip地址
	 *
	 * @param request
	 * @return
	 */
	public static String getLocalIp(HttpServletRequest request) {
		return request.getLocalAddr();
	}

	public static String getSign(Map<String, String> params, String paternerKey) throws UnsupportedEncodingException {
		return MD5Util.md5(createSign(params, false) + "&key=" + paternerKey).toUpperCase();
	}

	/**
	 * 构造签名
	 *
	 * @param params
	 * @param encode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createSign(Map<String, String> params, boolean encode) throws UnsupportedEncodingException {
		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			// 参数为空不参与签名
			if (key == null || StringUtils.isBlank(params.get(key))){
				continue;
			}
			if (first) {
				first = false;
			} else {
				temp.append("&");
			}
			temp.append(key).append("=");
			Object value = params.get(key);
			String valueStr = "";
			if (null != value) {
				valueStr = value.toString();
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueStr, "UTF-8"));
			} else {
				temp.append(valueStr);
			}
		}
		return temp.toString();
	}


	/**
	 * 支付时间戳
	 * @return
	 */
	public static String payTimestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}


	public static final String RED_MONEY = "money";

}
