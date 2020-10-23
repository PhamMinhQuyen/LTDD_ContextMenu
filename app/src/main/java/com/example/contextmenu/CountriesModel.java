package com.example.contextmenu;

public class CountriesModel {
    int id,image;
    String tieuDe,tieuDePhu;

    public CountriesModel() {
        this.id = id;
        this.image = image;
        this.tieuDe = tieuDe;
        this.tieuDePhu = tieuDePhu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTieuDePhu() {
        return tieuDePhu;
    }

    public void setTieuDePhu(String tieuDePhu) {
        this.tieuDePhu = tieuDePhu;
    }
}
