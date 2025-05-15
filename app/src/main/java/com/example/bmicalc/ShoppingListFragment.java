package com.example.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

/**
 * Fragment wyświetlający listę zakupów z możliwością oznaczenia zakupu.
 */
public class ShoppingListFragment extends Fragment {

    /**
     * Tworzy i zwraca widok fragmentu.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        List<ShoppingItem> shoppingItems = Arrays.asList(
                new ShoppingItem("Quinoa"),
                new ShoppingItem("Papryka"),
                new ShoppingItem("Ogórek"),
                new ShoppingItem("Czosnek"),
                new ShoppingItem("Dynia")
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ShoppingListAdapter(shoppingItems));

        return view;
    }
}
