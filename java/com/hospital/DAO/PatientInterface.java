package com.hospital.DAO;

import java.util.List;

import com.hospital.model.PatModel;

public interface PatientInterface {
	public boolean InsertPatientDetails(PatModel m);
	public List<PatModel> SelectPatientDetails();
	public boolean DeletePatientDetails(PatModel m);
}
