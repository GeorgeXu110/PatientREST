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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patientmemberrecord")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
@JsonDeserialize
@ApiModel(description = "All details about the PatientMemberRecord. ")
public class PatientMemberRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Id")
    private Integer id;

    @Column(name = "source")
    @ApiModelProperty(notes = "Source")
    private String source;

    @Column(name = "medicalrecordnumber")
    @ApiModelProperty(notes = "Medical record number")
    private String medicalRecordNumber;

    @Column(name = "firstname")
    @ApiModelProperty(notes = "First Name")
    private String firstName;

    @Column(name = "lastname")
    @ApiModelProperty(notes = "Last Name")
    private String lastName;

    @Column(name = "socialsecuritynumber")
    @ApiModelProperty(notes = "SSN")
    private String socialSecurityNumber;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="pmr_patient_id", referencedColumnName = "enterpriseid")
    @JsonBackReference
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pmr_address_id", referencedColumnName = "addressid")
    @JsonManagedReference
    private Address address;

}
