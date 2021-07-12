package org.zerock.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)//j유닛 사용할때 스프링을 사용하겠다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//스프링 관련 설정 위치 지정
public class DataSourceTests {
	
	@Setter(onMethod_ = {@Autowired})
	DataSource datasource;
	
	@Setter(onMethod_ = {@Autowired})
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try {
			Connection con = datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMyBatis() {
		SqlSession session=sqlSessionFactory.openSession();
		Connection con = session.getConnection();
		
	}
	
}
