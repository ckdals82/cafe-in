package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {
	
	SqlSessionFactory factory;

	//single-ton pattern
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private MemberDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//전체목록 보기
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;

		SqlSession sqlSession = factory.openSession();

		//String sql = "select * from member order by m_idx";
		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("member.member_list");
				
		//3.닫기 : Connection close()
		sqlSession.close();
		
		return list;
	}
	
	//m_idx에 해당되는 회원정보 1건
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;

		

		//String sql = "select * from member where m_idx=?";
		
		//1.작업객체 가져오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행
		vo=sqlSession.selectOne("member.member_one_m_idx", m_idx);
		
		//3.닫기
		sqlSession.close();
				
		return vo;
	}
	//m_id에 해당되는 회원정보 1건 얻어오기
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;


		//1.작업객체 가져오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행
		vo=sqlSession.selectOne("member.member_one_m_id", m_id);
		
		
		
		//3.닫기
		sqlSession.close();

		//String sql = "select * from member where m_id=?";

				return vo;
	}
	//추가 
	public int insert(MemberVo vo) {

		int res = 0;
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);
				
				//작업수행 				mapper_id			parameter
		res = sqlSession.insert("member.member_insert",vo);
				
		
				
				//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()
				
				
		
		
		//String sql = "insert into member values(seq_member_m_idx.nextVal,?,?,?,?,?,?,sysdate,sysdate,default)";

		
		return res;
	}
	//삭제
	public int delete(int m_idx) {

	      int res = 0;
	      
	    //1.작업객체 얻어오기	true: auto commit
		SqlSession sqlSession = factory.openSession(true);
			
			//2.작업수행 				mapper_id			parameter
		res = sqlSession.delete("member.member_delete",m_idx);
			
			
			
			//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()


	      return res;
	   }
	
	//수정
	public int update(MemberVo vo) {

		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.update("member.member_update",vo);
		
		
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()



		
		//String sql =          //  1      2       3          4        5      6         7                                 8
		//"update member set m_name=?,m_id=?,m_pwd=?,m_zipcode=?,m_addr=?,m_ip=?,m_grade=?, m_modifydate=sysdate where m_idx=?";

		
		return res;
	}
	
}
