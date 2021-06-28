package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {
	//Mybatis객체
	SqlSessionFactory factory;
	
	//single-ton pattern
	static ProductDao single = null;

	public static ProductDao getInstance() {

		if (single == null)
			single = new ProductDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private ProductDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	//카테고리별 상품검색
	public List<ProductVo> selectList(String p_category){
		List<ProductVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("product.product_list", p_category);
		
		sqlSession.close();
		
		return list;
	}

	public ProductVo selectOne(int p_idx) {
		// TODO Auto-generated method stub
		ProductVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("product.product_one", p_idx);
		
		sqlSession.close();
		
		return vo;
	}
	public int insert(ProductVo vo) {

		int res = 0;
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//작업수행 				mapper_id			parameter
		res = sqlSession.insert("product.product_insert",vo);
		
		 
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()
				
		
		
		return res;
	}
	
	
}
