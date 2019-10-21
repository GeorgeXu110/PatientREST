package com.ainq.patientApi.controller;

import com.ainq.patientApi.entity.Patient;
import com.ainq.patientApi.entity.PatientMemberRecord;
import com.ainq.patientApi.service.PMRServiceImp;
import com.ainq.patientApi.service.PatientServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(value="Patient Resource Management", tags = "Patient Resource Related")
public class PatientController {

    @Autowired
    PatientServiceImp patientServiceImp;

    @Autowired
    PMRServiceImp pmrServiceImp;

    @ApiOperation(value = "Get all Patient entities", response = ResponseEntity.class)
    @GetMapping(value = "/Patients")
    public ResponseEntity getAllPatients() {

        List<Patient> patients = patientServiceImp.findAll();
        log.info("Get All Patients");
        if(patients == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(patients);
        }
    }

    @ApiOperation(value = "Get a Patient entity by Id", response = ResponseEntity.class)
    @GetMapping(value = "/Patients/{id}")
    public ResponseEntity getPatientById(@PathVariable Integer id) {
        Patient patient = patientServiceImp.findByEnterpriseId(id);
        log.info("Get Patients with id:" + id, patient);
        if(patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(patient);
        }
    }

    @ApiOperation(value = "Save a Patient entity to DB", response = ResponseEntity.class)
    @PostMapping( value = "/Patients", consumes = "application/json")
    public ResponseEntity createOrSavePatient(@RequestBody Patient patient) {

        log.info("Save Patient",patient);
        Patient newPatient = patientServiceImp.savePatient(patient);
        if(newPatient != null) {
            return ResponseEntity.ok(newPatient);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ApiOperation(value = "Delete a Patient entity by Id", response = ResponseEntity.class)
    @DeleteMapping( value = "/Patients/{id}")
    public ResponseEntity deletePatientById(@PathVariable Integer id) {

        log.info("Delete Patient By Id: ",id);
        if(patientServiceImp.deletePatientById(id)) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @ApiOperation(value = "Update given Patient entity", response = ResponseEntity.class)
    @PutMapping( value = "/Patients/{id}")
    public ResponseEntity updatePatientById(@PathVariable Integer id, @RequestBody Patient patient) {

        log.info("Update Patient By Id：",id);
        if(patientServiceImp.existsById(id)) {
            Patient updatedPatient = patientServiceImp.updatePatientById(id, patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @ApiOperation(value = "Get all PatientMemberRecord entities with given Patient ID", response = ResponseEntity.class)
    @GetMapping(value = "/Patients/{PatientId}/PatientMemberRecords")
    public ResponseEntity getAllPatientMemberRecordsByPatientId(@PathVariable Integer PatientId) {

        List<PatientMemberRecord> pmrs = pmrServiceImp.findByPatientEnterpriseId(PatientId);
        log.info("Get PatientMemberRecords by PatientId:" + PatientId, pmrs);

        if(pmrs == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(pmrs);
        }
    }

}
