package com.example.demo.controller;

import com.example.demo.bean.SearchFilmForm;
import com.example.demo.entity.Film;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.spec.FilmSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppRestController {

    @Autowired
    FilmRepository filmRepos;

    @Autowired
    FilmSpecification filmSpec;

    @GetMapping("/filmList")
    public List<Film> getFilmList(){

        List<Film> filmList = filmRepos.findAll();

        return  filmList;
    }

    @GetMapping("/filmListByRating")
    public List<Film> getFilmListByRating(@RequestParam String rating){

        List<Film> filmList = filmRepos.findByRating(rating);

        return  filmList;
    }

    @GetMapping("/filmList/{rating}")
    public List<Film> getFilmListByRatingURL(@PathVariable String rating){

        List<Film> filmList = filmRepos.findByRating(rating);

        return  filmList;
    }

    @PostMapping("/inquery/film")
    public List<Film> inqueryFilm(@RequestBody SearchFilmForm filmForm){

        List<Film> filmList = filmSpec.inqueryFilm(filmForm);

        return  filmList;
    }



}
