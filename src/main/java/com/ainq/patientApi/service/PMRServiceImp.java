package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.PatientMemberRecord;
import com.ainq.patientApi.log.Timed;
import com.ainq.patientApi.repository.AddressRepository;
import com.ainq.patientApi.repository.PatientMemberRecordRepository;
import com.ainq.patientApi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PMRServiceImp implements PMRService{

    @Autowired
    PatientMemberRecordRepository pmrRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Timed
    public List<PatientMemberRecord> findAll() {
        return pmrRepository.findAll();
    }

    @Override
    @Timed
    public PatientMemberRecord findById(Integer id) {
        return pmrRepository.findOneById(id);
    }

    @Override
    @Transactional
    public PatientMemberRecord savePatient(PatientMemberRecord patient) {
        return pmrRepository.save(patient);
    }

    @Override
    @Transactional
    @Timed
    public Boolean deletePatientMemberRecordById(Integer id) {
        if(pmrRepository.existsById(id)) {
            pmrRepository.deleteById(id);
            pmrRepository.flush();
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    @Timed
    public PatientMemberRecord updatePatientMemberRecordById(Integer id, PatientMemberRecord newPMR) {
        PatientMemberRecord pmr = findById(id);
        pmr.setSource(newPMR.getSource());
        pmr.setFirstName(newPMR.getFirstName());
        pmr.setLastName(newPMR.getLastName());
        pmr.setMedicalRecordNumber(newPMR.getMedicalRecordNumber());
        pmr.setSocialSecurityNumber(newPMR.getSocialSecurityNumber());

        if(newPMR.getPatient()!= null && patientRepository.existsById(newPMR.getPatient().getEnterpriseId())) {
            pmr.setPatient(patientRepository.findByEnterpriseId(newPMR.getPatient().getEnterpriseId()));
        } else
            pmr.setPatient(null);

        if(newPMR.getAddress()!= null && addressRepository.existsById(newPMR.getAddress().getAddressId())) {
            pmr.setAddress(addressRepository.findOneByAddressId(newPMR.getAddress().getAddressId()));
        } else
            pmr.setAddress(null);

        pmrRepository.saveAndFlush(pmr);
        return pmr;
    }

    @Override
    @Timed
    public Boolean existsById(Integer id) {
        return pmrRepository.existsById(id);
    }

    @Override
    @Timed
    public List<PatientMemberRecord> findByPatientEnterpriseId(Integer id){
        return pmrRepository.findByPatientEnterpriseId(id);
    }
}
