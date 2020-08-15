package edu.tamu.stmi.monopolysystem1;

/**
 * Created by chandu on 4/21/18.
 */

public class PropertyClass {

    private String propertyName;
    private String propertyColor;
    private String propertyOwner;
    private int housesBuilt;
    private Boolean hotelPresent;
    private Boolean mortagedPresent;

    PropertyClass(String name, String colorGroup, String owner, int houses, boolean hotel,boolean mortage){
        propertyName = name;//get
        propertyColor= colorGroup;//get
        propertyOwner = owner;//set and get
        housesBuilt = houses;//set, get, increment
        hotelPresent = hotel;//set and get
        mortagedPresent = mortage;//set and get
    }

    String getName(){
        return(propertyName);
    }

    String getPropertyColor(){
        return(propertyColor);
    }

    void setPropertyOwner(String owner){
        propertyOwner = owner;
    }

    String getPropertyOwner(){
        return(propertyOwner);
    }
    void setHousesBuilt(int houses){
        housesBuilt = houses;
    }

    int getHousesBuilt(){
        return housesBuilt;
    }

    void setHotelBuilt(){
        hotelPresent = true;
    }

    Boolean isHotelPresent(){
        return hotelPresent;
    }

    Boolean isPropertyMortaged(){
        return(mortagedPresent);
    }

    void setMortage(Boolean mortaged){
        mortagedPresent = mortaged;
    }
}
