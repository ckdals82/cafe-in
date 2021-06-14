package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {
	
	//single-ton pattern
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	// private생성자 : 외부에서 직접생성하지 말아라
	private VisitDao() {
		// TODO Auto-generated constructor stub
		
	}
	
	//전체조회     _selectlist 템플릿
	public List<VisitVo> selectList() { // 컨트롤 쉬프트 O 또는 상단에 source에서 임포트 시켜주면된다.
		
		List<VisitVo> list = new ArrayList<VisitVo>();  //데이터 모델은 arraylist 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from visit order by idx desc";
		
		try {
			//본코드 작성...
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3.결과행처리객체 얻어오기
			rs = pstmt.executeQuery(); 

			//처음~끝까지 반복해라
			while (rs.next()) { // next가 되면 sql 테이블안에 자료를 읽어온다.

				VisitVo vo = new VisitVo();
				//rs가 가리키는행의 필드값을 얻어온후 vo객체에 넣는다
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순 닫는다
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//idx에 해당되는 데이터 1건 얻어오기
	public VisitVo selectOne(int idx) { //뭘수정할질 알아야되니까 idx를 가져온거다. 
										//selectone은 primary키로 조회. 하나만가져와야하기때문 예를들어 ip가같으면 하나만 못가져오니 idx값을 가지고 와서 구분
		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit where idx =?"; // idx가 ? 인 데이터.
		
		try {
			//본코드 작성...
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//2-1.pstmt parameter 지정
			pstmt.setInt(1, idx);

			//3.결과행처리객체 얻어오기
			rs = pstmt.executeQuery();
			
			//
			if (rs.next()) { // if나 while이나 여기선 아무거나 써도 상관없다. 

				vo = new VisitVo();
				//rs가 가리키는행의 필드값을 얻어온후 vo객체에 넣는다
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순 닫는다
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	//추가	_insert_delete 템플릿
	public int insert(VisitVo vo) { // 아래 sql ?표시된 4가지인덱스를 Visitvo vo에 포장

		int res = 0; 

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//															   1   2   3   4   <= parameter index
		String sql = "insert into visit values(seq_visit_idx.nextVal , ? , ? , ? , ? , sysdate)";
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			
			//4.DB insert
			res = pstmt.executeUpdate(); //res 에는 처리된 행수가 들어감.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫는다
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return res;
	}
	
	//삭제
	public int delete(int idx) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from visit where idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index 채우기
			pstmt.setInt(1, idx);
			
			//4.DB delete
			res = pstmt.executeUpdate(); // idx가없으면 0이떨어지고 idx가 있으면 무조건 한개 이기때문에 0아니면1로 떨어진다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫는다
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return res;
	}
	
	//수정
	public int update(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//									  1           2       3      4                               5
		String sql = "update visit set name = ? , content=? , pwd=? , ip=? , regdate=sysdate where idx = ?";
										   // ?로 쓰는건 ' '가 필요가없다. 
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			
			pstmt.setInt(5, vo.getIdx());
			
			//4.DB update
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫는다
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	
}
