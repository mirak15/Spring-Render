package com.esposto.UserRegister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esposto.UserRegister.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	
	public AppUser findUserByEmail(String email);

}
