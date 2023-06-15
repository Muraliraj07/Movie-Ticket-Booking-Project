package com.ticketBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketBookingSystem.entity.TheaterListEntity;

public interface TheaterListRepository extends JpaRepository<TheaterListEntity, Integer> {

}
