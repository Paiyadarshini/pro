package com.ingroinfo.railway_reservation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.NoOfStops;
import com.ingroinfo.railway_reservation.entity.TrainMaster;
import com.ingroinfo.railway_reservation.repository.AddingTrainsRepository;
import com.ingroinfo.railway_reservation.repository.NoOfStopsRepository;
import com.ingroinfo.railway_reservation.repository.TrainMasterRepository;
import com.ingroinfo.railway_reservation.services.AdminService;

import net.bytebuddy.asm.Advice.This;


@Service
public class AdminServiceImpl implements AdminService {

@Autowired
private AddingTrainsRepository addingTrainsRepository;
@Autowired
private TrainMasterRepository trainMasterRepository;
@Autowired
private NoOfStopsRepository noOfStopsRepository;

	@Override
	public TrainMaster saveTrainMaster(TrainMaster trainMaster) {
	TrainMaster savedTrain= this.trainMasterRepository.save(trainMaster);
		return savedTrain;
	}
	
	//Save AddTrain
	
	@Override
	public AddingTrains saveAddTrain(AddingTrains addingTrains) {
	AddingTrains savedAddingTrains=this.addingTrainsRepository.save(addingTrains);
	return savedAddingTrains;
	}

	@Override
	public List<TrainMaster> findAllTrainMaster() {
		return this.trainMasterRepository.findAll();
	}
	

	@Override
	public NoOfStops saveNoOfStops(NoOfStops noOfStops) {
		NoOfStops savedNoOfStops = this.noOfStopsRepository.save(noOfStops);
		return savedNoOfStops;
	}

	@Override
	public List<NoOfStops> findAllNoOfStops() {
		return this.noOfStopsRepository.findAll();
	}

	@Override
	public TrainMaster getTrainMasterDetailsByTrainId(Long trainId) {
		TrainMaster trainmaster= this.trainMasterRepository.findById(trainId).get();
		return trainmaster ;
	}

	//train delete
	@Override
	public void deleteFromId(Long trainId) {
		TrainMaster deleteTrainmaster= this.trainMasterRepository.findById(trainId).get();
	 this.trainMasterRepository.delete(deleteTrainmaster);
		
	}


	@Override
	public List<AddingTrains> findAllAddingTrains() {
		return this.addingTrainsRepository.findAll();
	
	}

	@Override
	//delete no of stops
	public void deleteFromtrainid(Long id) {
		NoOfStops deleteNoOfStops= this.noOfStopsRepository.findById(id).get();
		 this.noOfStopsRepository.delete(deleteNoOfStops);
		
	}

	@Override
	public void deleteFromTrainId(Long trainId) {
		AddingTrains deleteAddingTrains= this.addingTrainsRepository.findById(trainId).get();
		 this.addingTrainsRepository.delete(deleteAddingTrains);
		
	}
}
	
	
	
	
	
	
	
//
//	@Override
//	public TrainMaster getTrainMasterById(Long trainId) {
//		return trainMasterRepository.findById(trainId).orElse(null);
//		
//	}

	/*
	 * @Override public void updateTrainMaster(TrainMaster trainMaster) {
	 * trainMasterRepository.save(trainMaster);
	 * 
	 * }
	 */
//	@Override
//	public void updateTrainMaster(Long trainId) {
//		AddingTrains addingTrains =this.addingTrainsRepository.findById(trainId);
//	}
//	@Override
//	public TrainMaster getTrainMasterById(Long trainId) {
//	    return trainMasterRepository.findById(trainId).get();
//		
//	}
//
//	@Override
//	public TrainMaster updateTrainMaster(TrainMaster trainMaster) {
//		
//		return trainMasterRepository.save(trainMaster);
//	}