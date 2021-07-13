package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class MemberDaoImpl implements MemberDao {
	
	
	SqlSession sqlSession;
	
	
	//셋터 인젝션 
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//전체목록 보기
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;

		

		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("member.member_list");
				
		
		return list;
	}
	
	//m_idx에 해당되는 회원정보 1건
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;

		

		//String sql = "select * from member where m_idx=?";
		
		
		//2.작업수행
		vo=sqlSession.selectOne("member.member_one_m_idx", m_idx);
		
				
		return vo;
	}
	//m_id에 해당되는 회원정보 1건 얻어오기
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;


		
		//2.작업수행
		vo=sqlSession.selectOne("member.member_one_m_id", m_id);
		
		
		

		//String sql = "select * from member where m_id=?";

				return vo;
	}
	//추가 
	public int insert(MemberVo vo) {

		int res = 0;
		
				
				//작업수행 				mapper_id			parameter
		res = sqlSession.insert("member.member_insert",vo);
				
		
		
		//String sql = "insert into member values(seq_member_m_idx.nextVal,?,?,?,?,?,?,sysdate,sysdate,default)";

		
		return res;
	}
	//삭제
	public int delete(int m_idx) {

	      int res = 0;
	      
			
			//2.작업수행 				mapper_id			parameter
		res = sqlSession.delete("member.member_delete",m_idx);
			
			
			


	      return res;
	   }
	
	//수정
	public int update(MemberVo vo) {

		int res = 0;
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.update("member.member_update",vo);

		
		//String sql =          //  1      2       3          4        5      6         7                                 8
		//"update member set m_name=?,m_id=?,m_pwd=?,m_zipcode=?,m_addr=?,m_ip=?,m_grade=?, m_modifydate=sysdate where m_idx=?";

		
		return res;
	}
	
}
