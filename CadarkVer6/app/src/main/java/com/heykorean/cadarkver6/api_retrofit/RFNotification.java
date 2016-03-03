package com.heykorean.cadarkver6.api_retrofit;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.heykorean.cadarkver6.app.RFApplication;
import com.heykorean.cadarkver6.models.CarListHome;
import com.heykorean.cadarkver6.models.NotificaionList;

import java.util.ArrayList;

import retrofit.Call;

/**
 * Created by SonNV1368 on 10/22/15.
 */
public class RFNotification {

    //get contacts
        public static ArrayList<NotificaionList> getNotificationList() {
        ArrayList<NotificaionList> arrayList = new ArrayList<NotificaionList>();
        Call<JsonElement> call = RFApplication.apiServices.getNotifications();

        try {
            JsonElement jsonElement = (JsonElement) call.execute().body();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.getAsJsonArray("notification_user_bid");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject objectContact = jsonArray.get(i).getAsJsonObject();
                String url_image = objectContact.get("url_image").getAsString();
                String name_car = objectContact.get("name_car").getAsString();
                String time_notice = objectContact.get("time_notice").getAsString();

                NotificaionList notificationList = new NotificaionList(url_image, name_car, time_notice);

                arrayList.add(notificationList);
            }
        } catch (Exception e) {
            Log.e("Error", "Parser: " + e.getMessage().toString());
        }

        return arrayList;
    }
}
