package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

public class VisitDaoImpl implements VisitDao{
	
	//Spring에서 생성된 SqlSessionTempate의 사용방법(interface)받는다
	SqlSession sqlSession;
	
	//스프링에서 setter injection으로 sqlsession 연결해주기 위해서
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	//조건별조회
	public List<VisitVo> selectList() { 
		List<VisitVo> list = null;  
		
		//2.작업수행
		list = sqlSession.selectList("visit.visit_list");
		
		
		return list;
	}
	public List<VisitVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;  //������ ���� arraylist 
		
		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		return list;
	}
	
	//idx�� �ش�Ǵ� ������ 1�� ������
	public VisitVo selectOne(int idx) { //���������� �˾ƾߵǴϱ� idx�� �����°Ŵ�. 
										//selectone�� primaryŰ�� ��ȸ. �ϳ��������;��ϱ⶧�� ������� ip�������� �ϳ��� ���������� idx���� ������ �ͼ� ����
		VisitVo vo = null;
		
		//2.작업수행
		vo=sqlSession.selectOne("visit.visit_one", idx);
		
		
		
		
				return vo;
	}
	
	//�߰�	_insert_delete ���ø�
	public int insert(VisitVo vo) { // �Ʒ� sql ?ǥ�õ� 4�����ε����� Visitvo vo�� ����

		int res = 0; 
		
		
		//작업수행 				mapper_id			parameter
		res = sqlSession.insert("visit.visit_insert",vo);
		
		
		
		
		return res;
	}
	
	//����
	public int delete(int idx) {

		int res = 0;
		
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.delete("visit.visit_delete",idx);
		
			
		return res;
	}
	
	//����
	public int update(VisitVo vo) {
		
		
		
		int res = 0;
				
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.update("visit.visit_update",vo);
				

		return res;
	}

	
	
	
	
	
}
