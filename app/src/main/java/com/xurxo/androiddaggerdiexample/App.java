package com.xurxo.androiddaggerdiexample;

import dagger.ObjectGraph;


public class App extends android.app.Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new ApplicationDIModule());
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}