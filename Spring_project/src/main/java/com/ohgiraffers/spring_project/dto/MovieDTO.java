package com.ohgiraffers.spring_project.dto;

import com.ohgiraffers.spring_project.model.entity.MovieEntity;



public class MovieDTO {


    private String anw;



    public MovieDTO() {
    }

    public MovieDTO(String anw) {

        this.anw = anw;
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
                ", anw='" + anw + '\'' +
                '}';
    }

    public MovieEntity toEntity() {
        return new MovieEntity(this.anw);
    }




}
