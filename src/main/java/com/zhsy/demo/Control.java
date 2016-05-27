package com.zhsy.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class Control extends Controller {

	public void index() {
		renderText("use jfianl");
	}

	public void jsp() {
		render("/test.jsp");
	}

	public void jsp1() {
		renderJsp("/test.jsp");
	}

	public void jsp2() {
		renderJsp("test.jsp");
	}

	public void json() {
		Map<String, Object> map = new HashMap<>();
		map.put("age", 32);
		map.put("name", "zhsy");
		map.put("id", 1);

		setAttr("data", map);
		renderJson();
	}

	public void json1() {
		Map<String, Object> map = new HashMap<>();
		map.put("age", 32);
		map.put("name", "zhsy");
		map.put("id", 1);

		// setAttr("data", map);
		renderJson();
	}

	public void json2() {
		User user = new User();
		user.setName("zhsy");
		renderJson(user);
	}

	public void json3() {
		new User().set("id", 33).set("name", "three").set("age", 33).save();

		User user = User.dao.findById(3);
		renderJson(user);

	}

	public void json4() {
		List<Record> users = Db.find("select * from user");
		renderJson(users);

	}

}
