package com.samar.makeup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samar.makeup.entities.Makeup;

public interface MakeupRepository extends JpaRepository<Makeup, Long> {

}
