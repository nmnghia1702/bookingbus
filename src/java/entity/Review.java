/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nmngh
 */
public class Review {
    String ReviewID, UserID, Rating;
    String Comment;

    public Review() {
    }

    public Review(String ReviewID, String UserID, String Rating, String Comment) {
        this.ReviewID = ReviewID;
        this.UserID = UserID;
        this.Rating = Rating;
        this.Comment = Comment;
    }

    public String getReviewID() {
        return ReviewID;
    }

    public void setReviewID(String ReviewID) {
        this.ReviewID = ReviewID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

   
}
