package com.example.kivadict;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.kivadict.WordListFragmentDirections.actionWordListFragmentToWordDetailFragment2;

public class WordListFragment extends Fragment implements OnItemClickListener {

    private WordListAdapter adapter;
    private MenuItem searchItem;
    private WordViewModel wordViewModel;
    private RecyclerView recyclerView;

    public WordListFragment() {

        super(R.layout.words_fragment);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.words_fragment, container, false);

        recyclerView = parentView.findViewById(R.id.word_list);
        adapter = new WordListAdapter(new WordListAdapter.WordDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));


        return parentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        wordViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication()))
                .get(WordViewModel.class);
        wordViewModel.wordList.observe(getViewLifecycleOwner(), adapter::submitList);

        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_word_list_fragment, menu);

        searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.trim().length() > 0) {
                    recyclerView.setVisibility(View.VISIBLE);
                    wordViewModel.searchQuery.setValue(newText);
                } else {
                    recyclerView.setVisibility(View.GONE);
                }
                return true;
            }
        });

    }

    @Override
    public void onItemClick(WordWithGlosses entry) {

        NavDirections action = WordListFragmentDirections.actionWordListFragmentToWordDetailFragment2(entry);
        NavHostFragment.findNavController(this).navigate(action);

    }
}



