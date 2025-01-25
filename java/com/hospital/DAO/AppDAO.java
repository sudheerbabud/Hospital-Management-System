package com.hospital.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.AppModel;
import com.hospital.utility.DBConnection;

public class AppDAO implements AppointmentInterface{
	public boolean InsertAppointment(AppModel ap) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into appointments(appointmentid,patientid,doctorid,appointmentdate) values(?,?,?,?)");
			ps.setInt(1, ap.getAid());
			ps.setInt(2, ap.getPid());
			ps.setInt(3, ap.getDid());
			ps.setString(4, ap.getAdate());
			int a = ps.executeUpdate();
			if (a > 0) {
				System.out.println(a + "rows inserted");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public List<AppModel> SelectAppointments() {
		List<AppModel> li = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from appointments");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AppModel a = new AppModel();
				a.setAid(rs.getInt("appointmentid"));
				a.setPid(rs.getInt("patientid"));
				a.setDid(rs.getInt("doctorid"));
				a.setAdate(rs.getString("appointmentdate"));
				li.add(a);
				System.out.println(li);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return li;
	}
	
	public boolean DeleteAppointment(AppModel ap) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"delete from appointments where appointmentid=?");
			ps.setInt(1, ap.getAid());
			int a = ps.executeUpdate();
			if (a > 0) {
				System.out.println(a + "row's is deleted");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
