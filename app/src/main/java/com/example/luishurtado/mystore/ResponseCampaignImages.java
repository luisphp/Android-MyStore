package com.example.luishurtado.mystore;

import java.util.List;

/**
 * Created by luis.hurtado on 04/06/2018.
 */
public class ResponseCampaignImages {

    private List<ImagenesBean> imagenes;

    public List<ImagenesBean> getImagenes() {
        return imagenes;
    }


    public static class ImagenesBean {


        private String id;
        private String url_image;
        private int is_active;
        private String name;

        public String getId() {
            return id;
        }


        public String getUrl_image() {
            return url_image;
        }


        public int getIs_active() {
            return is_active;
        }

        public String getName() {
            return name;
        }

    }
}
