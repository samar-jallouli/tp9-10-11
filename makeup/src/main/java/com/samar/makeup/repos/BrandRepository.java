package com.samar.makeup.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.samar.makeup.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}