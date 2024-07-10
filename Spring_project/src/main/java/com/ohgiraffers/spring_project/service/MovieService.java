package com.ohgiraffers.spring_project.service;

import com.ohgiraffers.spring_project.dto.MovieDTO;
import com.ohgiraffers.spring_project.model.entity.MovieEntity;
import com.ohgiraffers.spring_project.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Transactional
    public Long saveMovie(MovieDTO movieDTO) {
        MovieEntity saveMovied = movieRepository.save(movieDTO.toEntity());
        return saveMovied.getId();
    }

    public List<MovieDTO> getAllMovies() {

        List<MovieEntity> movieEntities = movieRepository.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = new MovieDTO(
                    movieEntity.getAnw()
            );
            movieDTOList.add(movieDTO);
        }
        return movieDTOList;
    }

    @Transactional
    public MovieDTO getPost(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieDTO movieDTO = new MovieDTO(
                movieEntity.getAnw()
        );
        return movieDTO;
    }




}
