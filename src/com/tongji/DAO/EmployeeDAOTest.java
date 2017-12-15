/**
* Title: EmployeeDAOTest.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017��12��15��
* @version 1.0
*/
package com.tongji.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

/**  
* Title: EmployeeDAOTest 
* Description:  
* @author mdm(computer in lab)  
* @date 2017��12��15��  
*/
class EmployeeDAOTest {

	/**
	 * {@link com.tongji.DAO.JdbcDaoImpl#JdbcDaoImpl()} �Ĳ��Է�����
	 */
	EmployeeDAO employeeDao=new EmployeeDAO();

	/**
	 * {@link com.tongji.DAO.JdbcDaoImpl#get(java.sql.Connection, java.lang.String, java.lang.Object[])} �Ĳ��Է�����
	 */
	@Test
	void testGet() {
		Connection connection=null;
		try {
			String sql="select last_name from employees where employee_id=?";
			connection=JDBCTools.getConnection();
			Employee employee=employeeDao.get(connection, sql, 135);
			System.out.println(employee);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}
	/**
	 * {@link com.tongji.DAO.JdbcDaoImpl#batch(java.sql.Connection, java.lang.String, java.lang.Object[][])} �Ĳ��Է�����
	 */
	@Test
	void testBatch() {
		fail("��δʵ��");
	}

	/**
	 * {@link com.tongji.DAO.JdbcDaoImpl#getForValue(java.sql.Connection, java.lang.String, java.lang.Object[])} �Ĳ��Է�����
	 */
	@Test
	void testGetForValue() {
		fail("��δʵ��");
	}

	/**
	 * {@link com.tongji.DAO.JdbcDaoImpl#getForList(java.sql.Connection, java.lang.String, java.lang.Object[])} �Ĳ��Է�����
	 */
	@Test
	void testGetForList() {
		fail("��δʵ��");
	}


	/**
	 * {@link com.tongji.DAO.JdbcDaoImpl#update(java.sql.Connection, java.lang.String, java.lang.Object[])} �Ĳ��Է�����
	 */
	@Test
	void testUpdate() {
		fail("��δʵ��");
	}

}
