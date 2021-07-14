package dao;

import org.apache.ibatis.session.SqlSession;

public class TestDaoImpl implements TestDao {
	
	SqlSession SqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		SqlSession = sqlSession;
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		System.out.println("  →TestDaoImpl.test1()call");
		
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void test1(int n) {
		// TODO Auto-generated method stub
		System.out.println("--TestDaoImpl.test1(int)call--");
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		System.out.println("--TestDaoImpl.test2()call--");
	}

}
