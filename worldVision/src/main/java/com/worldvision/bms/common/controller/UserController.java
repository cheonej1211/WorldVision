package com.worldvision.bms.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldvision.bms.repository.UserRepository;
import com.worldvision.bms.user.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({ "", "/" })
	public @ResponseBody String index() {
		return "인덱스 페이지입니다.";
	}

	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String loginProc() {
		return "redirect:/";
	}

	@GetMapping("/userCreate")
	public String join() {
		return "/user/userCreate";
	}

	@PostMapping("/userCreate")
	public String userCreate(User user) {
		String rawPassword = user.getPassword(); //유저가 입력한 비밀번호를 받아와서 
		String encPassword = bCryptPasswordEncoder.encode(rawPassword); // 암호화를 시켜준다. 
		user.setPassword(encPassword);
		userRepository.save(user);
		return "redirect:/login";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/info")
	public @ResponseBody String info() {
		return "개인 정보";
	}
	
	
	@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
	@GetMapping("/data")
	public @ResponseBody String data() {
		return "데이터 정보";
	}

}
