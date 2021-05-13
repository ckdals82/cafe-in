package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungTBDao {
	//single-ton pattern
	static SungTBDao single = null;

	public static SungTBDao getInsteance() {

		if (single == null)
			single = new SungTBDao();

		return single;

	}

	//private 생성자 : 외부에서 직접 생성하지 말아라
	private SungTBDao() {
		// TODO Auto-generated constructor stub

	}
	

	
	//전체조회
	public List<SungVo> selcetList(){
		
		List<SungVo> list = new ArrayList();
		
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet			rs  = null;
		String				sql = "select * from sungtb_view";
		
		try {
			//본코드 작성.(jdbc에 대한)
			//1.connection 얻어오기
			conn = DBService.getInsteance().getConnection();
			
			//2. 명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3. 결과행처리객체 얻어오기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SungVo vo = new SungVo();
				//rs가 가리키는 행의 필드값을 얻어온후 vo객체에 넣는다
				int no = rs.getInt("no");//DB에서 읽어온다
				vo.setNo(no);			 //읽어온값 Vo에 넣는다
				
				String name = rs.getString("name");
				vo.setName(name);
				
				vo.setKor(rs.getInt("kor"));// 이렇게 하는게 더 효과적 위에 보다
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getInt("rank"));
				
				
				list.add(vo);
			}
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				//열린역순 닫는다
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	//추가
	public int insert(SungVo vo) {
		
		int res = 0; //인서트 1 이나 0 이냐에 따라 성공실패유무 파악 인서트는 넣으면 무조건 1
		
		
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		
		//																 1   2   3  4 <= parameter index
		//															   name kor eng mat
		String sql = "insert into sungtb values(seq_sungtb_no.nextVal , ? , ? , ? ,?)";	
		
		try { 
			//1. Connection 얻어오기 (누가 얻어오냐 DBservice 가 얻어옴)
			conn = DBService.getInsteance().getConnection();
			//2. 명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3.pstmt parameter index 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			
			//4.DB insert
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			//열린역순으로 닫는다
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return res;
	}
	
	
	//삭제
public int delete(int no) {
		
		int res = 0; 
		
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		
		//											 1   <= parameter index
		String sql = "delete from sungtb where no = ?";	
		
		try { 
			//1. Connection 얻어오기 (누가 얻어오냐 DBservice 가 얻어옴)
			conn = DBService.getInsteance().getConnection();
			//2. 명령처리객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3.pstmt parameter index 채우기
			pstmt.setInt(1, no);
			
			
			//4.DB insert
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			//열린역순으로 닫는다
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return res;
	}
	
		//수정
public int update(SungVo vo) {
	
	int res = 0; //인서트 1 이나 0 이냐에 따라 성공실패유무 파악 인서트는 넣으면 무조건 1
	
	
	Connection 		  conn 	= null;
	PreparedStatement pstmt = null;
	
	//									   1      2     3     4            5<= parameter index
	//									 name    kor    eng   mat		  no
	String sql = "update sungtb set name= ?, kor=?, eng=?, mat=? where no = ?";	
	
	try { 
		//1. Connection 얻어오기 (누가 얻어오냐 DBservice 가 얻어옴)
		conn = DBService.getInsteance().getConnection();
		//2. 명령처리객체 얻어오기
		pstmt = conn.prepareStatement(sql);
		
		//3.pstmt parameter index 채우기
		pstmt.setString(1, vo.getName());
		pstmt.setInt(2, vo.getKor());
		pstmt.setInt(3, vo.getEng());
		pstmt.setInt(4, vo.getMat());
		pstmt.setInt(5, vo.getNo());
		
		//4.DB update
		res = pstmt.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		
		//열린역순으로 닫는다
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	return res;
}
}
