package com.example.demo.repository;
import com.example.demo.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Integer> { // using JpaRepository super class
}