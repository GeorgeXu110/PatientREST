package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Address;
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
public class AddressServiceTest {

    @Autowired
    private  AddressServiceImp addServiceImp;

//    public List<Address> findAll();
//
//    public Address findById(Integer id);
//
//    public Address saveAddress(Address address);
//
//    public Boolean deleteAddressById(Integer id);
//
//    public Address updateAddressById(Integer id, Address newAddress);
//
//    public Boolean existsById(Integer id);

    @Test
    public void findAllTest() throws Exception {

        log.info("");
        List<Address> addr = addServiceImp.findAll();
        System.out.println("Data size of Address Table is: " + addr.size());
        Assert.assertNotNull(addr);

    }


}
