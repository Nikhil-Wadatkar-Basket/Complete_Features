package com.bs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table
@Data
public class Region {
@Id	
private Integer regionId;
private String regionName;
}
