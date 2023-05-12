package com.project.bloodbanksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Saluation;

@Repository
public interface SaluationRepository extends JpaRepository<Saluation, Long> {

}
