package br.com.happy.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.happy.exception.ResourceNotFoundException;
import br.com.happy.model.Image;
import br.com.happy.model.Orphanage;
import br.com.happy.repository.OrphanageRepository;

@Service
public class OrphanageService {

    @Autowired
    private OrphanageRepository orphanageRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public List<Orphanage> index() {
        return orphanageRepository.findAll();
    }

    public Orphanage create(Orphanage orphanage, MultipartFile[] imageFiles) {

        List<Image> images = Arrays.asList(imageFiles).stream().map(file -> {
            String filename = fileStorageService.storeFile(file);

            return new Image(filename, orphanage);
        }).collect(Collectors.toList());

        orphanage.setImages(images);

        return orphanageRepository.save(orphanage);
    }

    public Orphanage show(Long id) {
        Orphanage orphanage = orphanageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return orphanage;
    }

    public Orphanage update(Long id, Orphanage orphanage) {
        Orphanage entity = orphanageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        entity.setAbout(orphanage.getAbout());
        entity.setInstructions(orphanage.getInstructions());
        entity.setName(orphanage.getName());
        entity.setLatitude(orphanage.getLatitude());
        entity.setLongitude(orphanage.getLongitude());
        entity.setOpenOnWeekends(orphanage.getOpenOnWeekends());
        entity.setOpeningHours(orphanage.getOpeningHours());

        return orphanageRepository.save(entity);

    }

    public void delete(Long id) {
        Orphanage orphanage = orphanageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        orphanageRepository.delete(orphanage);
    }
}
