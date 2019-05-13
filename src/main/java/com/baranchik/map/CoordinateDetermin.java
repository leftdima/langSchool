package com.baranchik.map;

import com.baranchik.model.Address;

import java.net.MalformedURLException;
import java.net.URL;

import io.restassured.response.Response;

import org.json.*;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.get;

@Component
public class CoordinateDetermin {
    public static boolean setCoordinates(Address address) throws MalformedURLException {

        String addressAsString = address.getHouse() + " Улица " + address.getStreet() + " " + address.getLocality();

        URL url = new URL("https://nominatim.openstreetmap.org/search?q="
                + addressAsString +
                "&format=geocodejson&limit=1");

        Response res = get(url);

        JSONObject obj = new JSONObject(res.asString());

        if (obj.getJSONArray("features").isNull(0)) {
            System.out.println("Нет такого места");
            return false;
        }

        JSONArray JSONcoords = obj
                .getJSONArray("features")
                .getJSONObject(0)
                .getJSONObject("geometry")
                .getJSONArray("coordinates");

        address.setLatitude(JSONcoords.getDouble(1));
        address.setLongitude(JSONcoords.getDouble(0));

        System.out.println(address.getLatitude() + " " + address.getLongitude());

        return true;
    }
}
