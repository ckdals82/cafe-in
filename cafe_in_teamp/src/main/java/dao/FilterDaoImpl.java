package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CafeSearchVo;

public class FilterDaoImpl implements FilterDao {
	
	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<CafeSearchVo> selecList(CafeSearchVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("filter.filter_list",vo);
	}
	
	
}
