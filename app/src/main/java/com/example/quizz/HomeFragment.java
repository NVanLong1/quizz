package com.example.quizz;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizz.databinding.FragmentHomeBinding;
import com.example.quizz.my_interface.IClickCardListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    CardAdapter cardAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.homeRcv.setLayoutManager(new LinearLayoutManager(getContext()));

        cardAdapter = new CardAdapter(getCards(), new IClickCardListener() {
            @Override
            public void onClickCard(Card card) {

            }
        });
        binding.homeRcv.setAdapter(cardAdapter);

        return binding.getRoot();
    }

    private ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(R.drawable.img_math, "Math"));
        cards.add(new Card(R.drawable.img_chem, "Chemical"));
        cards.add(new Card(R.drawable.img_geography, "Geography"));
        cards.add(new Card(R.drawable.img_history, "History"));

        return cards;
    }
}

