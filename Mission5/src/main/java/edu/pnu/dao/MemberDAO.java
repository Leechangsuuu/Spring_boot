package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberDTO;

@Repository
@Configuration
public class MemberDAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/musthave";
    private String id = "scott";
    private String pwd = "tiger";
    private Connection con;

    @Bean
    MemberDAO memberDAO() {
    	MemberDAO dao = new MemberDAO();
    	dao.setUrl("jdbc:mysql://localhost:3306/musthave");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (con != null) {
            	con.close();            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	@Autowired
	private MemberDTO memberDTO;
	
	public List<MemberDTO> getAllMembers() {
		List<MemberDTO>list = new ArrayList<>();
		String query = "select * from member";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				memberDTO.setId(rs.getInt("id"));
				memberDTO.setPass(rs.getString("pass"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setRegidate(rs.getDate("regidate"));
				list.add(memberDTO);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public MemberDTO getMemberById(Integer id) {
		String query = "select * from member where id=?";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				memberDTO.setId(rs.getInt("id"));
				memberDTO.setPass(rs.getString("pass"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setRegidate(rs.getDate("regidate"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memberDTO;
	}
	
	public MemberDTO addMember(MemberDTO dto) {
		String query = "insert into member (pass,name) "
				+ " value (?,?) ";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.executeUpdate();//쿼리 실행
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int updateMember(MemberDTO dto) {
		String query = "update member set"
				+ " pass = ? , name = ? "
				+ " where id = ? ";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getId());
			psmt.executeUpdate();//쿼리 실행
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public int removeMember(MemberDTO dto) {
		String query = "delete from member "
				+ " where id = ?"; 
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, dto.getId());
			psmt.executeUpdate();//쿼리 실행
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
