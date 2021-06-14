package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBservice;
import vo.SawonVo;

public class SawonDao {
	
	//single-ton pattern
	static SawonDao single = null;

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();
		return single;
	}

	// private������ : �ܺο��� ������������ ���ƶ�
	private SawonDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SawonVo> selectList() {

		List<SawonVo> list = new ArrayList<SawonVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon";

		try {
			//���ڵ� �ۼ�...
			//1.Connection ������
			conn = DBservice.getInstance().getConnection();

			//2.����ó����ü ������
			pstmt = conn.prepareStatement(sql);

			//3.�����ó����ü ������
			rs = pstmt.executeQuery();

			//ó��~������ �ݺ��ض�
			while (rs.next()) {

				SawonVo vo = new SawonVo();
				//rs�� ����Ű������ �ʵ尪�� ������ vo��ü�� �ִ´�
				
				vo.setSabun(rs.getInt("sabun"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				
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
	
	
}
