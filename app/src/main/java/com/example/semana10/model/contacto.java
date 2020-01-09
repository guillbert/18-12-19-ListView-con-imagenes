package com.example.semana10.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.semana10.MainActivity;
import com.example.semana10.helpers.QueueUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class contacto {

    public String phone;
    public String nickname;
    public String image;

    public String getSmallImage(){
        return this.image;
    }

    public contacto(String _phone, String _nickname, String _image) {

        this.image = _image;
        this.phone = _phone;
        this.nickname = _nickname;
    }

    public static ArrayList getCollection() {
        ArrayList<contacto> collection = new ArrayList<>();
        collection.add(new contacto("981999923", "Bichito",""));
        collection.add(new contacto("9859913923", "Plaga",""));
        collection.add(new contacto("981914213", "Libelula",""));
        return collection;
    }


    public static void injectContactsFromCloud(final QueueUtils.QueueObject o,
                                               final ArrayList<contacto> contactos,
                                               final MainActivity _interface) {
        String url = "http://fipo.equisd.com/api/users.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("objects")) {

                            try {
                                JSONArray list = response.getJSONArray("objects");
                                for (int i=0; i < list.length(); i++) {
                                    JSONObject o = list.getJSONObject(i);
                                    contactos.add(new contacto(o.getString("first_name"),
                                            o.getString("last_name"),""));
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            _interface.refreshList(); // Esta función debemos implementarla
                            // en nuestro activity
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        o.addToRequestQueue(jsonObjectRequest);
    }
}

