/**
* Title: DAO.java
* Description: DAO接口，为什么要定义接口？因为我们可能基于不同框架实现DAO比如JDBC或者hibernate
* 所以定义为方法，以后谁要实现就实现这个接口就行。
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月15日
* @version 1.0
*/
package com.tongji.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**  
* Title: DAO 
* Description:  
* @author mdm(computer in lab)  
* @date 2017年12月15日  
*/
public interface DAO<T> {
	/**
	 * 批量处理的方法
	 * @param connection
	 * @param sql
	 * @param args: 填充占位符的 Object [] 类型的可变参数.
	 * @throws SQLException 
	 */  
	void batch(Connection connection, 
			String sql, Object [] ... args) throws SQLException;
	
	/**
	 * 返回具体的一个值, 例如总人数, 平均工资, 某一个人的 email 等.
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	<E> E getForValue(Connection connection,
			String sql, Object ... args) throws SQLException;
	
	/**
	 * 返回 T 的一个集合
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	List<T> getForList(Connection connection,
			String sql, Object ... args) throws SQLException;
	
	/**
	 * 返回一个 T 的对象
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	T get(Connection connection, String sql, 
			Object ... args) throws SQLException;
	
	/**
	 * INSRET, UPDATE, DELETE
	 * @param connection: 数据库连接
	 * @param sql: SQL 语句
	 * @param args: 填充占位符的可变参数.
	 * @throws SQLException 
	 */
	void update(Connection connection, String sql, 
			Object ... args) throws SQLException;
}
