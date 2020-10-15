package br.com.happy.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "orphanages")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Orphanage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal latitude;

    @Column
    private BigDecimal longitude;

    @Column
    private String about;

    @Column
    private String instructions;

    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name = "open_on_weekends")
    private Boolean openOnWeekends;

    @OneToMany(mappedBy = "orphanage", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Image> images;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getOpeningHours() {
        return this.openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Boolean isOpenOnWeekends() {
        return this.openOnWeekends;
    }

    public Boolean getOpenOnWeekends() {
        return this.openOnWeekends;
    }

    public void setOpenOnWeekends(Boolean openOnWeekends) {
        this.openOnWeekends = openOnWeekends;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Orphanage)) {
            return false;
        }
        Orphanage orphanage = (Orphanage) o;
        return Objects.equals(id, orphanage.id) && Objects.equals(name, orphanage.name)
                && Objects.equals(latitude, orphanage.latitude) && Objects.equals(longitude, orphanage.longitude)
                && Objects.equals(about, orphanage.about) && Objects.equals(instructions, orphanage.instructions)
                && Objects.equals(openingHours, orphanage.openingHours)
                && Objects.equals(openOnWeekends, orphanage.openOnWeekends) && Objects.equals(images, orphanage.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, about, instructions, openingHours, openOnWeekends, images);
    }

}
