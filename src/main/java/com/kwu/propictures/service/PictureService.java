package com.kwu.propictures.service;

import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.PictureWrap;
import com.kwu.propictures.repository.PicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@EnableSwagger2
public class PictureService {

    @Autowired
    PicturesRepository repository;

    @Cacheable("pictures")
    public PictureWrap getAllProPictures() throws ParseException {
        List<Picture> picList = new ArrayList<>();
        Picture pic1 = new Picture(Long.parseLong("123"), "Name Tokey Japan",
                "d:/temp/picturelink", "12/28/2019");
        Picture pic2 = new Picture(Long.parseLong("456"), "Name Guangzhou China",
                "d:\\temp\\picturelink2", "1/8/2019");
        picList.add(pic1);
        picList.add(pic2);

        PictureWrap picWrap = new PictureWrap();
        picWrap.setPictureList(picList);
        return picWrap;
    }

    @Cacheable("picture")
    public Picture getAPicture(Long pictureId) throws ParseException {
//        Optional<Picture> picture = repository.findById(pictureId);
        Picture picture = new Picture(pictureId, "one picture Koyto",
                "d:\\temp\\pictureLink1", "2/9/2019");
        return picture;
    }

}
