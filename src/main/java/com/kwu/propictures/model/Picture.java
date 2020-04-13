package com.kwu.propictures.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
public class Picture{
    private Long id;
    @NotBlank(message = "Picture name is mandatory")  //exception handling, look at GlobalExceptionHandler
    private String picturename;
    private String picturelink;
    private Date takendate;
    private Long userid;
    private Long mylike;

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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getMylike() {
        return mylike;
    }

    public void setMylike(Long mylike) {
        this.mylike = mylike;
    }

}
