package com.xurxo.androiddaggerdiexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {

    //RestCountriesClient restCountriesClient = new DefaultRestCountriesClient();

    @Inject
    RestCountriesClient restCountriesClient;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries_main);

        context = getApplicationContext();

        final List<Country> countries= new ArrayList<Country>();

        final CountryItemAdapter adapter = new CountryItemAdapter(this,countries);

        ListView gridView = (ListView) findViewById(R.id.countriesList);
        gridView.setAdapter(adapter);

        restCountriesClient.Get(new ResponseHandler<List<Country>>(){
            @Override
            public void onFailure(String ErrorMessage) {
                Toast.makeText(context,ErrorMessage, Toast.LENGTH_SHORT);
            }

            @Override
            public void onResponse(final List<Country> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Country country:response){
                            countries.add(country);
                        }

                        adapter.notifyDataSetChanged();
                    }
                });

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
