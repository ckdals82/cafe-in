package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.PhotoVo;

public class PhotoDao {
	
	
	//mybatis객체
	SqlSessionFactory factory;
	
	//single-ton pattern
	static PhotoDao single = null;

	public static PhotoDao getInstance() {

		if (single == null)
			single = new PhotoDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private PhotoDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//목록조회
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = null;
		
		//작업객체정보 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("photo.photo_list");
		
		//3.닫기 : Connection close()
		sqlSession.close();

		
		return list;
	}
	
	//p_idx에 해당되는 게시물 1건 얻어오기
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		
		//1.작업객체 가져오기
		SqlSession sqlSession = factory.openSession();
				
				//2.작업수행
		vo=sqlSession.selectOne("photo.photo_one", p_idx);
				
				
				
				//3.닫기
		sqlSession.close();
				
		
				return vo;
	}
	public int insert(PhotoVo vo) {

		int res = 0;
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//작업수행 				mapper_id			parameter
		res = sqlSession.insert("photo.photo_insert",vo);
		
		
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()
				
		
		
		return res;
	}
	
	public int delete(int p_idx) {

		int res = 0;
		

		
		//1.작업객체 얻어오기	true: auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.delete("photo.photo_delete",p_idx);
		
		
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()

	

		return res;
	}
	public int update(PhotoVo vo) {

		int res = 0;
		//1.작업객체 얻어오기	true: auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.update("photo.photo_update",vo);
		
		
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()




		return res;
	}
}
