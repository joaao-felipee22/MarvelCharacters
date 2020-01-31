package com.example.marvelcharacters.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelcharacters.R;
import com.example.marvelcharacters.model.pojo.Result;
import com.example.marvelcharacters.view.interfaces.ClickDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolderCharacter> {

    private List<Result> listaResults;
    private ClickDetail clickDetail;

    public CharactersAdapter(List<Result> listaResults, ClickDetail clickDetail) {
        this.listaResults = listaResults;
        this.clickDetail = clickDetail;
    }

    @NonNull
    @Override
    public CharactersAdapter.ViewHolderCharacter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler, parent,false);
        return new ViewHolderCharacter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.ViewHolderCharacter holder, int position) {
        final Result result = listaResults.get(position);
        holder.bind(result);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDetail.clickTransition(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaResults.size();
    }

    class ViewHolderCharacter extends RecyclerView.ViewHolder {
        private ImageView imgCharacter;
        private TextView txtNome;

        public ViewHolderCharacter(@NonNull View itemView) {
            super(itemView);
            imgCharacter = itemView.findViewById(R.id.imgCharacter);
            txtNome = itemView.findViewById(R.id.txtNome);
        }
        public void bind(Result result){
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgCharacter);
            txtNome.setText(result.getName());
        }

    }
}
