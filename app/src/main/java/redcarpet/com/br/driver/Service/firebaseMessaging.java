package redcarpet.com.br.driver.Service;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import redcarpet.com.br.driver.Activities.CustommerCall;
import redcarpet.com.br.driver.Model.Pickup;

public class firebaseMessaging extends FirebaseMessagingService{
  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    if(remoteMessage.getNotification().getTitle().equals("Customer Pickup Request")){
      Pickup pickup=new Gson().fromJson(remoteMessage.getNotification().getBody(), Pickup.class);
      Intent intent=new Intent(getBaseContext(), CustommerCall.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      intent.putExtra("rider", pickup.getID());
      intent.putExtra("phone",pickup.getPhoneNumber());
      intent.putExtra("lat", pickup.getLastLocation().latitude);
      intent.putExtra("lng", pickup.getLastLocation().longitude);
      intent.putExtra("token", pickup.getToken().getToken());
      startActivity(intent);
    }
  }
}