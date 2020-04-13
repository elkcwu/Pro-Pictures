package com.kwu.propictures.controller;

import com.kwu.propictures.exception.ResourceNotFondException;
import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.PictureWrap;
import com.kwu.propictures.repository.PicturesRepository;
import com.kwu.propictures.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/proapi/v2")
public class ProPicturesController {
    @Autowired
    PictureService picService;

    ConcurrentMap<String, Picture> pictures = new ConcurrentHashMap<>();

    @GetMapping("/pictures")
    public List<Picture> getAllProPictures() throws ParseException {
       return picService.getAllProPictures();
    }

    //this is hard codes
    @GetMapping("/pictures/{id}")
    public ResponseEntity<Picture> getAProPicture(@PathVariable(value = "id") Long pictureId)
            throws ParseException, ResourceNotFondException {
        Picture pic = picService.getAPicture(pictureId);
        return ResponseEntity.ok().body(pic);
    }

    @PostMapping("/pictures")
    public Picture addPicture(@Valid @RequestBody Picture picture){
        return picService.addPicture(picture);
    }

    @DeleteMapping("/pictures/{id}")
    public Map<String, Boolean> deletePicture(@PathVariable(value = "id") Long pictureId) throws ResourceNotFondException {
        return picService.deletePicture(pictureId);
    }


}
