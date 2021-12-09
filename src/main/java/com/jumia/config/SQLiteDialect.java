package com.jumia.config;

import org.hibernate.dialect.Dialect;

import java.sql.Types;

public class SQLiteDialect extends Dialect {
  public SQLiteDialect() {
    registerColumnType(Types.INTEGER, "id");
    registerColumnType(Types.VARCHAR, "name");
    registerColumnType(Types.VARCHAR, "phone");
  }
}
