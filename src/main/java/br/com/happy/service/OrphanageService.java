package br.com.happy.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.happy.exception.ResourceNotFoundException;
import br.com.happy.model.Image;
import br.com.happy.model.Orphanage;
import br.com.happy.repository.OrphanageRepository;

@Service
public class OrphanageService {

    @Autowired
    private OrphanageRepository orphanageRepository;

    public List<Orphanage> index() {
        return orphanageRepository.findAll();
    }

    public Orphanage create(Orphanage orphanage) {
        Image image = new Image();
        image.setPath("path");
        image.setOrphanage(orphanage);

        orphanage.setImages(Collections.singletonList(image));
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
