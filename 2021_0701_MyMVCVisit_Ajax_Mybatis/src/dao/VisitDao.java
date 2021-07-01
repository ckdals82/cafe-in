package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {
	
	//Mybatis객체
	SqlSessionFactory factory;
	
	//single-ton pattern
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	// private������ : �ܺο��� ������������ ���ƶ�
	private VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	//��ü��ȸ     _selectlist ���ø�
	public List<VisitVo> selectList() { // ��Ʈ�� ����Ʈ O �Ǵ� ��ܿ� source���� ����Ʈ �����ָ�ȴ�.
		
		List<VisitVo> list = null;  //������ ���� arraylist 
		//1.작업객체정보 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("visit.visit_list");
		
		//3.닫기 : Connection close()
		sqlSession.close();
		
		
		
		return list;
	}
	public List<VisitVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;  //������ ���� arraylist 
		//1.작업객체정보 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 (sql문으로 셀렉트 리스트)
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		//3.닫기 : Connection close()
		sqlSession.close();
		
		
		
		return list;
	}
	
	//idx�� �ش�Ǵ� ������ 1�� ������
	public VisitVo selectOne(int idx) { //���������� �˾ƾߵǴϱ� idx�� �����°Ŵ�. 
										//selectone�� primaryŰ�� ��ȸ. �ϳ��������;��ϱ⶧�� ������� ip�������� �ϳ��� ���������� idx���� ������ �ͼ� ����
		VisitVo vo = null;

		//1.작업객체 가져오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행
		vo=sqlSession.selectOne("visit.visit_one", idx);
		
		
		
		//3.닫기
		sqlSession.close();
		
		
				return vo;
	}
	
	//�߰�	_insert_delete ���ø�
	public int insert(VisitVo vo) { // �Ʒ� sql ?ǥ�õ� 4�����ε����� Visitvo vo�� ����

		int res = 0; 
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//작업수행 				mapper_id			parameter
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//trasaction작업내용 적용
		sqlSession.commit();
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()
		
		
		return res;
	}
	
	//����
	public int delete(int idx) {

		int res = 0;
		
		//1.작업객체 얻어오기	true: auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행 				mapper_id			parameter
		res = sqlSession.delete("visit.visit_delete",idx);
		
		
		
		//3.닫기
		sqlSession.close();//commit안된상태에서 닫히면 rollback()


			
		return res;
	}
	
	//����
	public int update(VisitVo vo) {
		
		
		
		int res = 0;
		//1.작업객체 얻어오기	true: auto commit
				SqlSession sqlSession = factory.openSession(true);
				
				//2.작업수행 				mapper_id			parameter
				res = sqlSession.update("visit.visit_update",vo);
				
				
				
				//3.닫기
				sqlSession.close();//commit안된상태에서 닫히면 rollback()


		
		//									  1           2       3      4                               5
		//String sql = "update visit set name = ? , content=? , pwd=? , ip=? , regdate=sysdate where idx = ?";
										   // ?�� ���°� ' '�� �ʿ䰡����. 

		return res;
	}

	
	
	
	
	
}
