/**
 * Copyright 2018 PANDA http://io.wrzn
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.hmc.zntc.admin.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chengxinghua
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public static int SUCCESS = 0; //请求正常成功状态
	public static int ERROR = 500; //请求错误状态

	public static int OVERGET = 1; //红包其他状态 抢完了
	public static int NOTSELF = 2; //红包其他状态  自己不能抢
	public static int GETMONEY = 3; //红包其他状态 抢了多少钱


	public R() {
		put("code", SUCCESS);
		put("msg", "success");
	}

	public static R error() {
		return error(ERROR, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(ERROR, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("data", "");
		r.put("msg", msg);
		return r;
	}

	public static R ok(Object object) {
		R r = new R();
		r.put("data", object);
		r.put("msg", "success");
		return r;
	}


	public static R ok(String key,Object object) {
		R r = new R();
		Map<String,Object> map = new HashMap<>();
		map.put(key,object);
		r.put("data", map);
		r.put("msg", "success");
		return r;
	}

	public static R ok(int code , String msg,Map<String, Object> map) {
		R r = new R();
		r.replace("code",code);
		r.replace("msg",msg);
		r.put("data",map);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.put("data",map);
		return r;
	}

	public static R ok() {
//		R r = new R();
//		r.put()
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
