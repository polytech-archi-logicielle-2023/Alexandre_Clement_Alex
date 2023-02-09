package com.example.demo.repository;
import com.example.demo.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> { // using JpaRepository super class
}