package com.kwu.propictures.repository;

import com.kwu.propictures.model.Picture;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class PicturesRepositoryCustomImpl implements PicturesRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Picture getPictureByPicIdandUserId(Long userId, Long picId) {
        Query query = entityManager.createNativeQuery("select  * from picture where user_id = ? and id = ?", Picture.class);
        query.setParameter(1, userId);
        query.setParameter(2, picId);
        return (Picture) query.getSingleResult();
    }
}
