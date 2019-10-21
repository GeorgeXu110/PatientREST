package com.ainq.patientApi.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
@JsonDeserialize
@ApiModel(description = "All details about the Address. ")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressid")
    @ApiModelProperty(notes = "The database generated addressID")
    private Integer addressId;

    @Column(name = "addressline1")
    @ApiModelProperty(notes = "Addressline 1")
    private String addressLine1;

    @Column(name = "addressline2")
    @ApiModelProperty(notes = "Addressline 2")
    private String addressLine2;

    @Column(name = "city")
    @ApiModelProperty(notes = "City")
    private String city;

    @Column(name = "state")
    @ApiModelProperty(notes = "State")
    private String state;

    @Column(name = "zipcode")
    @ApiModelProperty(notes = "ZipCode")
    private String zipCode;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private PatientMemberRecord pmr;

//    public Address(Integer addressId) {
//        this.addressId = addressId;
//    }
//
//    public Address(String addressLine1, String addressLine2, String city, String state, String zipCode) {
//        this.addressLine1 = addressLine1;
//        this.addressLine2 = addressLine2;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//    }
}
