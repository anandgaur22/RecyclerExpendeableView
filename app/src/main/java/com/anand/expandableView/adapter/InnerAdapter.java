package com.anand.expandableView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anand.expandableView.R;
import com.anand.expandableView.model.pathologDetail.ResposnseValue;

import java.util.List;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerViewHolder> {

    private List<ResposnseValue> resposnseValueList;
    ;
    private Context context;

    public InnerAdapter(List<ResposnseValue> resposnseValueList, Context context) {
        this.resposnseValueList = resposnseValueList;
        this.context = context;

    }


    @NonNull
    @Override
    public InnerAdapter.InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View resposnseValueList = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_layout, parent, false);
        InnerAdapter.InnerViewHolder innerViewHolder = new InnerAdapter.InnerViewHolder(resposnseValueList);

        return innerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerAdapter.InnerViewHolder holder, int position) {


        holder.test_name_txtView.setText(resposnseValueList.get(position).getTestName());

        for (int i = 0; i < resposnseValueList.get(position).getSubTestDetail().size(); i++) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View rowItem = inflater.inflate(R.layout.sub_inner_items_layout, null, false);
            TextView sub_text_name = rowItem.findViewById(R.id.sub_text_name_txtView);
            TextView test_value = rowItem.findViewById(R.id.test_value_txtView);
            TextView range = rowItem.findViewById(R.id.range_txtView);

            String unit=resposnseValueList.get(position).getSubTestDetail().get(i).getUnit();

            sub_text_name.setText(resposnseValueList.get(position).getSubTestDetail().get(i).getSubTestName());
            test_value.setText(resposnseValueList.get(position).getSubTestDetail().get(i).getSubTestValue()+" "+unit);
            range.setText(resposnseValueList.get(position).getSubTestDetail().get(i).getNormalRange());
            holder.sub_item_ll.addView(rowItem);



        }

    }


    @Override
    public int getItemCount() {
        return resposnseValueList.size();
    }


    public class InnerViewHolder extends RecyclerView.ViewHolder {


        TextView test_name_txtView;
        LinearLayout sub_item_ll;


        public InnerViewHolder(View view) {
            super(view);

            test_name_txtView = view.findViewById(R.id.test_name_txtView);
            sub_item_ll = view.findViewById(R.id.sub_item_ll);
        }
    }
}

