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

	// private������ : �ܺο��� ������������(new) ���ƶ�
	private VisitDao() {
		// TODO Auto-generated constructor stub
	}
	
	//��ü��ȸ _select_list
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit order by idx desc";

		try {
			//��ȸ������ �ڵ�...
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.���ó����ü ������
			pstmt = conn.prepareStatement(sql);

			//3.�����ó����ü ������
			rs = pstmt.executeQuery();

			//ó��~������ �ݺ��ض�
			while (rs.next()) {

				VisitVo vo = new VisitVo();
				//rs�� ����Ű������ �ʵ尪�� ������ vo��ü�� �ִ´�
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
				//�������� �ݴ´�
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
	
	// idx�� �ش�Ǵ� ������ 1�� ������ _select_one
	public VisitVo selectOne(int idx) {	//VisitVo��ü�� ���� ���� �Ŀ�

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//											1 <= parameter index(1base)
		String sql = "select * from visit where idx=?";

		try {
			//���ڵ� �ۼ�...
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.���ó����ü ������
			pstmt = conn.prepareStatement(sql);

			//2-1.pstmt parameter ����
			pstmt.setInt(1, idx);
			
			//3.�����ó����ü ������
			rs = pstmt.executeQuery();

			//
			if (rs.next()) {
				
				vo = new VisitVo();
				
				//rs�� ����Ű������ �ʵ尪�� ������ vo��ü�� �ִ´�
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
				//�������� �ݴ´�
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
	
	// �߰�	_insert_update_delete
	public int insert(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		//															   1   2   3   4	<= parameter index
		String sql = "insert into visit values(seq_visit_idx.nextVal , ? , ? , ? , ? , sysdate)";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.���ó����ü ������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index ä���
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			//4.DB insert
			res = pstmt.executeUpdate();	// res : ó���� ���

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݴ´�
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
	
	//����
	public int delete(int idx) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from visit where idx=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.���ó����ü ������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index ä���
			pstmt.setInt(1, idx);
			
			//4.DB delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݴ´�
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
	
	//���� _insert_delete_update
	public int update(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		//									1			2		3	   4							 5 <= parameter index
		String sql = "update visit set name=? , content=? , pwd=? , ip=? , regdate=sysdate where idx=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.���ó����ü ������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index ä���
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(   5, vo.getIdx());

			//4.DB insert
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݴ´�
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
