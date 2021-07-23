package dao;

import java.util.List;

import vo.CommentVo;

public interface CommentDao {
	
	List<CommentVo> selectList(int b_idx);
	int				insert(CommentVo vo) throws Exception;
	int				delete(CommentVo vo) throws Exception;
	
	default int		update(int c_idx) throws Exception  {return 0;}
}
