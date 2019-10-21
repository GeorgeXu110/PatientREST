package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Address;
import com.ainq.patientApi.repository.AddressRepository;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
@ContextConfiguration
public class AddressServiceTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void saveTest() throws Exception {

//        Address add1 = new Address("11550 Old", "1234", "56789", "910", "93");
//        addressRepository.save(add1);
        Address addr = addressRepository.findById(1).get();
        System.out.println(addr.getZipCode());



    }

    @Test
    public void test2() throws Exception {

        System.out.println("pass 2");
    }



}
