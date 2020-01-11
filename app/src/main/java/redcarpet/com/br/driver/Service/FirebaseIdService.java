package redcarpet.com.br.driver.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

import redcarpet.com.br.driver.Common.Common;
import redcarpet.com.br.driver.Model.Token;

public class FirebaseIdService extends FirebaseMessagingService {
  @Override
  public void onNewToken(String refreshedToken) {
    super.onNewToken(refreshedToken);
    updateTokenToServer(refreshedToken);
    Log.e("NEW_TOKEN",refreshedToken);

  }
  public void updateTokenToServer(String refreshedToken) {
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference tokens =db.getReference(Common.token_tbl);

    Token token =new Token(refreshedToken);
    if(FirebaseAuth.getInstance().getCurrentUser()!=null)tokens.child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid())).setValue(token);
  }

  @Override
  public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    super.onMessageReceived(remoteMessage);
  }
}

/*
public class FirebaseIdService extends FirebaseInstanceIdService {
  @Override
  public void onTokenRefresh() {
    super.onTokenRefresh();
    String refreshedToken= FirebaseInstanceId.getInstance().getToken();
    updateTokenToServer(refreshedToken);
  }

  private void updateTokenToServer(String refreshedToken) {
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference tokens=db.getReference(Common.token_tbl);

    Token token=new Token(refreshedToken);
    if (FirebaseAuth.getInstance().getCurrentUser()!=null)tokens.child(FirebaseAuth.getInstance().getUid())
            .setValue(token);
  }
}
*/