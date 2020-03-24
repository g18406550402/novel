package com.briup.buke.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.buke.bean.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {

}
