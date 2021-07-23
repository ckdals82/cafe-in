package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CommentVo;

public class CommentDaoImpl implements CommentDao {
	
	SqlSession sqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<CommentVo> selectList(int b_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("comment.comment_list",b_idx);
	}

	@Override
	public int insert(CommentVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("comment.comment_insert",vo);
	}

	@Override
	public int delete(CommentVo vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
