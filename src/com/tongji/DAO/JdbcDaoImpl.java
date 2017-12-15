package com.tongji.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


/**
 * 使用JDBC实现的DAO
 * 使用 QueryRunner 提供其具体的实现
 * @param <T>: 子类需传入的泛型类型. 
 */
public class JdbcDaoImpl<T> implements DAO<T> {

	//因为queryRunner是线程安全的，写在外面也没关系，大家都用同时也就一个人用。
	private QueryRunner queryRunner = null;
	private Class<T> type;
	
	public JdbcDaoImpl() {
		queryRunner = new QueryRunner();
		type = ReflectionUtils.getSuperGenericType(getClass());
	}
	
	@Override
	public void batch(Connection connection, String sql, Object[]... args) throws SQLException {
		queryRunner.batch(connection, sql, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E getForValue(Connection connection, String sql, Object... args) throws SQLException {
		return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
	}

	@Override 
	public List<T> getForList(Connection connection, String sql, Object... args) 
			throws SQLException {
		return queryRunner.query(connection, sql, 
				new BeanListHandler<>(type), args);
	}

	@Override
	public T get(Connection connection, String sql, Object... args) throws SQLException { 
		return queryRunner.query(connection, sql, 
				new BeanHandler<>(type), args);
	}

	@Override
	public void update(Connection connection, String sql, Object... args) throws SQLException {
		queryRunner.update(connection, sql, args);
	}
	
}
