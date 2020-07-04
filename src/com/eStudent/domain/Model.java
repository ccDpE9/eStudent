package com.eStudent.domain;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Model {
	protected void save() {
		String model = this.getClass().getName().toLowerCase().substring(6) + "s";
		String values = "";
		String fields = "";
		for(Field field: this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
				fields += field.getName() + ", ";
				try {
					if (field.getType().isAssignableFrom(Integer.TYPE)) values += field.get(this) + ", ";
					else values += "\"" + field.get(this) + "\"" + ", ";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		fields = fields.substring(0, fields.length()-2);
		values = values.substring(0, values.length()-2);
		
		fields = fields.substring(0, fields.length()-2);
		values = values.substring(0, values.length()-2);
		
		String sql = String.format("insert into %s(%s) values(%s);", model, fields, values);
	}
}