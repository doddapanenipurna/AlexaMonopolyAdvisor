package edu.tamu.stmi.monopolysystem1;


public class RequestClass {
    int requestedPropertyIndex;
    String gameName;
    String houses;
    String owner;
    Boolean mortage;

    public RequestClass(String phouses, String powner, Boolean pmortage, String pgameName,int prequestedPropertyIndex){
        this.houses = phouses;
        this.owner = powner;
        this.mortage = pmortage;
        this.gameName = pgameName;
        this.requestedPropertyIndex = prequestedPropertyIndex;
    }

    public RequestClass(int index, String gameId) {
        this.requestedPropertyIndex = index;
        this.gameName=gameId;
    }

}