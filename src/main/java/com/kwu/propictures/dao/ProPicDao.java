package com.kwu.propictures.dao;

import com.kwu.propictures.model.Picture;

import java.util.List;
import java.util.Map;

public interface ProPicDao {
    List<Picture> getAllPicturesByUserid(Long userid);
    Picture getAPicture(Long pictureId);
    Picture getPicByUserIdandPicId(Long userId, Long picId);
    Picture addPicture(Picture pic);
    void updatePicture(Picture picture);
    Map<String, Boolean> deletePicture(Long pictureId);
    List<String> getAllPicturesName();
}
