package com.briup.buke.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.buke.bean.Administrator;

public interface AdministratorDao extends JpaRepository<Administrator, Integer> {

}
