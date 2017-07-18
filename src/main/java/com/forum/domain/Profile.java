/**
 * 
 */
package com.forum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.forum.configuration.constant.DatabaseConstant;
import com.forum.util.view.Private;
import com.forum.util.view.Public;

/**
 * @author NamDT8
 *
 */
@Entity
@Table(name = "profile")
public class Profile extends AbstractEntity {
	private static final long serialVersionUID = 1L;	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "profile_value_generator",
    strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "profile_value_generator", schema = DatabaseConstant.schema,
	sequenceName = "profile_seq")
	private String id;
	
@Column(name = "email")
private String email;

@Column(name = "phone")
private String phone;

@Column(name = "address")
private String address;

@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private User user;

public Profile() {
}


public Profile(String id, String email, String phone, String address) {
	super();
	this.id = id;
	this.email = email;
	this.phone = phone;
	this.address = address;
}


@JsonView(Private.class)
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

@JsonView(Public.class)
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@JsonView(Public.class)
public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

@JsonView(Public.class)
public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

}