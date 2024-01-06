package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	
	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL="SELECT *\r\n"
			+ "	FROM BOARD\r\n"
			+ "	INNER JOIN MEMBER ON BOARD.WRITER=MEMBER.MID ORDER BY BID DESC";
	private static final String SELECTONE="SELECT *\r\n"
			+ "	FROM BOARD\r\n"
			+ "	INNER JOIN MEMBER ON BOARD.WRITER=MEMBER.MID WHERE BID=?";

	private static final String INSERT="INSERT INTO BOARD (BID,TITLE,WRITER,CONTENT) VALUES((SELECT NVL(MAX(BID),10) + 1 FROM BOARD),?,?,?)";
	private static final String UPDATE="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
	private static final String DELETE="DELETE FROM BOARD WHERE BID=?";
	
	public ArrayList<BoardDTO> selectAll(BoardDTO bDTO){
		ArrayList<BoardDTO> datas=new ArrayList<BoardDTO>();
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTALL);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO data=new BoardDTO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setRegdate(rs.getDate("REGDATE"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setName(rs.getString("NAME"));
				datas.add(data);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return datas;
	}
	public BoardDTO selectOne(BoardDTO bDTO){
		BoardDTO data=null;
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTONE);
			pstmt.setInt(1, bDTO.getBid());
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				data=new BoardDTO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setRegdate(rs.getDate("REGDATE"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setName(rs.getString("NAME"));
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return data;
	}
	public boolean insert(BoardDTO bDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(INSERT);
			pstmt.setString(1, bDTO.getTitle());
			pstmt.setString(2, bDTO.getWriter());
			pstmt.setString(3, bDTO.getContent());
			int result=pstmt.executeUpdate();
			if(result<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update(BoardDTO bDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, bDTO.getTitle());
			pstmt.setString(2, bDTO.getContent());
			pstmt.setInt(3, bDTO.getBid());
			int result=pstmt.executeUpdate();
			if(result<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete(BoardDTO bDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, bDTO.getBid());
			int result=pstmt.executeUpdate();
			if(result<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

}
