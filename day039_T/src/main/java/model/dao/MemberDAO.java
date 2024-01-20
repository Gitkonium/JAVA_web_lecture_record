package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.MemberDTO;
import model.util.JDBCUtil;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private static final String SELECTALL="SELECT * FROM MEMBER";
	private static final String SELECTONE="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	private static final String SELECTONE_CHECK="SELECT * FROM MEMBER WHERE MID=?";

	private static final String INSERT="INSERT INTO MEMBER VALUES(?,?,?)";
	private static final String UPDATE="UPDATE MEMBER SET NAME=? WHERE MID=?";
	private static final String DELETE="DELETE FROM MEMBER WHERE MID=?";

	public ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		ArrayList<MemberDTO> datas=new ArrayList<MemberDTO>();

		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTALL);

			ResultSet rs=pstmt.executeQuery();

			while(rs.next()) {
				MemberDTO data=new MemberDTO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
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
	public MemberDTO selectOne(MemberDTO mDTO) {
		MemberDTO data=null;

		conn=JDBCUtil.connect();
		try {
			if(mDTO.getSearchCondition().equals("로그인")) {
				pstmt=conn.prepareStatement(SELECTONE);
				pstmt.setString(1, mDTO.getMid());
				pstmt.setString(2, mDTO.getMpw());
			}
			else {
				pstmt=conn.prepareStatement(SELECTONE_CHECK);
				pstmt.setString(1, mDTO.getMid());
			}

			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new MemberDTO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
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

	public boolean insert(MemberDTO mDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(INSERT);
			pstmt.setString(1, mDTO.getMid());
			pstmt.setString(2, mDTO.getMpw());
			pstmt.setString(3, mDTO.getName());
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
	public boolean update(MemberDTO mDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, mDTO.getName());
			pstmt.setString(2, mDTO.getMid());
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
	public boolean delete(MemberDTO mDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setString(1, mDTO.getMid());
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
