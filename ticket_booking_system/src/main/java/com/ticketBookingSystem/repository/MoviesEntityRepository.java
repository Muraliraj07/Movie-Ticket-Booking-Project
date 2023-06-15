package com.ticketBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketBookingSystem.entity.MoviesEntity;

public interface MoviesEntityRepository extends JpaRepository<MoviesEntity,Integer> {

}
