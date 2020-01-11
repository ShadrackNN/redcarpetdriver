package redcarpet.com.br.driver.Interfaces;

import redcarpet.com.br.driver.Model.FCMResponse;
import redcarpet.com.br.driver.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
  @Headers({
          "Content-Type:application/json",
          "Authorization:key=AAAAxH2z2s4:APA91bFwCm94OsM1fGeDQnb-XdNHFe8HzrmJPJXSJHNyryTpBfh9Ylq5qIWBZv1f1iL_Hro73yQIT7744y23n0xnnV4jTyb8K_idFRbIBeQ6wNYfhDZDxhubVnopNSlSNTDBeKyCk60h"
  })
  @POST("fcm/send")
  Call<FCMResponse> sendMessage(@Body Sender body);
}