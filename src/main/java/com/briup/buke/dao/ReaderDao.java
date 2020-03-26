package com.briup.buke.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.buke.bean.Reader;

public interface ReaderDao extends JpaRepository<Reader, Integer> {
	@Query(value="select * from book_reader c where c.username=?1",nativeQuery=true)
	public Reader findByUsername(String username);
}
