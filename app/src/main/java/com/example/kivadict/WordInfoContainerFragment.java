package com.example.kivadict;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WordInfoContainerFragment extends Fragment {

    WordInfoAdapter wordInfoAdapter;
    ViewPager2 viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.viewpager_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        WordWithGlosses entry = WordInfoContainerFragmentArgs.fromBundle(getArguments()).getWordWithGlosses();

        wordInfoAdapter = new WordInfoAdapter(this, entry);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(wordInfoAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: tab.setText("Word"); break;
                        case 1: tab.setText("Phrases"); break;
                    }
                }
        ).attach();

    }

}

