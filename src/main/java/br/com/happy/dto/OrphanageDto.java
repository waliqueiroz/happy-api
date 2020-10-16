package br.com.happy.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import br.com.happy.model.Orphanage;

public class OrphanageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String name;
    
    @NotNull
    private BigDecimal latitude;
    
    @NotNull
    private BigDecimal longitude;
    
    @NotEmpty
    private String about;
    
    @NotEmpty
    private String instructions;
    
    @NotEmpty
    private String openingHours;
    
    @NotNull
    private Boolean openOnWeekends;
    
    @NotEmpty
    private MultipartFile[] images;

    public Orphanage getOrphanage() {
        return new Orphanage(name, latitude, longitude, about, instructions, openingHours, openOnWeekends);
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

    public MultipartFile[] getImages() {
        return this.images;
    }

    public void setImages(MultipartFile[] images) {
        this.images = images;
    }

}
