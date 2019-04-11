package com.example.demo.repository.spec;

import com.example.demo.bean.SearchFilmForm;
import com.example.demo.entity.Film;
import com.example.demo.repository.FilmRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FilmSpecification {

    @Autowired
    FilmRepository filmRepos;

    private Logger log = LoggerFactory.getLogger(this.getClass());


    public List<Film> inqueryFilm(SearchFilmForm filmForm){

        log.info("inquery : {}",filmForm.toString());
        Specification<Film> spec = Specification.where(null);
        if(!StringUtils.isBlank(filmForm.getRating())){
            String value = filmForm.getRating();

            Specification<Film> specRating = (Specification<Film>)(root, query , builder)->builder
                    .equal(root.get("rating"),value);

            spec = spec.and(Specification.where(specRating));

        }

        if(!StringUtils.isBlank(filmForm.getTitle())){
            String value = filmForm.getTitle();
            final String finalValue = value.toLowerCase();

            Specification<Film> specTitle = (Specification<Film>)(root, query , builder)->builder
                    .like(builder.lower(root.get("title")),"%"+finalValue+"%");

            spec = spec.and(Specification.where(specTitle));

        }

        if(null != filmForm.getReleaseYear()){
            Integer value = filmForm.getReleaseYear();

            Specification<Film> specReleaseYear = (Specification<Film>)(root, query , builder)->builder
                    .equal(root.get("releaseYear"),value);

            spec = spec.and(Specification.where(specReleaseYear));

        }

        if(null != filmForm.getReplacementCost()){
            BigDecimal value = filmForm.getReplacementCost();

            Specification<Film> specReplacementCost = (Specification<Film>)(root, query , builder)->builder
                    .greaterThan(root.get("replacementCost"),value);

            spec = spec.and(Specification.where(specReplacementCost));

        }

        if(null != filmForm.getLength()){
            Integer value = filmForm.getLength();

            Specification<Film> specLength = (Specification<Film>)(root, query , builder)->builder
                    .greaterThan(root.get("length"),value);

            spec = spec.and(Specification.where(specLength));

        }


        List<Film> result = filmRepos.findAll(spec);
        return result;
    }
}