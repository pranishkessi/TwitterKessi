package com.si.twitterkessi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.si.twitterkessi.R;
import com.si.twitterkessi.model.ModelDataSet;

import java.util.List;

public class InterestListAdapter extends RecyclerView.Adapter<InterestListAdapter.InterestName> {

    Context context;
    List<ModelDataSet> dataSetList;

    public InterestListAdapter(Context context, List<ModelDataSet> dataSetList) {
        this.context = context;
        this.dataSetList = dataSetList;
    }

    @NonNull
    @Override
    public InterestName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.intrest_list, parent, false );
        return new InterestName( view );
    }

    @Override
    public void onBindViewHolder(@NonNull InterestName holder, final int position) {

        ModelDataSet dataSet = dataSetList.get( position );


        holder.txname.setText( dataSet.getName() );
        holder.btn_rv_a.setText( dataSet.getName1() );
        holder.btn_rv_b.setText( dataSet.getName2() );
        holder.btn_rv_c.setText( dataSet.getName3() );
        holder.btn_rv_d.setText( dataSet.getName4() );
    }

    @Override
    public int getItemCount() {
        return dataSetList.size();
    }

    public class InterestName extends RecyclerView.ViewHolder {

        TextView txname;
        Button btn_rv_a, btn_rv_b, btn_rv_c, btn_rv_d, btn_rv_e;

        public InterestName(@NonNull View itemView) {
            super( itemView );
            btn_rv_a = itemView.findViewById( R.id.btn_RV_a );
            btn_rv_b = itemView.findViewById( R.id.btn_RV_b );
            btn_rv_c = itemView.findViewById( R.id.btn_RV_c );
            btn_rv_d = itemView.findViewById( R.id.btn_RV_d );

            txname = itemView.findViewById( R.id.RV_Name );
        }
    }
}
