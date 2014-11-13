package com.xurxo.androiddaggerdiexample;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DefaultRestCountriesClient implements RestCountriesClient{

    private final OkHttpClient client = new OkHttpClient();

    public void Get(final ResponseHandler<List<Country>> handler) {
        //para banderas
        //http://www.geonames.org/flags/x/vn.gif

        Request request = new Request.Builder()
                .url("http://restcountries.eu/rest/v1/all")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (handler != null)
                    handler.onFailure(e.getMessage());
            }

            @Override public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                if (handler != null)
                {
                    Gson gson = new Gson();
                    Country[] countries = gson.fromJson(response.body().string(), Country[].class);

                    handler.onResponse(Arrays.asList(countries));
                }
            }
        });
    }
}
