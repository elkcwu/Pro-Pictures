package com.kwu.propictures.controller;

import com.kwu.propictures.exception.ResourceNotFondException;
import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.PictureWrap;
import com.kwu.propictures.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CrossOrigin(origins="http://localhost:8085")
@RestController
@RequestMapping("/proapi/v2")
public class ProPicturesController {
    @Autowired
    PictureService picService;

    ConcurrentMap<String, Picture> pictures = new ConcurrentHashMap<>();

    @GetMapping("/pictures")
    public PictureWrap getAllProPictures() throws ParseException {
       return picService.getAllProPictures();
    }

    //this is hard codes
    @GetMapping("/pictures/{id}")
    public ResponseEntity<Picture> getAProPicture(@PathVariable(value = "id") Long pictureId)
            throws ParseException, ResourceNotFondException {
        Picture pic = picService.getAPicture(pictureId);
        return ResponseEntity.ok().body(pic);
    }

    //get from the below post
    @GetMapping("/pictures/getnew/{id}")
    public Picture getNewProPicture(@PathVariable(value = "id") Long pictureId) throws ParseException {
        return pictures.get(pictureId.toString());
    }

    @PostMapping("/pictures/add")
    public Picture addPicture(@Valid @RequestBody Picture picture){
        pictures.put(picture.getId().toString(), picture);  // use the concurrenthashmap
        return picture;
    }


}
