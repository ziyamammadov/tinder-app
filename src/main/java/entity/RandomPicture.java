package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomPicture {
    private static final String no_image = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX3851270.jpg";
    private static List<String> pictures = new ArrayList<>(Arrays.asList(
            "https://media.vanityfair.com/photos/5d669dc5b5890000082acd6b/16:9/w_2560%2Cc_limit/Trump32.jpg",
            "https://photogrist.com/wp-content/uploads/2016/09/Agata-Serge.jpg",
            "https://www.biography.com/.image/t_share/MTY3MDUxMjkzMjI1OTIwMTcz/brad-pitt-attends-the-premiere-of-20th-century-foxs--square.jpg",
            "https://static.euronews.com/articles/stories/03/92/77/28/1280x720_cmsv2_0154807e-366f-5524-b90b-a9d7e09cc22e-3927728.jpg",
            "https://www.cheatsheet.com/wp-content/uploads/2019/12/Angelina-Jolie-1024x733.jpg",
            "https://cdn2us.denofgeek.com/sites/denofgeekus/files/styles/main_wide/public/screen-shot-2018-04-18-at-3-27-30-pm.png?",
            "https://cdn.vox-cdn.com/thumbor/3lzrtzXS9FVHKjbikyYvnqDPKgk=/0x0:1800x1200/1200x800/filters:focal(512x440:800x728)/cdn.vox-cdn.com/uploads/chorus_image/image/54062369/PB_sc3pt_0009_hires2.0.jpg",
            "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Finsertcoin%2Ffiles%2F2017%2F05%2Freasons-why7-1.jpg",
            "https://media.vanityfair.com/photos/5d640701b5890000082acd16/16:9/w_2560%2Cc_limit/13-reasons-why-season-4.jpg",
            "https://i.pinimg.com/originals/48/1e/2b/481e2bda04fcbbb5a67bd84816c42a76.jpg"));

    public static String randomPictureGenerator() {
        if (pictures.size() > 0) {
            int random = (int) (Math.random() * (pictures.size() - 1));
            return pictures.get(random);
        }
        return no_image;
    }
}
