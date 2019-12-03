package epsi.fr.applicationtitre;

import android.widget.DatePicker;

import java.util.Date;

/**
 * Created by Remi on 17/06/2019.
 */

public class Task {

    private String id;
    private String nom;
    private String dateAttribution;
    private String description;

    public Task(){

    }

    public Task(String id, String nom, String date, String description){
        this.id = id;
        this.nom = nom;
        this.dateAttribution = date;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(String dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public String getDesciption() {
        return description;
    }

    public void setDesciption(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
