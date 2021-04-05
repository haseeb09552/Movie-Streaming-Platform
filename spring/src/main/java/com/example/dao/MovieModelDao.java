package com.example.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.MovieModel;
import com.example.entities.UserModel;

@Repository
@EnableJpaRepositories
@SpringBootApplication
public interface MovieModelDao extends JpaRepository<MovieModel, String>{


@Query("from MovieModel where movieId= :neo_movie_id")
List<UserModel> find(@Param("neo_movie_id") String movieId);
}
