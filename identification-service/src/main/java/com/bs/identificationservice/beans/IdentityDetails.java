package com.bs.identificationservice.beans;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdentityDetails {
    @Id
    private Integer verificationID;
    @Column
    private String verificationType;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "emp_id_col")
//    private Employee employee;

}
