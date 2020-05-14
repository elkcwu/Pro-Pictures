package com.kwu.propictures.controller;

import com.kwu.propictures.exception.ResourceNotFondException;
import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.PictureWrap;
import com.kwu.propictures.model.User;
import com.kwu.propictures.repository.PicturesRepository;
import com.kwu.propictures.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CrossOrigin(origins={"http://localhost:8081", "http://localhost:3000"}) // all origins and GET, HEAD, and POST methods are allowed
@RestController
@RequestMapping("/proapi/v2")
public class ProPicturesController {
    @Autowired
    PictureService picService;

    ConcurrentMap<String, Picture> pictures = new ConcurrentHashMap<>();

    @GetMapping("/testing")
    public String getTestMessage(){
        return "You are successfully access the ProPicture service";
    }

    @GetMapping("/user/{userid}/pictures")
    public List<Picture> getAllPicturesByUserid(@PathVariable Long userid) throws ResourceNotFondException, MethodArgumentNotValidException {
        return picService.getAllPicturesByUserid(userid);
    }

    @GetMapping("/user/pictures/{id}")
    public ResponseEntity<Picture> getAProPicture(@PathVariable(value = "id") Long pictureId)
            throws ParseException, ResourceNotFondException {
        Picture pic = picService.getAPicture(pictureId);
        return ResponseEntity.ok().body(pic);
    }

    @GetMapping("user/{userid}/pictures/{id}")
    public Picture getPicByUserIdandPicId(@PathVariable(value ="userid")Long userId, @PathVariable(value="id") Long picId){
        Picture pic = picService.getPicByUserIdandPicId(userId, picId);
       return pic;
    }

    @PostMapping("/user/{userid}/pictures") //add a new one
    public Picture addPicture(@Valid @RequestBody Picture picture, @PathVariable Long userid){
        picture.setUser(new User(userid, "", "", "", true, "", ""));
        return picService.addPicture(picture);
    }

    @PutMapping("/user/{userid}/pictures/{id}")//update an existing one or add one
    public void updatePicture(@Valid @RequestBody Picture picture, @PathVariable Long userid, @PathVariable Long id){
        picture.setUser(new User(userid, "", "", "", true, "", ""));
        picService.updatePicture(picture);
    }

    @DeleteMapping("/user/{userid}/pictures/{id}")
    public Map<String, Boolean> deletePicture(@PathVariable(value = "id") Long pictureId) throws ResourceNotFondException {
        return picService.deletePicture(pictureId);
    }

//    @PostMapping("/user/add")
//    public void addUser(@RequestBody User user){
//        picService.addUser(user);
//    }

}
