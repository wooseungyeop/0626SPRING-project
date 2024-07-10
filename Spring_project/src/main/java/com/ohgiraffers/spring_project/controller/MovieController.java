package com.ohgiraffers.spring_project.controller;


import com.ohgiraffers.spring_project.dto.MovieDTO;
import com.ohgiraffers.spring_project.model.entity.MovieEntity;
import com.ohgiraffers.spring_project.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        List<MovieDTO> movieDTOList = movieService.getAllMovies();
        model.addAttribute("movieDTOList", movieDTOList);
        return "page/SeungYeop/SeungYeop";
    }



    @GetMapping("page/SeungYeop/test")
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


//    @GetMapping("/post/{id}")
//    public String detail(@PathVariable("id") Long id, Model model) {
//        MovieDTO movieDTO = movieService.getPost(id);
//        model.addAttribute("post", movieDTO);
//        return "page/SeungYeop/SeungYeop";
//    }
//
//    @GetMapping("/post/SeungYeop/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        MovieDTO movieDTO = movieService.getPost(id);
//        model.addAttribute("post", movieDTO);
//        return "page/SeungYeop/SeungYeop";
//    }



}
