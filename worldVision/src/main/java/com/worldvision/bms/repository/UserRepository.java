package com.worldvision.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldvision.bms.user.model.User;

// CRUD 함수를 JpaRepository가 들고 있음. 
// @Repositoey라는 어노테이션이 없어도 IoC 됨. 이유는 JpaRepository를 상속했기 때문
public interface UserRepository extends JpaRepository<User, Integer>{

	// findBy 규칙 => Username 문법
	// select * from user where username = ?
	public User findByAccount(String account); // JPA name 함수 
	
}
