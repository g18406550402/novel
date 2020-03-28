package com.briup.buke.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.buke.bean.Administrator;
import com.briup.buke.bean.Reader;

public interface AdministratorDao extends JpaRepository<Administrator, Integer> {
	@Query(value="select * from book_administrator c where c.username=?1",nativeQuery=true)
	public Administrator findByUsername(String username);
}
