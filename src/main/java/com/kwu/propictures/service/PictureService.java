package com.kwu.propictures.service;

import com.kwu.propictures.exception.ResourceNotFondException;
import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.PictureWrap;
import com.kwu.propictures.repository.PicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.ParseException;
import java.util.*;

@Service
@EnableSwagger2
public class PictureService {

    @Autowired
    PicturesRepository repository;

//    @Cacheable("pictures")
    public List<Picture> getAllProPictures() {
        List<Picture> picturesList = new ArrayList<>();
        repository.findAll().forEach(picturesList :: add);
        return picturesList;
    }

//    @Cacheable("picture")
    public Picture getAPicture(Long pictureId) throws ResourceNotFondException {
        Optional<Picture> picture = repository.findById(pictureId);
        picture.orElseThrow(()-> new ResourceNotFondException("No resouce is found with this ID: " + pictureId));
        return picture.get();
    }

    public Picture addPicture(Picture pic){
        return repository.save(pic);
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
