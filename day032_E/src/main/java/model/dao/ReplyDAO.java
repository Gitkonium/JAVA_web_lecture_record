package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.MemberDTO;
import model.dto.ReplyDTO;
import model.util.JDBCUtil;

public class ReplyDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private static final String SELECTALL="SELECT * FROM REPLY ORDER BY RID DESC";
	private static final String SELECTONE="SELECT * FROM REPLY WHERE RID=?";

	private static final String INSERT="INSERT INTO REPLY VALUES((SELECT NVL(MAX(RID),0)+1 FROM REPLY),?,?)";
	private static final String UPDATE="UPDATE REPLY SET CONTENT=? WHERE RID=?";
	private static final String DELETE="DELETE FROM REPLY WHERE RID=?";
	
	public ArrayList<ReplyDTO> selectAll(ReplyDTO rDTO) {
		ArrayList<ReplyDTO> datas=new ArrayList<ReplyDTO>();

		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTALL);

			ResultSet rs=pstmt.executeQuery();

			while(rs.next()) {
				ReplyDTO data=new ReplyDTO();
				data.setRid(rs.getInt("RID"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
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
	public ReplyDTO selectOne(ReplyDTO rDTO) {
		ReplyDTO data=null;

		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTONE);
			pstmt.setInt(1, rDTO.getRid());

			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new ReplyDTO();
				data.setRid(rs.getInt("RID"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}

		return data;
	}
	
	public boolean insert(ReplyDTO rDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(INSERT);
			pstmt.setString(1, rDTO.getWriter());
			pstmt.setString(2, rDTO.getContent());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
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
	public boolean update(ReplyDTO rDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, rDTO.getContent());
			pstmt.setInt(2, rDTO.getRid());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
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
	public boolean delete(ReplyDTO rDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, rDTO.getRid());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
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
