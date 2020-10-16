package br.com.happy.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.happy.model.Orphanage;

public class OrphanageResponseDto {
    private Long id;

    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String about;

    private String instructions;

    private String openingHours;

    private Boolean openOnWeekends;

    private List<ImageResponseDto> images;

    public OrphanageResponseDto(Long id, String name, BigDecimal latitude, BigDecimal longitude, String about,
            String instructions, String openingHours, Boolean openOnWeekends, List<ImageResponseDto> images) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.about = about;
        this.instructions = instructions;
        this.openingHours = openingHours;
        this.openOnWeekends = openOnWeekends;
        this.images = images;
    }

    public static OrphanageResponseDto parse(Orphanage orphanage) {
        List<ImageResponseDto> imageResponseDtos = ImageResponseDto.parseMany(orphanage.getImages());

        return new OrphanageResponseDto(orphanage.getId(), orphanage.getName(), orphanage.getLatitude(),
                orphanage.getLongitude(), orphanage.getAbout(), orphanage.getInstructions(),
                orphanage.getOpeningHours(), orphanage.getOpenOnWeekends(), imageResponseDtos);
    }

    public static List<OrphanageResponseDto> parseMany(List<Orphanage> orphanages) {
        return orphanages.stream().map(orphanage -> OrphanageResponseDto.parse(orphanage)).collect(Collectors.toList());
    }

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

    public List<ImageResponseDto> getImages() {
        return this.images;
    }

    public void setImages(List<ImageResponseDto> images) {
        this.images = images;
    }

}
