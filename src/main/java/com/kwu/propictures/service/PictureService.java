package com.kwu.propictures.service;

import com.kwu.propictures.exception.ResourceNotFondException;
import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.PictureWrap;
import com.kwu.propictures.model.User;
import com.kwu.propictures.repository.PicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;

@Service
@EnableSwagger2  //http://localhost:8081/v2/api-docs
                 //http://localhost:8081/swagger-ui.html
@Transactional
public class PictureService {

    @Autowired
    PicturesRepository repository;

//    @Cacheable("pictures")
//    public List<Picture> getAllProPictures(Long userid) {
//        List<Picture> picturesList = new ArrayList<>();
//        repository.findByUserId(userid).forEach(picturesList :: add);
//        return picturesList;
//    }

    public List<Picture> getAllPicturesByUserid(Long userid){
        List<Picture> picList = new ArrayList<>();
        repository.findByUserId(userid)
                .forEach(picList :: add);
        return picList;
    }

//    @Cacheable("picture")
    public Picture getAPicture(Long pictureId) throws ResourceNotFondException {
        Optional<Picture> picture = repository.findById(pictureId);
        picture.orElseThrow(()-> new ResourceNotFondException("No resouce is found with this ID: " + pictureId));
        return picture.get();
    }

    public Picture getPicByUserIdandPicId(Long userId, Long picId) {
        Picture pic = repository.getPictureByPicIdandUserId(userId, picId);
        return pic;
    }

    public Picture addPicture(Picture pic){
        return repository.save(pic);
    }

    public void updatePicture(Picture picture){
        repository.save(picture);
    }

    public Map<String, Boolean> deletePicture(Long pictureId)  throws ResourceNotFondException{
        Picture pic = repository.findById(pictureId)
                .orElseThrow(()->new ResourceNotFondException("Picture not found for this id ::" + pictureId));
        repository.delete(pic);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
