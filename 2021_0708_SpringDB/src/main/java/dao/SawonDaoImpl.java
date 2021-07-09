package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVo;

public class SawonDaoImpl implements SawonDao {
	
	SqlSession sqlSession = null;
	
	
	
	public SawonDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}



	@Override
	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		List<SawonVo> list = sqlSession.selectList("sawon.sawon_list");
		
		return list;
	}

}
