package edu.tamu.stmi.monopolysystem1;

/**
 * Created by chandu on 4/22/18.
 */

public class ResponseClass {

    String mortage="false";
    String houses = "4";
    String owner = "Player1";
    String responseText = "";


    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getHouses() {

        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    public String getMortage() {
        return mortage;
    }

    public void setMortage(String mortage) {
        this.mortage = mortage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
