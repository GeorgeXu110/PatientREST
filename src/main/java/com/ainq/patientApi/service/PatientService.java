package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Patient;

import java.util.List;

public interface PatientService {

    public List<Patient> findAll();

    public Patient findByEnterpriseId(Integer id);

    public Patient savePatient(Patient patient);

    public Boolean deletePatientById(Integer id);

    public Patient updatePatientById(Integer id, Patient patient);

    public Boolean existsById(Integer id);

}
