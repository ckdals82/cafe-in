package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVo;

public interface BoardDao {
	
	List<BoardVo> selectList();
	List<BoardVo> selectList(Map map);
	BoardVo 	  selectOne(int b_idx);
	
	int 		  insert(BoardVo vo) throws Exception;
	int 		  reply(BoardVo vo) throws Exception;
	int			  update_readhit(int b_idx) throws Exception;
	int			  update_step(BoardVo vo) throws Exception; //답글달기전 작업내용
	default int delete(int b_idx) throws Exception { return 0;}
}