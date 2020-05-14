package com.kwu.propictures.repository;

import com.kwu.propictures.model.Picture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepository extends CrudRepository<Picture, Long> {
    public List<Picture> findByUserId(Long userid); //method naming is very important here
    //here the name means: find the pictures by the User object of id
    //https://www.youtube.com/watch?v=_Jnu_jHfQbM

    @Query(value = "select  * from picture where user_id = ?1 and id = ?2", nativeQuery = true)
    Picture getPictureByPicIdandUserId(Long UserId, Long picId);
}
