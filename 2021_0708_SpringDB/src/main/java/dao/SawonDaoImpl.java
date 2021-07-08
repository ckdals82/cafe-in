package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVo;

public class SawonDaoImpl {
	
	SqlSession sqlSession = null;
	
	//기본생성자
	public SawonDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	};
	
	@Override
	public List<SawonVo> selectList(){
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list");
		
		return list;
	}
	
}
