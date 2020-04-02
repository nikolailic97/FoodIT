package com.example.foodit.Remote;

import com.example.foodit.Model.MyResponse;
import com.example.foodit.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAqI39QPo:APA91bGwYBFTCxH2P6ui-VZmeOD-rbSE4GNuY_7Z0in6QVCebkb5ux1MYYzbgffhUmx7TpiZXdzG-0Uylt5TesNeyBZ2X-5XzZpvg8zKyzLaleWq1sGDlAA3FKBcLJ2_3DpuoLjvywJo"
            }
    )

    @POST("fcm/send")
   Call<MyResponse> sendNotification(@Body Sender body);
}
