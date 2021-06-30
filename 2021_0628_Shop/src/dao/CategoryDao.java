package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CategoryVo;

public class CategoryDao {
	
	SqlSessionFactory facotory;
	
	//single-ton pattern
	static CategoryDao single = null;

	public static CategoryDao getInstance() {

		if (single == null)
			single = new CategoryDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private CategoryDao() {
		// TODO Auto-generated constructor stub
		facotory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//목록조회( 손수작성)
	public List<CategoryVo> selectList(){
		
		List<CategoryVo> list = null;
		
		SqlSession sqlSession = facotory.openSession();
		
		list = sqlSession.selectList("category.category_list");
		
		sqlSession.close();
		
		return list;
		
	}
}
