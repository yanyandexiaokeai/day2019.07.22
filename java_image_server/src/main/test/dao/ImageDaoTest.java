package dao;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ImageDaoTest {

    
    @Test
    public void insert() {
        ImageDao imageDao = new ImageDao();
        //准备数据
        Image image = new Image();
        image.setImageName("2.jpg");
        image.setSize(1024);
        image.setUploadTime("20200701");
        image.setContentType("image/jpeg");
        image.setPath("./image/d48616ccd25273c8d94e107808323570 ");
        image.setMd5("d48616ccd25273c8d94e107808323570");
        boolean flag = imageDao.insert(image);
        System.out.println("result="+flag);

    }

    @Test
    public void selectAll() {
        ImageDao imageDao = new ImageDao();
        List<Image> lists = imageDao.selectAll();
        System.out.println("size ="+ lists.size());
        System.out.println();
        for (Image image: lists){
            System.out.println("name = "+image.getImageName());
        }

    }

    @Test
    public void selectOne() {
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(60);
        System.out.println(image);
    }

    @Test
    public void delete() {
        ImageDao imageDao = new ImageDao();
        boolean flag = imageDao.delete(66);
    }

    @Test
    public void selectByMd5() {
        ImageDao imageDao = new ImageDao();
        String md5 = "5e655fddb732603f7501354697de9673";
        Image image = imageDao.selectByMd5(md5);
        System.out.println("name = "+image.getImageName());
    }
}