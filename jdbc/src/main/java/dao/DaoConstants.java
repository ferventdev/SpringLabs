package dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DaoConstants {
    public static final String CREATE_COUNTRY_TABLE_SQL = "CREATE TABLE country(id IDENTITY, name VARCHAR(255), code_name VARCHAR(255))";
    public static final String DROP_COUNTRY_TABLE_SQL = "DROP TABLE country";
}
