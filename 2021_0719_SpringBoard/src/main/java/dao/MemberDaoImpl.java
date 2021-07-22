package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class MemberDaoImpl implements MemberDao{

	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//��ü��� ����
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;
	
		list = sqlSession.selectList("member.member_list");
		
		return list;
	}
	
	//m_idx�� �ش�Ǵ� ȸ������ 1��
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;
		
		vo = sqlSession.selectOne("member.member_one_m_idx",m_idx);
		
		return vo;
	}
	
	//m_id�� �ش�Ǵ� ȸ������ 1�� ������
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;

		vo = sqlSession.selectOne("member.member_one_m_id",m_id);
		
		return vo;
	}
	
	//�߰�
	public int insert(MemberVo vo) {

		int res = 0;

		res = sqlSession.insert("member.member_insert",vo);

		return res;
	}

	//����
	public int delete(int m_idx) {

		int res = 0;

		res = sqlSession.insert("member.member_delete",m_idx);

		return res;
	}

	//����
	public int update(MemberVo vo) {

		int res = 0;

		res = sqlSession.insert("member.member_update",vo);
		
		return res;
	}
	
	
}
