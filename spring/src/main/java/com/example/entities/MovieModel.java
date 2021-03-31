package com.example.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieModel {

	@Id
	private String movieId;
	private String movieName;
	private String movieUrl;
	private String moviePosterUrl;
	private List<String> movieCast;
	private LikeModel like;
	
	public MovieModel(String movieId, String movieName, String movieUrl, String moviePosterUrl, List<String> movieCast,
			LikeModel like) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieUrl = movieUrl;
		this.moviePosterUrl = moviePosterUrl;
		this.movieCast = movieCast;
		this.like = like;
	}
	public MovieModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieUrl() {
		return movieUrl;
	}
	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}
	public String getMoviePosterUrl() {
		return moviePosterUrl;
	}
	public void setMoviePosterUrl(String moviePosterUrl) {
		this.moviePosterUrl = moviePosterUrl;
	}
	public List<String> getMovieCast() {
		return movieCast;
	}
	public void setMovieCast(List<String> movieCast) {
		this.movieCast = movieCast;
	}
	public LikeModel getLike() {
		return like;
	}
	public void setLike(LikeModel like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "MovieModel [movieId=" + movieId + ", movieName=" + movieName + ", movieUrl=" + movieUrl
				+ ", moviePosterUrl=" + moviePosterUrl + ", movieCast=" + movieCast + ", like=" + like + "]";
	}
	
}
