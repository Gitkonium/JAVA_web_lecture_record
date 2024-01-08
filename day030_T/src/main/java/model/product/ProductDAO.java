package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class ProductDAO {
	
	private Connection conn; // DB와의 연결을 담당
	private PreparedStatement pstmt; // CRUD 수행을 담당

	private static final String SELECTALL="SELECT * FROM PRODUCT ORDER BY PID DESC";
	private static final String SELECTONE="SELECT * FROM PRODUCT WHERE PID=?";

	private static final String INSERT="";
	private static final String UPDATE="";
	private static final String DELETE="";
	
	public ArrayList<ProductDTO> selectAll(ProductDTO pDTO){
		ArrayList<ProductDTO> datas=new ArrayList<ProductDTO>();
		
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SELECTALL);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO data=new ProductDTO();
				data.setPid(rs.getInt("PID"));
				data.setName(rs.getString("NAME"));
				data.setPrice(rs.getInt("PRICE"));
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
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return data;
	}
	private boolean insert(ProductDTO pDTO) {
		return false;
	}
	private boolean update(ProductDTO pDTO) {
		return false;
	}
	private boolean delete(ProductDTO pDTO) {
		return false;
	}

}
