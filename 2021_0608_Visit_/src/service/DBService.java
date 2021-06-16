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

	// private������ : �ܺο��� ������������ ���ƶ�
	private DBService() {
		// TODO Auto-generated constructor stub
		
		try {//JNDI ���  : �̸̹������ �������̽��� DBService�� ����Ÿ�ҽ�Ÿ������ ������ ���
			
			// 1.JNDI(Java Naming Directory(�˻�) Interface) ��� �̿��ؼ� �����ϴ� ��ü
			InitialContext ic = new InitialContext();
			
			// 2. �ڿ��� ������ Context��������
			Context context = (Context) ic.lookup("java:comp/env");	// Context�� �ٿ�ĳ���� "java:comp/env" �����ø����̼�������ġ... �ܿ��� �׳�
			
			// 3. Context���� name�� �̿��ؼ� DBCP��ü ������ ���´�
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();	// connection �ϳ� �޶�� ��
		
	}
	
}