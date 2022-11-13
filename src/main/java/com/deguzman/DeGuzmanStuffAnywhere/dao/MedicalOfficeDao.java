package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateOfficeException;
import com.deguzman.DeGuzmanStuffAnywhere.model.MedicalOffice;

public interface MedicalOfficeDao {

	public List<MedicalOffice> findAllMedicalOfficeInformation();

	public List<MedicalOffice> findMedicalOfficesByZip(@PathVariable String zip);

	public MedicalOffice findMedicalOfficeInformationById(@PathVariable long medicalOfficeId);

	public int getMedicalOfficeCount();

	public int addMedicalOfficeInformation(@RequestBody MedicalOffice medicalOffice) throws DuplicateOfficeException;

	public int updateMedicalOfficeInformation(@PathVariable long medicalOfficeId,
			@RequestBody MedicalOffice medicalOffice);

	public int deleteMedicalOfficeById(@PathVariable long medicalOfficeId);

	public int deleteAllMedicalOfficeInformation();

}
