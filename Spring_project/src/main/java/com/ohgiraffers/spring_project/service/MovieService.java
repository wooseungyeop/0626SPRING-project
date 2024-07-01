package com.ohgiraffers.spring_project.service;

import com.ohgiraffers.spring_project.dto.MovieDTO;
import com.ohgiraffers.spring_project.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        System.out.println("sedasd");
    }


}
