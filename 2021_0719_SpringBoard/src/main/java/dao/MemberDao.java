package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {

	//��ü��� ����
	public List<MemberVo> selectList();
	
	//m_idx�� �ش�Ǵ� ȸ������ 1��
	public MemberVo selectOne(int m_idx);
	
	//m_id�� �ش�Ǵ� ȸ������ 1�� ������
	public MemberVo selectOne(String m_id);
	
	//�߰�
	public int insert(MemberVo vo);

	//����
	public int delete(int m_idx);

	//����
	public int update(MemberVo vo);
	
	
}
