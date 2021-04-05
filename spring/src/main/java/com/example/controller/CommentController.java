package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.LikeModelDao;
import com.example.dao.MovieModelDao;
import com.example.dao.UserModelDao;
import com.example.entities.LikeModel;
import com.example.entities.MovieModel;
import com.example.entities.UserModel;


@RestController
public class CommentController {

	@Autowired
	private LikeModelDao likeModelDao;
	@Autowired
	private UserModelDao userModelDao;
	@Autowired
	private MovieModelDao movieModelDao;

	//To add the like based on the movie id
	@PostMapping("/like/{id}")
	public void addLike(@PathVariable String id, @RequestBody String Id) {
		if(this.movieModelDao.existsById(id)) {
			MovieModel movieModel = this.movieModelDao.getOne(id);
			UserModel userModel = this.userModelDao.getUserByActive(true);
			LikeModel likeModel = this.likeModelDao.getOne(Id);
			likeModel.getLikedUser().add(userModel);
			likeModel.setLikedUser(likeModel.getLikedUser());
			likeModel.setNoOfLike(Id);
			movieModel.setLike(likeModel);
			this.likeModelDao.save(likeModel);
			this.movieModelDao.save(movieModel);
		}
	}
	
	//To remove the like based on the movie id
	@DeleteMapping("/like/{id}")
	public void removeLive (@PathVariable String Id, @RequestBody String id){
		if(this.movieModelDao.existsById(Id)) {
			MovieModel movieModel = this.movieModelDao.getOne(Id);
			UserModel userModel = this.userModelDao.getUserByActive(true);
			LikeModel likeModel = this.likeModelDao.getOne(Id);
			likeModel.getLikedUser().remove(userModel);
			likeModel.setLikedUser(likeModel.getLikedUser());
			likeModel.setNoOfLike(Id);
			movieModel.setLike(likeModel);
			this.likeModelDao.save(likeModel);
			this.movieModelDao.save(movieModel);
		}
	}
	
	
	//To get the likes based on the like Id
	@GetMapping("/admin/comment/{id}")
	public int getLikeCount(@PathVariable String id) {
		if(likeModelDao.existsById(id)) {
			return likeModelDao.getOne(id).getNoOfLike();
		}
		return 0;
	}
}
