package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Locations {
	@Id
	private Integer locationId;
	private String streetAddress;
	private Integer postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
}
