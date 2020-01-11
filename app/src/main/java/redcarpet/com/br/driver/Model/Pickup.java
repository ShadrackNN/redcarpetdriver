package redcarpet.com.br.driver.Model;

import com.google.android.gms.maps.model.LatLng;

public class Pickup {
    LatLng lastLocation;
    String ID;
    Token token;
    String phoneNumber;

    public Pickup() {
    }

    public Pickup(LatLng lastLocation, String ID, Token token, String phone) {
        this.lastLocation = lastLocation;
        this.ID = ID;
        this.token = token;
        this.phoneNumber =phone;
    }

    public LatLng getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(LatLng lastLocation) {
        this.lastLocation = lastLocation;
    }

    public String getID() {
        return ID;
    }

    public String getPhoneNumber(){ return phoneNumber;}

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}