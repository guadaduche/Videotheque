package com.epsi.poe.basis;

/**
 * Created by FR20210 on 28/10/2019.
 */
public class Film {
    private String name;
    private String mainActor;
    private int annee;
    private String realisator;
    private Support support;
    private boolean isDispo;

    public Film(String name, String mainActor, int annee, String realisator,Support support) {
        this.name = name;
        this.mainActor = mainActor;
        this.annee = annee;
        this.realisator = realisator;
        this.support = support;
        this.isDispo = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getRealisator() {
        return realisator;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
