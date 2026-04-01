package com.samar.makeup.entities;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Makeup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMakeup;

    @NotNull
    @Size(min = 4, max = 15)
    private String nomMakeup;

    @Min(value = 10)
    @Max(value = 10000)
    private Double prixMakeup;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation;

    @ManyToOne
    private Brand brand;

    public Makeup() {
        super();
    }

    public Makeup(String nomMakeup, Double prixMakeup, Date dateCreation) {
        super();
        this.nomMakeup = nomMakeup;
        this.prixMakeup = prixMakeup;
        this.dateCreation = dateCreation;
    }

    public Long getIdMakeup() { return idMakeup; }
    public void setIdMakeup(Long idMakeup) { this.idMakeup = idMakeup; }

    public String getNomMakeup() { return nomMakeup; }
    public void setNomMakeup(String nomMakeup) { this.nomMakeup = nomMakeup; }

    public Double getPrixMakeup() { return prixMakeup; }
    public void setPrixMakeup(Double prixMakeup) { this.prixMakeup = prixMakeup; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    @Override
    public String toString() {
        return "Makeup [idMakeup=" + idMakeup + ", nomMakeup=" + nomMakeup + 
               ", prixMakeup=" + prixMakeup + ", dateCreation=" + dateCreation + "]";
    }
}