package com.example.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class LikeModel {

	@Id
	private String Id;
	@Column
	private int noOfLike;
	@OneToMany(cascade = CascadeType.ALL)
	private List<UserModel> likedUser;
	

	public LikeModel(String id, int noOfLike, List<UserModel> likedUser) {
		Id = id;
		this.noOfLike = noOfLike;
		this.likedUser = likedUser;
	}
	public LikeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getNoOfLike() {
		return noOfLike;
	}
	public void setNoOfLike(int noOflikes) {
		this.noOfLike = noOflikes;
	}
	public void setNoOfLike(String id) {
		if(this.Id == id) {
		this.noOfLike = this.likedUser.size();
		}
	}
	public List<UserModel> getLikedUser() {
		return likedUser;
	}
	public void setLikedUser(List<UserModel> likedUser) {
		this.likedUser = likedUser;
	}
	
	@Override
	public String toString() {
		return "LikeModel [Id=" + Id + ", noOfLike=" + noOfLike + ", likedUser=" + likedUser + "]";
	}
	
}
