package com.project.bloodbanksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Bgroup;

@Repository
public interface BgroupRepository extends JpaRepository<Bgroup, Long> {

}
