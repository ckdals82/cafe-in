package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.BoardVo;

public class BoardDaoImpl implements BoardDao {
	
	
	SqlSession sqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public List<BoardVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.board_list");
	}



	@Override
	public List<BoardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BoardVo selectOne(int b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.board_one",b_idx);
	}



	@Override
	public int insert(BoardVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.board_insert",vo);
	}



	@Override
	public int reply(BoardVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.board_reply",vo);
	}



	@Override
	public int update_readhit(int b_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("board.board_update_readhit",b_idx);
	}



	@Override
	public int update_step(BoardVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("board.board_update_step",vo);
	}

	

}