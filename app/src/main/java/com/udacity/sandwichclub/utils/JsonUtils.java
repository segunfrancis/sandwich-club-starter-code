package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject object = new JSONObject(json);
            JSONObject name = object.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray aka = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < aka.length(); i++) {
                alsoKnownAs.add(aka.getString(i));
            }
            String placeOfOrigin = object.getString("placeOfOrigin");
            String description = object.getString("description");
            String image = object.getString("image");
            JSONArray ingredientsList = object.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsList.length(); i++) {
                ingredients.add(ingredientsList.getString(i));
            }
            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("JsonUtils", "Error: " + e.getLocalizedMessage());
        }
        return sandwich;
    }
}
