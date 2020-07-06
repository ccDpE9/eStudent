package com.eStudent.domain;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class Model {
	protected void save() {
		String model = this.getClass().getName().toLowerCase().substring(6) + "s";
        Map<String, String> data = new HashMap<>();

		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				data.put(field.getName(), "\"" + field.get(this) + "\"");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		String sql = String.format("insert into %s(%s) values(%s);", model, String.join(", ", data.keySet()), String.join(", ", data.values()));
	}
	
	protected void delete() {
		String model = this.getClass().getName().toLowerCase().substring(6) + "s";
		int id = 0;
		try {
			Field field = this.getClass().getDeclaredField("id");
			field.setAccessible(true);
			id = field.getInt(this);
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		String sql = String.format("delete from %s where id = %s", model, id);
	}
}
