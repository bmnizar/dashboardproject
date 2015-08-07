package com.dashboard.model;

import javax.persistence.Entity;

@Entity
public class MoralPerson extends Person{
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


}
