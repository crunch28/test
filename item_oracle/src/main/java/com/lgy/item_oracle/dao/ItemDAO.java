package com.lgy.item_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.item_oracle.dto.ItemDTO;

public class ItemDAO {
	DataSource ds;
	Connection conn = null;
	
	public ItemDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 상품 정보 등록
	 */
	public void insert(ItemDTO itemDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into item(name, price, description) " +
				     " values(?, ?, ?) ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, itemDTO.getName());
			pstmt.setInt(2, itemDTO.getPrice());
			pstmt.setString(3, itemDTO.getDescription());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 상품의 목록 조회(type parameter : 게시글 객체)
	 * @return ArrayList<ItemDTO>
	 */
	public ArrayList<ItemDTO> list() {
		ArrayList<ItemDTO> dtos = new ArrayList<ItemDTO>();
		ItemDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select name, price, description " + 
					 " from item " + 
					 " order by name ";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ItemDTO();
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setDescription(rs.getString("description"));
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return dtos;
	}
}