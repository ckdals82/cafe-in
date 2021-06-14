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
		
		try {
			// 1.JNDI(Java Naming Directory Interface) 기술을 이용해서 정보추출하는 객체
			//						검색	
			InitialContext ic = new InitialContext();
			
			// 2.자원을 소유한 Context정보를 추출
			Context context = (Context) ic.lookup("java:comp/env"); // java:comp/env 상수느낌으로 외워서 써야한다.
							 // down casting 
			
			// 3.Context 내에 DBCP객체정보 얻어온다.
			ds = (DataSource) context.lookup("jdbc/oracle_test"); //context 의 name값. context 내에 리소스가 여러개있을경우 식별하기위한 식별자느낌.
					//형변환
					//try 안에있는게 JNDI 기술.
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
	}
	
	
	
	
}
