package com.ohgiraffers.spring_project.repository;

import com.ohgiraffers.spring_project.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface MovieRepository extends JpaRepository<MovieEntity, Long> {



}
