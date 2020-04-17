package com.kwu.propictures.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
public class Picture{

    private Long id;
    @NotBlank(message = "Picture name is mandatory")  //exception handling, look at GlobalExceptionHandler
    private String picturename;
    private String picturelink;
    private Date takendate;
    private Long mylike;
    private User user;  //many to one relationship

    public Picture(Long id, @NotBlank(message = "Picture name is mandatory") String picturename, String picturelink, Date takendate, Long mylike, User user) {
        this.id = id;
        this.picturename = picturename;
        this.picturelink = picturelink;
        this.takendate = takendate;
        this.mylike = mylike;
        this.user = user;
    }

    public Picture(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getPicturelink() {
        return picturelink;
    }

    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink;
    }

    public Date getTakendate() {
        return takendate;
    }

    public void setTakendate(Date takendate) {
        this.takendate = takendate;
    }

    public Long getMylike() {
        return mylike;
    }

    public void setMylike(Long mylike) {
        this.mylike = mylike;
    }

    @ManyToOne(targetEntity = User.class)  //very important
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
