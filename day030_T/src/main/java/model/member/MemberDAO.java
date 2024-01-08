package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	private static final String SELECTALL="";
	private static final String SELECTONE="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	private static final String SELECTONE_ID_CHECK="SELECT * FROM MEMBER WHERE MID=?";

	private static final String INSERT="INSERT INTO MEMBER VALUES(?,?)";
	private static final String UPDATE="";
	private static final String DELETE="";

	private ArrayList<MemberDTO> selectAll(MemberDTO mDTO){
		return null;
	}
	public MemberDTO selectOne(MemberDTO mDTO){
		MemberDTO data=null;

		conn=JDBCUtil.connect();
		try {
			if(mDTO.getSearchCondition().equals("login")) {
				pstmt=conn.prepareStatement(SELECTONE);
				pstmt.setString(1, mDTO.getMid());
				pstmt.setString(2, mDTO.getMpw());
			}
			else {
				pstmt=conn.prepareStatement(SELECTONE_ID_CHECK);
				pstmt.setString(1, mDTO.getMid());
			}
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new MemberDTO();
				data.setMid(rs.getString("MID"));
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
	private boolean update(MemberDTO mDTO) {
		return false;
	}
	private boolean delete(MemberDTO mDTO) {
		return false;
	}

}
