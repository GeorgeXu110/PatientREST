package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Address;

import java.util.List;

public interface AddressService {

    public List<Address> findAll();

    public Address findById(Integer id);

    public Address saveAddress(Address address);

    public Boolean deleteAddressById(Integer id);

    public Address updateAddressById(Integer id, Address newAddress);

    public Boolean existsById(Integer id);


}
