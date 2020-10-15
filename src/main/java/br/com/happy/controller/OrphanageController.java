package br.com.happy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.happy.model.Orphanage;
import br.com.happy.service.OrphanageService;

@RestController
@RequestMapping("/orphanages")
public class OrphanageController {

    @Autowired
    private OrphanageService orphanageService;

    @GetMapping
    public List<Orphanage> index() {
        return orphanageService.index();
    }

    @PostMapping
    public Orphanage create(@RequestBody Orphanage orphanage) {
        return orphanageService.create(orphanage);
    }

    @GetMapping("/{id}")
    public Orphanage show(@PathVariable Long id) {
        return orphanageService.show(id);
    }

    @PutMapping("/{id}")
    public Orphanage update(@PathVariable Long id, @RequestBody Orphanage orphanage) {
        return orphanageService.update(id, orphanage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orphanageService.delete(id);
    }

}
