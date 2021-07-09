package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.VisitVo;

public interface VisitDao {
	
	
	
	//전체조회
	public List<VisitVo> selectList();
	//조건별조회
	public List<VisitVo> selectList(Map map);
	
	//idx에 해당되는 데이터 1건얻어오기
	public VisitVo selectOne(int idx);
	
	//추가
	public int insert(VisitVo vo);
	
	//삭제
	public int delete(int idx);
	
	//수정
	public int update(VisitVo vo);

	
	
	
	
	
}
