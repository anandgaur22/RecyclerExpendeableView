package com.anand.expandableView.network;

import com.anand.expandableView.model.pathologDetail.PathologyDetailsModel;
import com.anand.expandableView.model.pathologyList.PathologyListModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterfaces {

    @Headers("token: B7F1A2DF88AA42E2B0768ADF4CB34824U773-27")
    @FormUrlEncoded
    @POST("GetUserPathologyInvestigationList")
    Call<PathologyListModel> pathologyList(@Field("userId") String userId);


    @Headers("token: B7F1A2DF88AA42E2B0768ADF4CB34824U773-27")
    @FormUrlEncoded
    @POST("GetUserPathologyInvestigationDetail")
    Call<PathologyDetailsModel> pathologyDetail(@Field("userId") String userId,
                                                @Field("investigationMainId") Integer investigationMainId,
                                                @Field("billNo") String billNo,
                                                @Field("investigationDate") String investigationDate);


}
