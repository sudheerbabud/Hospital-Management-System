package com.hospital.DAO;

import java.util.List;

import com.hospital.model.AppModel;

public interface AppointmentInterface {

	public boolean InsertAppointment(AppModel am);
	public List<AppModel> SelectAppointments();
	public boolean DeleteAppointment(AppModel m);
}
