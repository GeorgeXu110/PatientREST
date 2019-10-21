package com.ainq.patientApi.repository;

import com.ainq.patientApi.entity.PatientMemberRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PatientMemberRecordRepository extends JpaRepository<PatientMemberRecord, Integer> {

    PatientMemberRecord findOneById(Integer id);
    boolean existsById(Integer id);
    List<PatientMemberRecord> findByPatientEnterpriseId(Integer id);
}
