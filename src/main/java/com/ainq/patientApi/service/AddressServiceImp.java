package com.ainq.patientApi.service;

import com.ainq.patientApi.entity.Address;
import com.ainq.patientApi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {

        return addressRepository.findAll();
    }

    @Override
    public Address findById(Integer id) {
        return addressRepository.findOneByAddressId(id);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public Boolean deleteAddressById(Integer id) {
        if(addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Address updateAddressById(Integer id, Address newAddress){
        Address address = findById(id);
        address.setAddressLine1(newAddress.getAddressLine1());
        address.setAddressLine2(newAddress.getAddressLine2());
        address.setCity(newAddress.getCity());
        address.setState(newAddress.getCity());
        address.setZipCode(newAddress.getZipCode());
        address.setPmr(newAddress.getPmr());
        addressRepository.saveAndFlush(address);
        return address;
    }

    @Override
    public Boolean existsById(Integer id) {
       return addressRepository.existsById(id);
    }
}
