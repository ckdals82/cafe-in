package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDaoImpl implements DeptDao {
	
	SqlSession sqlSession = null;
	
	//constructor injection(굳이 기본생성자를 생성할 필요가 없다)
	public DeptDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}


	@Override
	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		List<DeptVo> list = sqlSession.selectList("dept.dept_list");
		
		return list;
	}

}
