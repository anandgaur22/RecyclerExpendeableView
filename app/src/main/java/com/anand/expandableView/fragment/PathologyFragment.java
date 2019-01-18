package com.anand.expandableView.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anand.expandableView.R;
import com.anand.expandableView.adapter.InnerAdapter;
import com.anand.expandableView.adapter.PathologyListAdapter;
import com.anand.expandableView.model.pathologDetail.PathologyDetailsModel;
import com.anand.expandableView.model.pathologyList.PathologyListModel;
import com.anand.expandableView.network.ApiUtils;
import com.anand.expandableView.network.RetrofitInterfaces;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PathologyFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View rootView;

    PathologyListAdapter pathologyListAdapter;
    RecyclerView recycler_view;
    ProgressDialog progressDialog;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PathologyFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PathologyFragment newInstance(String param1, String param2) {
        PathologyFragment fragment = new PathologyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_pathology, container, false);

        recycler_view = rootView.findViewById(R.id.recycler_view);

        recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        progressDialog = new ProgressDialog(getContext());

        Pathology_List_network_call();


        return rootView;
    }

    /*Pathology list network call*/

    public void Pathology_List_network_call(){

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RetrofitInterfaces iRestInterfaces = ApiUtils.getAPIService();
        Call<PathologyListModel> listModelCall = iRestInterfaces.pathologyList("63");

        listModelCall.enqueue(new Callback<PathologyListModel>() {
            @Override
            public void onResponse(Call<PathologyListModel> call, final Response<PathologyListModel> response) {

                assert response.body() != null;
                if (response.isSuccessful()) {

                    String status=response.body().getResponseMessage();



                    if (status.equalsIgnoreCase("Success!")){


                        progressDialog.dismiss();

                        String PathologyName=response.body().getResposnseValue().get(0).getPathologyName();
                        String BillNo=response.body().getResposnseValue().get(0).getBillNo();
                        String InvestigationDate=response.body().getResposnseValue().get(0).getInvestigationDate();
                        Integer InvestigationMainId=response.body().getResposnseValue().get(0).getInvestigationMainId();
                        Integer InvestigationType=response.body().getResposnseValue().get(0).getInvestigationType();


                        pathologyListAdapter = new PathologyListAdapter(response.body().getResposnseValue(), getContext());
                        recycler_view.setAdapter(pathologyListAdapter);

                    }

                }
            }

            @Override
            public void onFailure(Call<PathologyListModel> call, Throwable t) {
                progressDialog.dismiss();
                //Toast.makeText(LoginActivity.this, "Server Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
