package com.kwu.propictures.repository;

import com.kwu.propictures.dao.ProPicDao;
import com.kwu.propictures.model.Picture;
import com.kwu.propictures.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProPicDaoImpl implements ProPicDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getAllPicturesName() {
        List<String> pictureName = new ArrayList<>();
        pictureName.addAll(jdbcTemplate.queryForList("select picturename from picture", String.class));
        return pictureName;
    }

    @Override
    public List<Picture> getAllPicturesByUserid(Long userid) {
        String sql = "SELECT p.*, u.username FROM picture AS p JOIN user as u ON p.user_id = u.id where p.user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userid}, new PictureResMapper());
    }

    private static final class PictureResMapper implements RowMapper<Picture>{

        @Override
        public Picture mapRow(ResultSet rs, int rowNum) throws SQLException{
            Picture pic = new Picture();
                pic.setId(rs.getLong("id"));
                pic.setPicturename(rs.getString("picturename"));
                pic.setPicturelink(rs.getString("picturelink"));
                pic.setTakendate(rs.getDate("takendate"));
                pic.setMylike(rs.getLong("mylike"));
                User user = new User();
                user.setId(rs.getLong("user_id"));
                pic.setUser(user);
            return pic;
        }
    }

    @Override
    public Picture getAPicture(Long pictureId) {
        return null;
    }

    @Override
    public Picture getPicByUserIdandPicId(Long userId, Long picId) {
        return null;
    }

    @Override
    public Picture addPicture(Picture pic) {
        return null;
    }

    @Override
    public void updatePicture(Picture picture) {

    }

    @Override
    public Map<String, Boolean> deletePicture(Long pictureId) {
        return null;
    }
}
