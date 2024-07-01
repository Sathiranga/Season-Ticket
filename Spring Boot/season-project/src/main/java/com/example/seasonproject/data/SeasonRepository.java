package com.example.seasonproject.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SeasonRepository extends JpaRepository<Season,Integer> {

}

