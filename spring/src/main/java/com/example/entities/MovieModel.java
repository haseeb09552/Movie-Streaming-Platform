package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="movies")
public class MovieModel {

	@Id
	@Column(name="neo_movie_id")
	private String movieId;
	@Column(name="neo_movie_name")
	private String movieName;
	@Column(name="neo_movie_url")
	private String movieUrl;
	@Column(name="neo_movie_poster_url")
	private String moviePosterUrl;
	@Column(name="neo_movie_cast")
	private String movieCast;
//	@OneToOne(targetEntity=LikeModel.class, mappedBy="MovieModel", fetch=FetchType.EAGER)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieId", referencedColumnName = "Id")
	private LikeModel like;
	
	public MovieModel(String movieId, String movieName, String movieUrl, String moviePosterUrl, String movieCast,
			String likeId) {
		List<UserModel> likedUser = new ArrayList<>();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieUrl = movieUrl;
		this.moviePosterUrl = moviePosterUrl;
		this.movieCast = movieCast;
		this.like = new LikeModel(likeId,0,likedUser);
	}


	public MovieModel() {
		super();
	

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

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public LikeModel getLike() {
		return like;
	}

	public void setLike(LikeModel like) {
		this.like = like;
	}

	
	
	
	/*
	 * @Override public String toString() { return "MovieModel [movieId=" + movieId
	 * + ", movieName=" + movieName + ", movieUrl=" + movieUrl + ", moviePosterUrl="
	 * + moviePosterUrl + ", movieCast=" + movieCast + ", like=" + like + "]"; }
	 */
	
}
