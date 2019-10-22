package com.ainq.patientApi.controller;

import com.ainq.patientApi.entity.PatientMemberRecord;
import com.ainq.patientApi.log.Timed;
import com.ainq.patientApi.service.PMRServiceImp;
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
@Api(value="PatientMemberRecord Resource Management", tags = "PatientMemberRecord Resource Related")
public class PatientMemberRecordController {

    @Autowired
    PMRServiceImp pmrServiceImp;

    @ApiOperation(value = "Get all PatientMemberRecord entities", response = ResponseEntity.class)
    @GetMapping(value = "/PatientMemberRecords")
    @Timed
    public ResponseEntity getAllPatientMemberRecords() {

        List<PatientMemberRecord> patients = pmrServiceImp.findAll();
        log.info("Get All PatientMemberRecords");
        if(patients == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found");
        } else
            return ResponseEntity.ok(patients);
    }

    @ApiOperation(value = "Get a PatientMemberRecord entity by Id", response = ResponseEntity.class)
    @GetMapping(value = "/PatientMemberRecords/{id}")
    @Timed
    public ResponseEntity getPatientMemberRecordsById(@PathVariable Integer id) {
        PatientMemberRecord pmr = pmrServiceImp.findById(id);
        log.info("Get Patients with id:" + id, pmr);
        if(pmr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record with id: " + id + "not found");
        } else {
            return ResponseEntity.ok(pmr);
        }
    }

    @ApiOperation(value = "Save a PatientMemberRecord to DB", response = ResponseEntity.class)
    @PostMapping( value = "/PatientMemberRecords", consumes = "application/json")
    @Timed
    public ResponseEntity createOrSavePatientMemberRecord(@RequestBody PatientMemberRecord pmr) {

        log.info("Save PatientMemberRecords",pmr);
        Integer id = pmr.getId();
        if(id != null && pmrServiceImp.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Record Id:" + id + " exists");
        } else {
            PatientMemberRecord newPMR = pmrServiceImp.savePatient(pmr);
            return ResponseEntity.ok(newPMR);
        }

    }

    @ApiOperation(value = "Delete a PatientMemberRecord entity by Id", response = ResponseEntity.class)
    @DeleteMapping( value = "/PatientMemberRecords/{id}")
    @Timed
    public ResponseEntity deletePatientMemberRecordById(@PathVariable Integer id) {

        log.info("Delete PatientMemberRecords By Id: ",id);
        if(pmrServiceImp.deletePatientMemberRecordById(id)) {
            return ResponseEntity.ok("Record Id :" + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record Id doesn't exist");
        }
    }

    @ApiOperation(value = "Update given PatientMemberRecord entity", response = ResponseEntity.class)
    @PutMapping( value = "/PatientMemberRecords/{id}", consumes = "application/json")
    @Timed
    public ResponseEntity updatePatientById(@PathVariable Integer id, @RequestBody PatientMemberRecord newPMR) {

        log.info("Update PatientMemberRecordB By Id：",id);
        if(pmrServiceImp.existsById(id)) {
            PatientMemberRecord updatedPatientMemberRecord= pmrServiceImp.updatePatientMemberRecordById(id, newPMR);
            return ResponseEntity.ok(updatedPatientMemberRecord);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No matching id found: " + id);
        }
    }



}
