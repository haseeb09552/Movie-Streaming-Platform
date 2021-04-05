package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.el.MethodNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.MovieModelDao;
import com.example.entities.MovieModel;

@RestController
public class MovieController {

	@Autowired
	private MovieModelDao movieModelDao;
	
	//For users to fetch a list of all movies
	@GetMapping("/movie")
	public List<MovieModel> getAllMovie(){
		List<MovieModel> movieModel = new ArrayList<>();
		this.movieModelDao.findAll()
		.forEach(movieModel::add);
		return movieModel;
	}
	
	//For users to fetch a movie based on movie id
	@GetMapping("/movie/{id}")
	public Optional<MovieModel> showMovie(@PathVariable String id){
		if(this.movieModelDao.existsById(id)) {
			return this.movieModelDao.findById(id);
		}
		return null;
	}
	
	//For admin to add a movie
	@PutMapping("/admin/movie")
	public void addMovie(@RequestBody MovieModel image){
		image.getLike().setNoOfLike(image.getLike().getLikedUser().size());
		this.movieModelDao.save(image); 
	}
	
	//For admin to fetch a list of movie
	@GetMapping("/admin/movie")
	public List<MovieModel> getAllMovieToAdmin(){
		List<MovieModel> movieModel = new ArrayList<>();
		this.movieModelDao.findAll()
		.forEach(movieModel::add);
		return movieModel;
	}
	
	//For admin to fetch a movie based on movie id
	@GetMapping("/admin/movie/{id}")
	public Optional<MovieModel> showMovieToAdmin(@PathVariable String id){
		if(this.movieModelDao.existsById(id)) {
			return this.movieModelDao.findById(id);
		}
		return null;
	}
	
	//For admin to delete a movie based on movie id
	@DeleteMapping("/admin/movie/{id}")
	public void deleteMovie(@PathVariable String id){
		if(this.movieModelDao.existsById(id)) {
			this.movieModelDao.deleteById(id);
		}
	}
	
	//For admin to update a movie based on movie id
	@PutMapping("/admin/movie/{id}")
	public void updateMovie(@RequestBody MovieModel data){
		if(this.movieModelDao.existsById(data.getMovieId())) {
			this.movieModelDao.save(data);
		}
	}
	
	
	//Exception Handling
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String illegalArgumentExceptionHandler(Model m) {
		m.addAttribute("msg", "Illegal input");
		return "error_page";
	}
	
	@ExceptionHandler(value = MethodNotFoundException.class)
	public String methodNotFoundExceptionHandler(Model m) {
		m.addAttribute("msg", "method not allowed");
		return "error_page";
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerExceptionHandler(Model m) {
		m.addAttribute("msg", "Input can't be empty");
		return "error_page";
	}
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Model m) {
		m.addAttribute("msg", "Error has Occured");
		return "error_page";
	}
	
}
