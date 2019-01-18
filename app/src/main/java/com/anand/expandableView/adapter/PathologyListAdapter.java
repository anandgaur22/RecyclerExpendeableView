package com.anand.expandableView.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anand.expandableView.R;
import com.anand.expandableView.model.pathologDetail.PathologyDetailsModel;
import com.anand.expandableView.model.pathologDetail.SubTestDetail;
import com.anand.expandableView.model.pathologyList.ResposnseValue;
import com.anand.expandableView.model.pathologyList.PathologyListModel;
import com.anand.expandableView.network.ApiUtils;
import com.anand.expandableView.network.RetrofitInterfaces;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PathologyListAdapter extends RecyclerView.Adapter<PathologyListAdapter.PathologyViewHolder> {

    private List<ResposnseValue> resposnseValueList;
    private List<SubTestDetail> subTestDetailList;
    private Context context;
    PathologyListModel listModel;
    ArrayList<Integer> counter = new ArrayList<Integer>();

    public PathologyListAdapter(List<ResposnseValue> response, Context context) {
        this.resposnseValueList = response;
        this.context = context;

        for (int i = 0; i < resposnseValueList.size(); i++) {
            counter.add(0);
        }

    }


    @NonNull
    @Override
    public PathologyListAdapter.PathologyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View resposnseValueList = LayoutInflater.from(parent.getContext()).inflate(R.layout.pathology_list_layout, parent, false);
        PathologyListAdapter.PathologyViewHolder pathologyViewHolder = new PathologyListAdapter.PathologyViewHolder(resposnseValueList);

        return pathologyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PathologyViewHolder holder, final int position) {


        holder.bill_no_name_txtView.setText(resposnseValueList.get(position).getBillNo());
        holder.date_txtView.setText(resposnseValueList.get(position).getInvestigationDate());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*Pathology Detail network call*/

                RetrofitInterfaces iRestInterfaces = ApiUtils.getAPIService();
                Call<PathologyDetailsModel> pathologyDetail = iRestInterfaces.pathologyDetail("63", resposnseValueList.get(position).getInvestigationMainId(), resposnseValueList.get(position).getBillNo(), resposnseValueList.get(position).getInvestigationDate());

                pathologyDetail.enqueue(new Callback<PathologyDetailsModel>() {
                    @Override
                    public void onResponse(Call<PathologyDetailsModel> call, Response<PathologyDetailsModel> response) {

                        assert response.body() != null;
                        if (response.isSuccessful()) {

                            String status = response.body().getResponseMessage();

                            if (status.equalsIgnoreCase("Success!")) {
                                if (counter.get(position) % 2 == 0) {
                                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                                    holder.up_arrow_imgView.setVisibility(View.GONE);
                                    holder.down_arrow_imgView.setVisibility(View.VISIBLE);
                                } else {
                                    holder.cardRecyclerView.setVisibility(View.GONE);
                                    holder.down_arrow_imgView.setVisibility(View.VISIBLE);
                                    holder.up_arrow_imgView.setVisibility(View.GONE);
                                }

                                counter.set(position, counter.get(position) + 1);

                                holder.cardRecyclerView.setLayoutManager(new LinearLayoutManager(context));
                                InnerAdapter innerAdapter = new InnerAdapter(response.body().getResposnseValue(), context);
                                holder.cardRecyclerView.setAdapter(innerAdapter);

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<PathologyDetailsModel> call, Throwable t) {
                    }
                });
            }
        });


    }


    @Override
    public int getItemCount() {
        return resposnseValueList.size();
    }


    public class PathologyViewHolder extends RecyclerView.ViewHolder {


        TextView bill_no_name_txtView, date_txtView;
        CardView cardView;
        @SuppressLint("StaticFieldLeak")
        public RecyclerView cardRecyclerView;
        ImageView down_arrow_imgView, up_arrow_imgView;


        public PathologyViewHolder(View view) {
            super(view);

            bill_no_name_txtView = view.findViewById(R.id.bill_no_name_txtView);
            date_txtView = view.findViewById(R.id.date_txtView);
            cardView = view.findViewById(R.id.cardView);
            cardRecyclerView = view.findViewById(R.id.innerRecyclerView);
            down_arrow_imgView = view.findViewById(R.id.down_arrow_imgView);
            up_arrow_imgView = view.findViewById(R.id.up_arrow_imgView);

        }
    }
}

