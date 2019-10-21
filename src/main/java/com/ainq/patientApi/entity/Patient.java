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
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
@JsonDeserialize
@ApiModel(description = "All details about the Patient. ")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enterpriseid")
    @ApiModelProperty(notes = "The database generated enterpriseId")
    private Integer enterpriseId;

    @Column(name = "enterprisename")
    @ApiModelProperty(notes = "Enterprise Name")
    private String enterpriseName;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "patient",cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<PatientMemberRecord> pmrs;



}
