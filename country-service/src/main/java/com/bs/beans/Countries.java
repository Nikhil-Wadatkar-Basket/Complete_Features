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
public class Countries {
	@Id
	private String countryId;
	private String countryName;
	private Integer regionId;
}
