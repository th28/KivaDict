package com.example.kivadict;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.Serializable;

public class WordInfoAdapter extends FragmentStateAdapter {

    private WordWithGlosses entry;

    public WordInfoAdapter(Fragment fragment, WordWithGlosses entry) {
        super(fragment);
        this.entry = entry;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return getTabFragment(new WordDetailFragment(), WordDetailFragment.ENTRY_KEY, entry);
        } else {
            return getTabFragment(new WordExamplePhraseFragment(), WordExamplePhraseFragment.ENTRY_KEY, entry);
        }

    }

    public Fragment getTabFragment(Fragment tabFragment, String key, Serializable infoObj){
        Fragment fragment =  tabFragment;
        Bundle args = new Bundle();
        args.putSerializable(key, infoObj);
        fragment.setArguments(args);
        return fragment;

    }



    @Override
    public int getItemCount() {
        return 2;
    }
}
