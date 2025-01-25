package com.hospital.DAO;

import java.util.List;

import com.hospital.model.DocModel;

public interface DoctorInterface {

	public boolean InsertDoctorDetails(DocModel m);
	public List<DocModel> SelectDoctorsDetails();
	public boolean DeleteDoctorDetails(DocModel m);
}
