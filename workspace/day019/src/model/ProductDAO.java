package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL="SELECT * FROM PRODUCT";
	private static final String SELECTALL_NAME="SELECT * FROM PRODUCT WHERE NAME LIKE '%'||?||'%'";
	private static final String SELECTONE="SELECT * FROM PRODUCT WHERE PID=?";

	private static final String INSERT="INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),1000) + 1 FROM PRODUCT),?,?,?)";
	private static final String UPDATE="UPDATE PRODUCT SET CNT=CNT-1 WHERE PID=?";
	private static final String DELETE="DELETE FROM PRODUCT WHERE PID=?";

	public ArrayList<ProductDTO> selectAll(ProductDTO pDTO){
		ArrayList<ProductDTO> datas=new ArrayList<ProductDTO>();

		conn=JDBCUtil.connect();
		try {
			// 3. pstmt 로 CRUD 수행
			if(pDTO.getSearchCondition().equals("전체")) {
				pstmt=conn.prepareStatement(SELECTALL);
			}
			else { // 이름
				pstmt=conn.prepareStatement(SELECTALL_NAME);
				pstmt.setString(1, pDTO.getName());
			}
			ResultSet rs=pstmt.executeQuery();

			while(rs.next()) {
				ProductDTO data=new ProductDTO();
				data.setPid(rs.getInt("PID"));
				data.setName(rs.getString("NAME"));
				data.setPrice(rs.getInt("PRICE"));
				data.setCnt(rs.getInt("CNT"));
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
	public ProductDTO selectOne(ProductDTO pDTO){
		ProductDTO data=null;

		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTONE);
			pstmt.setInt(1, pDTO.getPid());
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new ProductDTO();
				data.setPid(rs.getInt("PID"));
				data.setName(rs.getString("NAME"));
				data.setPrice(rs.getInt("PRICE"));
				data.setCnt(rs.getInt("CNT"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		

		return data;
	}
	public boolean insert(ProductDTO pDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(INSERT);
			pstmt.setString(1, pDTO.getName());
			pstmt.setInt(2, pDTO.getPrice());
			pstmt.setInt(3, pDTO.getCnt());
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
	public boolean update(ProductDTO pDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setInt(1, pDTO.getPid());
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
	public boolean delete(ProductDTO pDTO) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, pDTO.getPid());
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
