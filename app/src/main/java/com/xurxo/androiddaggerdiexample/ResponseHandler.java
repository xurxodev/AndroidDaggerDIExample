package com.xurxo.androiddaggerdiexample;

import java.util.List;

/**
 * Created by xurxo on 06/11/2014.
 */
public interface ResponseHandler <T>{
    public void onFailure(String ErrorMessage);
    public void onResponse(T response);
}
