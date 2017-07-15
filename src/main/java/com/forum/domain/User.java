package com.forum.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonView;
import com.forum.configuration.constant.DatabaseConstant;
import com.forum.util.view.Private;
import com.forum.util.view.Public;

/**
 * @author NamDT8
 *
 */

@Entity
@Table(name = "user")
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "user_value_generator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_value_generator", schema = DatabaseConstant.schema, sequenceName = "users_seq")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "hash_password")
	private String hashPassword;
	@Column(name = "display_name")
	private String displayName;
	@OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
	fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Profile profile;

	
	public User() {
	}

	public User(Long id, String name, String hashPassword, String displayName) {
		this.id = id;
		this.name = name;
		this.hashPassword = hashPassword;
		this.displayName = displayName;
	}

	@JsonView(Private.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonView(Public.class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonView(Private.class)
	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	@JsonView(Public.class)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonView(Public.class)
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}