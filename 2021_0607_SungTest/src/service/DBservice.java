package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBservice {

		DataSource ds = null;
		
		//single-ton pattern
		static DBservice single = null;

		public static DBservice getInstance() {

			if (single == null)
				single = new DBservice();
			return single;
		}

		// private생성자 : 외부에서 직접생성하지 말아라
		private DBservice() {
			// TODO Auto-generated constructor stub
			
			
			try {
				//1.JNDI(Java Naming Directory interface) 기술을 이용해서 정보추출하는 객체
				//		검색
				InitialContext ic = new InitialContext();
				
				//2.자원을 소유한 Context정보추출
				Context context = (Context) ic.lookup("java:comp/env");
				
				//3.Context내에 DBCP객체정보 얻어온다.
				ds = (DataSource) context.lookup("jdbc/oracle_test");
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Connection getConnection() throws SQLException {
			return ds.getConnection();
		}
		
}
