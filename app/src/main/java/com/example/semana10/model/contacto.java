package com.example.semana10.model;

import java.util.ArrayList;


public class contacto {

    public String phone;
    public String nickname;
    public String image;

    public String getSmallImage(){
        return this.image;
    }

    public contacto(String _phone, String _nickname, String _image) {

        this.image = _image;
        this.phone = _phone;
        this.nickname = _nickname;
    }

    public static ArrayList getCollection() {
        ArrayList<contacto> collection = new ArrayList<>();
        collection.add(new contacto("981999923", "Bichito","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new contacto("9859913923", "Plaga","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-5.jpg"));
        collection.add(new contacto("981914213", "Libelula","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-4.jpg"));
        return collection;}


}