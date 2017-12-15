/**
* Title: DAO.java
* Description: DAO�ӿڣ�ΪʲôҪ����ӿڣ���Ϊ���ǿ��ܻ��ڲ�ͬ���ʵ��DAO����JDBC����hibernate
* ���Զ���Ϊ�������Ժ�˭Ҫʵ�־�ʵ������ӿھ��С�
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017��12��15��
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
* @date 2017��12��15��  
*/
public interface DAO<T> {
	/**
	 * ��������ķ���
	 * @param connection
	 * @param sql
	 * @param args: ���ռλ���� Object [] ���͵Ŀɱ����.
	 * @throws SQLException 
	 */  
	void batch(Connection connection, 
			String sql, Object [] ... args) throws SQLException;
	
	/**
	 * ���ؾ����һ��ֵ, ����������, ƽ������, ĳһ���˵� email ��.
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	<E> E getForValue(Connection connection,
			String sql, Object ... args) throws SQLException;
	
	/**
	 * ���� T ��һ������
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	List<T> getForList(Connection connection,
			String sql, Object ... args) throws SQLException;
	
	/**
	 * ����һ�� T �Ķ���
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
	 * @param connection: ���ݿ�����
	 * @param sql: SQL ���
	 * @param args: ���ռλ���Ŀɱ����.
	 * @throws SQLException 
	 */
	void update(Connection connection, String sql, 
			Object ... args) throws SQLException;
}
