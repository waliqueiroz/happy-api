package br.com.happy.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.happy.model.Image;

public class ImageResponseDto {
    private Long id;
    private String url;

    private ImageResponseDto(Long id, String path) {
        this.id = id;
        this.url = "http://localhost:8080/uploads/" + path;
    }

    public static ImageResponseDto parse(Image image) {
        return new ImageResponseDto(image.getId(), image.getPath());
    }

    public static List<ImageResponseDto> parseMany(List<Image> images) {
        return images.stream().map(image -> ImageResponseDto.parse(image)).collect(Collectors.toList());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
