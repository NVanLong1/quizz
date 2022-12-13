package com.example.quizz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizz.my_interface.IClickCardListener;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<Card> cards;
    private IClickCardListener iClickCardListener;

    public CardAdapter(ArrayList<Card> cards, IClickCardListener listener) {
        this.cards = cards;
        this.iClickCardListener = listener;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.CardViewHolder holder, int position) {
        final Card card = cards.get(position);
        holder.name.setText(card.getName());
        holder.img.setImageResource(card.getImg());

        holder.card_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickCardListener.onClickCard(card);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView card_layout;
        TextView name;
        ImageView img;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            card_layout = itemView.findViewById(R.id.card_layout);
            name = itemView.findViewById(R.id.card_name);
            img = itemView.findViewById(R.id.card_img);
        }
    }
}
