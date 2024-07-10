package com.ohgiraffers.spring_project.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {


//    @Autowired
//    private MovieService movieService;
//
//    @GetMapping("/seungYeopPage")
//    public String SeungYeop() {
//        return "page/SeungYeop/SeungYeop";
//    }
//
//    @GetMapping("page/SeungYeop/test")
//    public String test() {
//        return "page/SeungYeop/test";
//    }
//
//
//    @PostMapping("/page/SeungYeop/test")
//    public String saveAnw(@RequestParam("anw") String anw){
//        MovieDTO movieDTO = new MovieDTO();
//        movieDTO.setAnw(anw);
//        movieService.saveMovie(movieDTO);
//        return "redirect:/seungYeopPage";
//    }
//
//    @PostMapping("/movielist")
//    public String getAllMovies(Model model) {
//        List<MovieEntity> movieList = movieService.getAllMovies();
//        model.addAttribute("movieList", movieList);
//        return "page/SeungYeop/movielist";
//    }




    @GetMapping("/navigate")
    public String navigate(@RequestParam String title)     {
        if (title.startsWith("우승엽 페이지")) {
            String[] parts = title.split(" ");
            if (parts.length == 3) {
                String pageNumber = parts[2];
                return "redirect:/seungYeopPage" + pageNumber;
            }
            return "redirect:/seungYeopPage";
        }
        return "redirect:/";
    }


}
