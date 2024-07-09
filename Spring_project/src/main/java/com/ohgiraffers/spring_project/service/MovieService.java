package com.ohgiraffers.spring_project.service;

import com.ohgiraffers.spring_project.dto.MovieDTO;
import com.ohgiraffers.spring_project.model.entity.MovieEntity;
import com.ohgiraffers.spring_project.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Transactional
    public Long saveMovie(MovieDTO movieDTO) {
        MovieEntity saveMovied = movieRepository.save(movieDTO.toEntity());
        return saveMovied.getId();
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public int postMovie(MovieDTO movieDTO) {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        for (MovieEntity movieEntity : movieEntities) {
            if (movieEntity.getAnw().equals(movieDTO.getAnw())) {
                return 0;
            }
        }

        MovieEntity movieEntity = new MovieEntity();

        MovieEntity result = movieRepository.save(movieDTO.toEntity());
        return result != null ? 1 : 0;
    }



}
