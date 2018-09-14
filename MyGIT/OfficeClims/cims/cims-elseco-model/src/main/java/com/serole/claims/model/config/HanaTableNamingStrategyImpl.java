package com.serole.claims.model.config;

import java.io.Serializable;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * A Support utility class the helps in handling the SAP HANA based packages.
 * As we are using the Hana DB Tables that follow a convention of --
 * 			SCHEMA.PACKAGE::TABLENAME
 * 
 * This Class implementation helps in handling the package based tables.
 * And added this class entry in application.properties file as --
 * 
 *          spring.jpa.properties.hibernate.physical_naming_strategy
 *          			=com.serole.claims.model.config.HanaTableNamingStrategyImpl
 *          
 * @author Serole_Vijay
 *
 */
public class HanaTableNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl implements Serializable {

	public static final HanaTableNamingStrategyImpl INSTANCE = new HanaTableNamingStrategyImpl();

	/**
	 * Understand the table name quoted in double quotes along with Package name --
	 * 			PACKAGE::TABLENAME
	 */
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return new Identifier(name.getText(), name.isQuoted());
	}

	/**
	 * Understand the column names represented in a double quotes
	 */
	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return new Identifier(name.getText(), name.isQuoted());
	}
}
