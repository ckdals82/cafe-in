package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	DataSource ds = null;
	
	//single-ton pattern
	static DBService single = null;

	public static DBService getInstance() {

		if (single == null)
			single = new DBService();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private DBService() {
		// TODO Auto-generated constructor stub
		
		try {//JNDI 기술  : 이미만들어진 인터페이스를 DBService가 데이타소스타입으로 얻어오는 기술
			
			// 1.JNDI(Java Naming Directory(검색) Interface) 기술 이용해서 추출하는 객체
			InitialContext ic = new InitialContext();
			
			// 2. 자원을 소유한 Context정보추출
			Context context = (Context) ic.lookup("java:comp/env");	// Context로 다운캐스팅 "java:comp/env" 웹어플리케이션정보위치... 외워라 그냥
			
			// 3. Context내에 name을 이용해서 DBCP객체 정보를 얻어온다
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();	// connection 하나 달라는 뜻
		
	}
	
}
