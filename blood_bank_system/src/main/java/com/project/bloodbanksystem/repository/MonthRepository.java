package com.project.bloodbanksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Month;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {

}
