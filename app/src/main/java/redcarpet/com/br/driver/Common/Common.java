package redcarpet.com.br.driver.Common;

import redcarpet.com.br.driver.Interfaces.IFCMService;
import redcarpet.com.br.driver.Interfaces.googleAPIInterface;
import redcarpet.com.br.driver.Model.User;
import redcarpet.com.br.driver.Retrofit.FCMClient;
import redcarpet.com.br.driver.Retrofit.RetrofitClient;

public class Common {
    public static final String driver_tbl="DriversOnline";
    public static final String user_driver_tbl="DriversInformation";
    public static final String history_driver = "DriverHistory";
    public static final String history_rider = "RiderHistory";
    public static final String user_rider_tbl="RidersInformation";
    public static final String pickup_request_tbl="PickupRequest";
    public static final String token_tbl="Tokens";
    public static User currentUser;
    public static String userID;
    public static final int PICK_IMAGE_REQUEST = 9999;

    public static Double currentLat;
    public static Double currentLng;

    public static final String baseURL="https://maps.googleapis.com";
    public static final String fcmURL="https://fcm.googleapis.com/";

    public static double baseFare=2.55;
    private static double timeRate=0.35;
    private static double distanceRate=1.75;

    public static double formulaPrice(double km, double min){
        return baseFare+(distanceRate*km)+(timeRate*min);
    }
    public static googleAPIInterface getGoogleAPI(){
        return RetrofitClient.getClient(baseURL).create(googleAPIInterface.class);
    }
    public static IFCMService getFCMService(){
        return FCMClient.getClient(fcmURL).create(IFCMService.class);
    }
}