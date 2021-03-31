package com.example.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table
public class LikeModel {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer noOfLike;
    @Column
    private List<UserModel> likedUser;
    
    public LikeModel(Integer id, Integer noOfLike, List<UserModel> likedUser) {
        this.id = id;
        this.noOfLike = noOfLike;
        this.likedUser = likedUser;
    }

    public LikeModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoOfLike() {
        return noOfLike;
    }

    public void setNoOfLike(Integer noOfLike) {
        this.noOfLike = noOfLike;
    }

    public List<UserModel> getLikedUser() {
        return likedUser;
    }

    public void setLikedUser(List<UserModel> likedUser) {
        this.likedUser = likedUser;
    }

    @Override
    public String toString() {
        return "LikeModel [id=" + id + ", likedUser=" + likedUser + ", noOfLike=" + noOfLike + "]";
    }
}
