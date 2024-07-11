package com.ohgiraffers.spring_project.dto;

import com.ohgiraffers.spring_project.model.entity.MovieEntity;



public class MovieDTO {

    private Long id;
    private String anw;



    public MovieDTO() {
    }


    public MovieDTO(Long id, String anw) {
        this.id = id;
        this.anw = anw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnw() {
        return anw;
    }

    public void setAnw(String anw) {
        this.anw = anw;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", anw='" + anw + '\'' +
                '}';
    }

    public MovieEntity toEntity() {
        return new MovieEntity(this.id, this.anw);
    }




}
