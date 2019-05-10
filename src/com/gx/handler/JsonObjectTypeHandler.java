package com.gx.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.alibaba.fastjson.JSONObject;

public class JsonObjectTypeHandler extends BaseTypeHandler<JSONObject> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, JSONObject parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
			ps.setString(i, String.valueOf(parameter.toJSONString()));
	}

	@Override
	public JSONObject getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		String str = rs.getString(columnName);
		if(str != null) {
			return JSONObject.parseObject(str);
		}
		return null;
	}

	@Override
	public JSONObject getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String str = rs.getString(columnIndex);
		if(str != null) {
			return JSONObject.parseObject(str);
		}
		return null;
	}

	@Override
	public JSONObject getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String str = cs.getString(columnIndex);
		if(str != null) {
			return JSONObject.parseObject(str);
		}
		return null;
	}

	
	
}
