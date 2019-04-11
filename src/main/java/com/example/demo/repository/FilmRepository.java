package com.example.demo.repository;

import com.example.demo.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Integer>, JpaSpecificationExecutor<Film> {

    List<Film> findByRating(String rating);
}
