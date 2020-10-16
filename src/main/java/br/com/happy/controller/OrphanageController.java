package br.com.happy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import br.com.happy.dto.OrphanageDto;
import br.com.happy.dto.OrphanageResponseDto;
import br.com.happy.model.Orphanage;
import br.com.happy.service.OrphanageService;

@RestController
@RequestMapping("/orphanages")
public class OrphanageController {

    @Autowired
    private OrphanageService orphanageService;

    @GetMapping
    public List<OrphanageResponseDto> index() {
        List<Orphanage> orphanages = orphanageService.index();
        return OrphanageResponseDto.parseMany(orphanages);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = { "multipart/form-data" })
    public OrphanageResponseDto create(@Valid @ModelAttribute OrphanageDto orphanageDto) {
        Orphanage orphanage = orphanageDto.getOrphanage();
        MultipartFile[] imageFiles = orphanageDto.getImages();
        Orphanage entity = orphanageService.create(orphanage, imageFiles);
        return OrphanageResponseDto.parse(entity);
    }

    @GetMapping("/{id}")
    public OrphanageResponseDto show(@PathVariable Long id) {
        Orphanage entity = orphanageService.show(id);
        return OrphanageResponseDto.parse(entity);
    }

    @PutMapping("/{id}")
    public OrphanageResponseDto update(@PathVariable Long id, @RequestBody Orphanage orphanage) {
        Orphanage entity = orphanageService.update(id, orphanage);
        return OrphanageResponseDto.parse(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orphanageService.delete(id);
    }

}
