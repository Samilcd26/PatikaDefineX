package com.Hafta1.Hafta1Uygulama.repository;

import java.util.List;

import com.Hafta1.Hafta1Uygulama.model.Entities;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EntityRepository extends JpaRepository<Entities, Long> {


    List<Entities> findByTypeContaining(String type);
}
