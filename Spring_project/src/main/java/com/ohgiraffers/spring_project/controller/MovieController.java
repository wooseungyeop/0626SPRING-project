package com.ohgiraffers.spring_project.controller;


import com.ohgiraffers.spring_project.dto.MovieDTO;
import com.ohgiraffers.spring_project.model.entity.MovieEntity;
import com.ohgiraffers.spring_project.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {


    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/seungYeopPage")
    public String SeungYeop(Model model) {

        List<MovieDTO> movieDTO = movieService.getAllMovies();
        model.addAttribute("movieDTO", movieDTO);
        return "page/SeungYeop/SeungYeop";
    }



    @GetMapping("/page/SeungYeop/test")
    public String test() {
        return "page/SeungYeop/test";
    }


    @PostMapping("/page/SeungYeop/test")
    public String saveAnw(@RequestParam("anw") String anw){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setAnw(anw);
        movieService.saveMovie(movieDTO);
        return "redirect:/seungYeopPage";
    }


    @GetMapping("/page/SeungYeop/edit/{id}")
    public String getMovie(@PathVariable("id") Long id, Model model) {
        MovieDTO movieDTO = movieService.getMovie(id);
        movieDTO.setId(id);
            model.addAttribute("movie", movieDTO); // 모델에 post 객체 추가
        return "page/SeungYeop/SeungYeop";
    }




    @PutMapping("/page/SeungYeop/edit/{id}")
    public String updateMovie(MovieDTO movieDTO){
        movieService.saveMovie(movieDTO);
        return "redirect:/";
    }


}
