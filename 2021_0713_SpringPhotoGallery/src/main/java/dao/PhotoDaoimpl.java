package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.PhotoVo;

public class PhotoDaoimpl implements PhotoDao {
	
	
	SqlSession sqlSession;
	
	
	//셋터 인젝션
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	
	//목록조회
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = null;
		
		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("photo.photo_list");
		

		
		return list;
	}
	
	//p_idx에 해당되는 게시물 1건 얻어오기
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		
				
				//2.작업수행
		vo=sqlSession.selectOne("photo.photo_one", p_idx);
				
		
				return vo;
	}
	public int insert(PhotoVo vo) {

		int res = 0;
		
		
		//작업수행 				mapper_id			parameter
		res = sqlSession.insert("photo.photo_insert",vo);
		
		
		
		return res;
	}
	
	public int delete(int p_idx) {

		int res = 0;
		

		//2.작업수행 				mapper_id			parameter
		res = sqlSession.delete("photo.photo_delete",p_idx);
		
	

		return res;
	}
	public int update(PhotoVo vo) {

		int res = 0;
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.update("photo.photo_update",vo);
		
		

		return res;
	}
}
