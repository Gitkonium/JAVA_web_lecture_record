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

	private static final String INSERT="";
	private static final String UPDATE="";
	private static final String DELETE="";
	
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
		return false;
	}
	public boolean update(ReplyDTO rDTO) {
		return false;
	}
	public boolean delete(ReplyDTO rDTO) {
		return false;
	}
}
