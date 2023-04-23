package com.ingroinfo.railway_reservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.TrainMaster;
@Repository
public interface TrainMasterRepository extends JpaRepository<TrainMaster,Long> {


}
