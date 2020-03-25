package com.kwu.propictures.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Picture{
    private Long id;
    @NotBlank(message = "Picture name is mandatory")  //exception handling, look at GlobalExceptionHandler
    private String pictureName;
    private String pictureLink;
    private Date takenDate;

    public Picture(){}
    public Picture(Long id, String pictureName, String pictureLink, String takenDate) throws ParseException {
        this.id = id;
        this.pictureName = pictureName;
        this.pictureLink = pictureLink;
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(takenDate);
        this.takenDate = date1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }


}
