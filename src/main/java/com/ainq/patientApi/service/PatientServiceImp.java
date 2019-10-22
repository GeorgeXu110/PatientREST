package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Patient;
import com.ainq.patientApi.log.Timed;
import com.ainq.patientApi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImp implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findByEnterpriseId(Integer id) {
        return patientRepository.findByEnterpriseId(id);
    }

    @Override
    @Transactional
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    @Timed
    public Boolean deletePatientById(Integer id) {
        if(patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            patientRepository.flush();
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    @Timed
    public Patient updatePatientById(Integer id, Patient newPatient) {
        Patient patient = findByEnterpriseId(id);
        patient.setEnterpriseName(newPatient.getEnterpriseName());
        patientRepository.saveAndFlush(patient);
        return patient;
    }

    @Override
    @Timed
    public Boolean existsById(Integer id) {
        return patientRepository.existsById(id);
    }
}
