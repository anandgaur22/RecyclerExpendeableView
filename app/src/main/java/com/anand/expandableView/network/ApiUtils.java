package com.anand.expandableView.network;

public class ApiUtils {

    private ApiUtils() {}

    /*
     * BaseUrl of this application
     * */

    public static final String BASE_URL = "http://182.156.200.178:206/userinvestigation.asmx/";

    public static RetrofitInterfaces getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(RetrofitInterfaces.class);
    }
}