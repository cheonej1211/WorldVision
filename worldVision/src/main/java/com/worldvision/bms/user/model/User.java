package com.worldvision.bms.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity(name = "wv_users")
@Table(name ="")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	 
	@Column(unique = true)
	private String account;
    private String name;
    private String password;
    private String email;
    private String is_use;
    @CreationTimestamp
    private Timestamp createDt;
    @CreationTimestamp
    private Timestamp updateDt;
	
}
