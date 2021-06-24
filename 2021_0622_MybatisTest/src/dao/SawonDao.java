package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : ��ü1���� ���� ����
	static SawonDao single = null;

	//spl Session생성하는 객체
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	//목록가져오기
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		//1,작업객체정보 얻어오기(connection획득 + mapper)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행//작업수행한 결과를 리스트로 가져온것.
		list = sqlSession.selectList("sawon.sawon_list");
		
		//3.반환(닫기)
		sqlSession.close();
		
		
		
		return list;
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		
		List<SawonVo> list = null;
		
		//1,작업객체정보 얻어오기(connection획득 + mapper)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행//작업수행한 결과를 리스트로 가져온것.
		//							 namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		
		//3.반환(닫기)
		sqlSession.close();
		
		
		
		return list;
	}
	

	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub
List<SawonVo> list = null;
		
		//1,작업객체정보 얻어오기(connection획득 + mapper)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행//작업수행한 결과를 리스트로 가져온것.
		//							 namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list_sajob",sajob);
		
		//3.반환(닫기)
		sqlSession.close();
		
		
		
		return list;
	}
	

	public List<SawonVo> selectListt(int year10) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1,작업객체정보 얻어오기(connection획득 + mapper)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행//작업수행한 결과를 리스트로 가져온것.
		//							 namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list_year10",year10);
		
		//3.반환(닫기)
		sqlSession.close();
		
		
		
		return list;
	}

	public List<SawonVo> selectpayList(int sapay) {
	List<SawonVo> list = null;
		
		//1,작업객체정보 얻어오기(connection획득 + mapper)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행//작업수행한 결과를 리스트로 가져온것.
		//							 namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list_sapay",sapay);
		
		//3.반환(닫기)
		sqlSession.close();
		
		
		
		return list;
	}
	
	 public List<SawonVo> selectList(Map map) {
	      // TODO Auto-generated method stub
	      
	      List<SawonVo> list = null;
	      
	      //1.작업객체정보 얻어오기(Connection획득 + Mapper정보)
	      SqlSession sqlSession = factory.openSession();
	      
	      //2.작업수행
	      list = sqlSession.selectList("sawon.sawon_list_condition",map);
	      
	      //3.반환(닫기)
	      sqlSession.close();
	      
	      return list;
	   }

	
	
	
}
