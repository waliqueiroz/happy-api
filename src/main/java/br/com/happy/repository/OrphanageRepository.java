package br.com.happy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.happy.model.Orphanage;

@Repository
public interface OrphanageRepository extends JpaRepository<Orphanage, Long> {

}
