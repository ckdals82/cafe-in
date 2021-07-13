package dao;

import java.util.List;

import vo.PhotoVo;

public interface PhotoDao {
	
	
	
	//목록조회
	public List<PhotoVo> selectList();
	
	//p_idx에 해당되는 게시물 1건 얻어오기
	public PhotoVo selectOne(int p_idx);
	
	public int insert(PhotoVo vo);	
	
	public int delete(int p_idx);
	
	public int update(PhotoVo vo);
}
