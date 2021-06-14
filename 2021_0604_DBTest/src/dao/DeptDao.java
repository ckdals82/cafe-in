package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBservice;
import vo.DeptVo;

public class DeptDao {
	
	//single-ton pattern
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();
		return single;
	}

	// private생성자 : 외부에서 직접생성하지 말아라
	private DeptDao() {
		// TODO Auto-generated constructor stub
	}
	
	//전체조회
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from dept";

		try {
			//본코드 작성...
			//1.Connection 얻어오기
			conn = DBservice.getInstance().getConnection();

			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.결과행처리객체 얻어오기
			rs = pstmt.executeQuery();

			//처음~끝까지 반복해라
			while (rs.next()) {

				DeptVo vo = new DeptVo();
				//rs가 가리키는행의 필드값을 얻어온후 vo객체에 넣는다
				vo.setDeptno(rs.getInt("deptno")); 
	            vo.setDname(rs.getString("dname"));
	            vo.setLoc(rs.getString("loc"));
				//getNString 쓰면 안된다. 가운데 에
				
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
	
}
