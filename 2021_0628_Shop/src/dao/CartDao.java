package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {
	
	SqlSessionFactory factory;
	
	//single-ton pattern
	static CartDao single = null;

	public static CartDao getInstance() {

		if (single == null)
			single = new CartDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private CartDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//유저별 장바구니 조회
	public List<CartVo> selectList(int m_idx){
		
		List<CartVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("cart.cart_list", m_idx);
		
		sqlSession.close();
		
		return list;
	}

	public int selectTotalAmount(int m_idx) {
		// TODO Auto-generated method stub
		int total_amount =0;
		
		SqlSession sqlSession = factory.openSession();
		
		total_amount = sqlSession.selectOne("cart.cart_total_amount",m_idx);
		
		sqlSession.close();
		
		return total_amount;
	}

	public int update(CartVo vo) {
		// TODO Auto-generated method stub
		int res=0;
		
		SqlSession sqlSession = factory.openSession(true);//true : auto commit
		
		res = sqlSession.update("cart.cart_update",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;

		//작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행
		res = sqlSession.delete("cart.cart_delete",c_idx);
		
		//3.닫기
		sqlSession.close();
		
		return res;
	}

	public CartVo selectOne(CartVo paramVo) {
		// TODO Auto-generated method stub
		CartVo vo = null;
		SqlSession sqlSession = factory.openSession();
		
		vo=sqlSession.selectOne("cart.cart_one",paramVo);
		
		sqlSession.close();
		
		return vo;
	}

	public int insert(CartVo paramVo) {
		// TODO Auto-generated method stub
		int res = 0;

		//작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행
		res = sqlSession.insert("cart.cart_insert",paramVo);
		
		//3.닫기
		sqlSession.close();
		
		return res;
	}
}
