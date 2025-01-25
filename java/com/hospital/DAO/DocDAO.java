package com.hospital.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.DocModel;
import com.hospital.utility.DBConnection;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/DeleteDoctor")
public class DocDAO implements DoctorInterface {

	public boolean InsertDoctorDetails(DocModel d) {
		Connection con;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into doctors(did,dname,dspecialization,dgender) values(?,?,?,?)");
			ps.setInt(1, d.getDid());
			ps.setString(2, d.getDname());
			ps.setString(3,d.getDspecialization());
			ps.setString(4,d.getDgender());
			int a = ps.executeUpdate();
			if (a > 0) {
				System.out.println(a + "row's inserted");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public List<DocModel> SelectDoctorsDetails(){
		List<DocModel> li = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM doctors");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DocModel dm = new DocModel();
				dm.setDid(rs.getInt("did"));
				dm.setDname(rs.getString("dname"));
				dm.setDspecialization(rs.getString("dspecialization"));
				dm.setDgender(rs.getString("dgender"));
				li.add(dm);
				System.out.println(li);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return li;
	}
	
	public boolean DeleteDoctorDetails(DocModel d) {
		Connection con;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from doctors where did=?");
			ps.setInt(1, d.getDid());
			int a = ps.executeUpdate();
			if (a > 0) {
				System.out.println(a + "row's deleted");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}
}
