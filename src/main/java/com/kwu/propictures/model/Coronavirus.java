package com.kwu.propictures.model;

public class Coronavirus {
    private String state;
    private String country;
    private Integer latestConfirmed;
    private Integer preConfirmed;
    private Integer diffence;

    public Coronavirus() {
    }

    public Coronavirus(String state, String country, Integer latestConfirmed, Integer preConfirmed, Integer diffence) {
        this.state = state;
        this.country = country;
        this.latestConfirmed = latestConfirmed;
        this.preConfirmed = preConfirmed;
        this.diffence = diffence;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLatestConfirmed() {
        return latestConfirmed;
    }

    public void setLatestConfirmed(Integer latestConfirmed) {
        this.latestConfirmed = latestConfirmed;
    }

    public Integer getPreConfirmed() {
        return preConfirmed;
    }

    public void setPreConfirmed(Integer preConfirmed) {
        this.preConfirmed = preConfirmed;
    }

    public Integer getDiffence() {
        return diffence;
    }

    public void setDiffence(Integer diffence) {
        this.diffence = diffence;
    }

    @Override
    public String toString() {
        return "Coronavirus{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestConfirmed=" + latestConfirmed +
                ", preConfirmed=" + preConfirmed +
                ", diffence=" + diffence +
                '}';
    }
}
