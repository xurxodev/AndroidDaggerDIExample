package com.xurxo.androiddaggerdiexample;

import java.util.List;

public interface RestCountriesClient {
    public void Get(ResponseHandler<List<Country>> handler);
}
