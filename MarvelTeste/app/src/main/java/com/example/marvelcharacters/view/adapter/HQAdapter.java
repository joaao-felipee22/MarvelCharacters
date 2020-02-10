package com.example.marvelcharacters.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelcharacters.R;
import com.example.marvelcharacters.model.pojo.hq.ResultHQ;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HQAdapter extends RecyclerView.Adapter<HQAdapter.ViewHolderHQ> {

    private List<ResultHQ> results;

    public HQAdapter(List<ResultHQ> listaResults) {
        this.results = listaResults;
    }

    @NonNull
    @Override
    public ViewHolderHQ onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler, parent,false);
        return new HQAdapter.ViewHolderHQ(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHQ holder, int position) {
        final ResultHQ result = results.get(position);
        holder.bind(result);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setUpdate(List<ResultHQ> results) {
        if (this.results.isEmpty()){
            this.results = results;
        }else {
            this.results.addAll(results);
        }
        notifyDataSetChanged();
    }


    public class ViewHolderHQ extends RecyclerView.ViewHolder {
        private ImageView imgHQ;
        private TextView txtTitle;

        public ViewHolderHQ(@NonNull View itemView) {
            super(itemView);
            imgHQ = itemView.findViewById(R.id.imgCharacter_card);
            txtTitle = itemView.findViewById(R.id.txt_card);
        }

        public void bind(ResultHQ result) {
            txtTitle.setText(result.getTitle());
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgHQ);
        }
    }
}
