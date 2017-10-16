package dao;

import model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CODE_NAME = "code_name";

	public Country mapRow(ResultSet rs, int i) throws SQLException {
		return new Country(rs.getInt(ID), rs.getString(NAME), rs.getString(CODE_NAME));
	}
}
