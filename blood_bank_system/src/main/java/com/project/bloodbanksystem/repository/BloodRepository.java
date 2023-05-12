package com.project.bloodbanksystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bloodbanksystem.model.Blood;

@Repository
public interface BloodRepository extends JpaRepository<Blood, Long> {


}
