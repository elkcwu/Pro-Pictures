package com.kwu.propictures.model;

import java.util.List;

public class PictureWrap {

    private List<Picture> pictureList;

    public List<Picture> getPictureList(){
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList){
        this.pictureList = pictureList;
    }

}
