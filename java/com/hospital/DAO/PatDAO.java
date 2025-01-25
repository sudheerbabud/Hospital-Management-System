package com.hospital.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.PatModel;
import com.hospital.utility.DBConnection;

public class PatDAO implements PatientInterface {

	public boolean InsertPatientDetails(PatModel m) {
		Connection con;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into patients(pid,pname,page,pgender) values(?,?,?,?)");
			ps.setInt(1, m.getPid());
			ps.setString(2, m.getPname());
			ps.setInt(3, m.getPage());
			ps.setString(4, m.getPgender());
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

	public List<PatModel> SelectPatientDetails(){
		List<PatModel> li = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM Patients");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PatModel ap = new PatModel();
				ap.setPid(rs.getInt("pid"));
				ap.setPname(rs.getString("pname"));
				ap.setPage(rs.getInt("page"));
				ap.setPgender(rs.getString("pgender"));
				li.add(ap);
				System.out.println(li);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return li;
	}
	
	public boolean DeletePatientDetails(PatModel m) {
		Connection con;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from patients where pid=?");
			ps.setInt(1, m.getPid());
			int a = ps.executeUpdate();
			if (a > 0) {
				System.out.println(a + "row's Deleted");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}
}
