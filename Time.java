package com.railway_management_system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sajee Thamanga
 */
public class Time {
    private String TimeSlotID;
    private String TrainID;
    private String RouteID;
    private Time Arrival;
    private Time Departure;

//    public Time(String TimeSlotID, String TrainID, String RouteID, Time Arrival, Time Departure) {
//        this.TimeSlotID = TimeSlotID;
//        this.TrainID = TrainID;
//        this.RouteID = RouteID;
//        this.Arrival = Arrival;
//        this.Departure = Departure;
//    }

    public String getTimeSlotID() {
        return TimeSlotID;
    }

    public void setTimeSlotID(String TimeSlotID) {
        this.TimeSlotID = TimeSlotID;
    }

    public String getTrainID() {
        return TrainID;
    }

    public void setTrainID(String TrainID) {
        this.TrainID = TrainID;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String RouteID) {
        this.RouteID = RouteID;
    }

    public Time getArrival() {
        return Arrival;
    }

    public void setArrival(Time Arrival) {
        this.Arrival = Arrival;
    }

    public Time getDeparture() {
        return Departure;
    }

    public void setDeparture(Time Departure) {
        this.Departure = Departure;
    }
    
    
}
