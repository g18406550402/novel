package com.briup.buke.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.buke.bean.Reader;

public interface ReaderDao extends JpaRepository<Reader, Integer> {
	
}
