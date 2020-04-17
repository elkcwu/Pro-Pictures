package com.kwu.propictures.repository;

import com.kwu.propictures.model.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepository extends CrudRepository<Picture, Long> {
    public List<Picture> findByUserId(Long userid); //method naming is very important here
    //here the name means: find the pictures by the User object of id
}
