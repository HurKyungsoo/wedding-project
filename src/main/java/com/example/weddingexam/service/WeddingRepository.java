package com.example.weddingexam.service;

import com.example.weddingexam.dto.WeddingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingRepository extends JpaRepository<WeddingEntity, Long> {
}
