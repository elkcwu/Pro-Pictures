package com.kwu.propictures.repository;

import com.kwu.propictures.model.Picture;

public interface PicturesRepositoryCustom {
    Picture getPictureByPicIdandUserId(Long picId, Long UserId);
}
