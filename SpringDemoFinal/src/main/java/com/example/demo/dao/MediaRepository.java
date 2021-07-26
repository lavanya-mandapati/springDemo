package com.example.demo.dao;

import com.example.demo.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media,Integer> {
}
