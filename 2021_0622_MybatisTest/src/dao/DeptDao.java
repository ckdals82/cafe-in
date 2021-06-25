package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {
	
	SqlSessionFactory factory;
	
	//single-ton pattern
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<DeptVo> selectList(){
		
		List<DeptVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("dept.dept_list");
		
		sqlSession.close();
		
		return list;
	}
}
