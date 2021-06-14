package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {

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
	}
	
	//전체목록 보기
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member order by m_idx";

		try {
			//본코드 작성...
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.결과행처리객체 얻어오기
			rs = pstmt.executeQuery();

			//처음~끝까지 반복해라
			while (rs.next()) {

				MemberVo vo = new MemberVo();
				//rs가 가리키는행의 필드값을 얻어온후 vo객체에 넣는다
				vo.setM_idx(rs.getInt("m_idx"));
				
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_modifydate(rs.getString("m_modifydate"));
				vo.setM_grade(rs.getString("m_grade"));
				
				
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
	
	//m_idx에 해당되는 회원정보 1건
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where m_idx=?";

		try {
			//본코드 작성...
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//2-1.pstmt parameter 지정
			pstmt.setInt(1, m_idx);
			//3.결과행처리객체 얻어오기
			rs = pstmt.executeQuery();

			//
			if (rs.next()) {

				vo = new MemberVo();
				//rs가 가리키는행의 필드값을 얻어온후 vo객체에 넣는다
				vo.setM_idx(rs.getInt("m_idx"));
				
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcod"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_modifydate(rs.getString("m_modifydate"));
				vo.setM_grade(rs.getString("m_grade"));
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
	//m_id에 해당되는 회원정보 1건 얻어오기
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where m_id=?";

		try {
			//본코드 작성...
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//2-1.pstmt parameter 지정
			pstmt.setString(1, m_id);
			//3.결과행처리객체 얻어오기
			rs = pstmt.executeQuery();

			//
			if (rs.next()) {

				vo = new MemberVo();
				//rs가 가리키는행의 필드값을 얻어온후 vo객체에 넣는다
				vo.setM_idx(rs.getInt("m_idx"));
				
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcod"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_modifydate(rs.getString("m_modifydate"));
				vo.setM_grade(rs.getString("m_grade"));
				
				
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
	//추가 
	public int insert(MemberVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		//																 1 2 3 4 5 6 < = parameter index
		String sql = "insert into member values(seq_member_m_idx.nextVal,?,?,?,?,?,?,sysdate,sysdate,default)";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index 채우기
			pstmt.setString(1, vo.getM_name());
			pstmt.setString(2, vo.getM_id());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_ip());
			//4.DB insert
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
