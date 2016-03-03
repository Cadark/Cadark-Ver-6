package com.heykorean.cadarkver6.api_retrofit;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.heykorean.cadarkver6.app.RFApplication;
import com.heykorean.cadarkver6.models.CarListHome;

import java.util.ArrayList;

import retrofit.Call;

/**
 * Created by SonNV1368 on 10/22/15.
 */
public class RFApi {

    //get contacts
    public static ArrayList<CarListHome> getContact() {
        ArrayList<CarListHome> arrayList = new ArrayList<CarListHome>();
        Call<JsonElement> call = RFApplication.apiServices.getContacts();

        try {
            JsonElement jsonElement = (JsonElement) call.execute().body();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.getAsJsonArray("listCar");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject objectContact = jsonArray.get(i).getAsJsonObject();
                String id_car = objectContact.get("id_car").getAsString();
                String name_car = objectContact.get("name_car").getAsString();
                String time_remain = objectContact.get("time_remain").getAsString();
                String url_image = objectContact.get("url_image").getAsString();
                String mileage = objectContact.get("mileage").getAsString();
                String year = objectContact.get("year").getAsString();
                String area = objectContact.get("area").getAsString();

                CarListHome carListHome = new CarListHome(Integer.parseInt(id_car), name_car, time_remain, url_image, year, mileage, area);

                arrayList.add(carListHome);
            }

            Log.d("array", "array " + arrayList.size());
        } catch (Exception e) {
            Log.e("Error", "Parser: " + e.getMessage().toString());
        }

        return arrayList;
    }
}
