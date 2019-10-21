package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Address;
import com.ainq.patientApi.entity.PatientMemberRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
@ContextConfiguration
public class PMRServiceTest {

    @Autowired
    PMRServiceImp pmrServiceImp;

    @Test
    public void findAllTest() throws Exception {

        log.info("");
        List<PatientMemberRecord> pmrs = pmrServiceImp.findAll();
        System.out.println("Data size of PatientMemberRecord Table is: " + pmrs.size());
        Assert.assertNotNull(pmrs);

    }
}
