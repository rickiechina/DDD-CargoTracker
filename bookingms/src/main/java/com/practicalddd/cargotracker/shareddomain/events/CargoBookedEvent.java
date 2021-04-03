package com.practicalddd.cargotracker.shareddomain.events;


/**
 * Event Class for the Cargo Booked Event. Wraps up the Cargo Booking identifier
 * for the event
 * 货物委托预订事件类，其中包含了货物委托预订ID
 */

public class CargoBookedEvent {
    private CargoBookedEventData cargoBookedEventData;
    public CargoBookedEvent(){}
    public CargoBookedEvent(CargoBookedEventData cargoBookedEventData){
        this.cargoBookedEventData  = cargoBookedEventData;
    }

    public CargoBookedEventData getCargoBookedEventData() {
        return cargoBookedEventData;
    }
}
