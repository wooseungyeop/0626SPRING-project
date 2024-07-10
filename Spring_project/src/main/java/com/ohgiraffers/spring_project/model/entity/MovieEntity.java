package com.ohgiraffers.spring_project.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "sy_movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;


    @Column(name = "movie_anw")
    private String anw;

    public MovieEntity(String anw) {
        this.anw = anw;
    }

    public MovieEntity(Long id, String anw) {
        this.id = id;
        this.anw = anw;
    }

    public MovieEntity() {

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
        return "MovieEntity{" +
                "id=" + id +
                ", anw='" + anw + '\'' +
                '}';
    }
}
