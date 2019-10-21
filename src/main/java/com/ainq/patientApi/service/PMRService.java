package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.PatientMemberRecord;

import java.util.List;

public interface PMRService {

    public List<PatientMemberRecord> findAll();

    public PatientMemberRecord findById(Integer id);

    public PatientMemberRecord savePatient(PatientMemberRecord patient);

    public Boolean deletePatientMemberRecordById(Integer id);

    public PatientMemberRecord updatePatientMemberRecordById(Integer id, PatientMemberRecord patient);

    public Boolean existsById(Integer id);

   List<PatientMemberRecord> findByPatientEnterpriseId(Integer id);


}
