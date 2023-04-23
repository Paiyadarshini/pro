package com.ingroinfo.railway_reservation.services;

import java.util.List;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.NoOfStops;
import com.ingroinfo.railway_reservation.entity.TrainMaster;

public interface AdminService {
	
	//Save Train Master data
    TrainMaster saveTrainMaster(TrainMaster trainMaster);
    
    //Save AddTrain
    AddingTrains saveAddTrain(AddingTrains addingTrains);

    //Find All Master Train
	List<TrainMaster> findAllTrainMaster();

	//save No of Stops
	NoOfStops saveNoOfStops(NoOfStops noOfStops);

	//Find All No of Stops
	List<NoOfStops> findAllNoOfStops();

	//Get train master details by train id
	TrainMaster getTrainMasterDetailsByTrainId(Long trainId);

	
//delet master
	void deleteFromId(Long trainId);

	

	

	List<AddingTrains> findAllAddingTrains();


	
//delete no of stop
	void deleteFromtrainid(Long id);
//delete show train
	void deleteFromTrainId(Long trainId);

	//TrainMaster getTrainById(Long trainId);

//	TrainMaster getTrainMasterById(Long trainId);
//
//	void updateTrainMaster(TrainMaster trainMaster);
	
	
	
	
	
	
	

//update trainmaster	
	
//    TrainMaster getTrainMasterById(Long trainId);
//    
//	TrainMaster updateTrainMaster(TrainMaster trainMaster);
	


	
}
   