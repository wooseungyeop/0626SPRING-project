package com.ohgiraffers.spring_project.controller;


import com.ohgiraffers.spring_project.dto.MovieDTO;
import com.ohgiraffers.spring_project.model.entity.MovieEntity;
import com.ohgiraffers.spring_project.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/seungYeopPage")
    public String SeungYeop() {
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

    @PostMapping("/movielist")
    public String getAllMovies(Model model) {
        List<MovieEntity> movieList = movieService.getAllMovies();
        model.addAttribute("movieList", movieList);
        return "page/SeungYeop/movielist";
    }


    @PostMapping
    public ModelAndView postMovie(MovieDTO movieDTO, ModelAndView mv){
        if(movieDTO.getAnw() == null || movieDTO.getAnw().equals("")){
            mv.setViewName("redirect:/seungYeopPage");
        }
        int result = movieService.postMovie(movieDTO);

        if (result <= 0){
            mv.setViewName("error");
        }else{
            mv.setViewName("redirect:/seungYeopPage");
        }
        return mv;

    }

}
