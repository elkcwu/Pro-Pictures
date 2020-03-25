package com.kwu.propictures.repository;

import com.kwu.propictures.model.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesRepository extends CrudRepository<Picture, Long> {
}
