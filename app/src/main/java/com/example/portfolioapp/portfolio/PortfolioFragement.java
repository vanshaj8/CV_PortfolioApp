package com.example.portfolioapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortfolioFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortfolioFragement extends Fragment
{

    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    ProtfolioAdapter protfolioAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PortfolioFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortfolioFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static PortfolioFragement newInstance(String param1, String param2) {
        PortfolioFragement fragment = new PortfolioFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_fragement, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio=view.findViewById(R.id.rv_portfolio);
        // Create a list of PortfolioItems
        mdata=new ArrayList<>();
        mdata.add(new PortfolioItem(R.drawable.one,"one"));
        mdata.add(new PortfolioItem(R.drawable.two,"Two"));
        mdata.add(new PortfolioItem(R.drawable.three,"three"));
        mdata.add(new PortfolioItem(R.drawable.four,"four"));
        mdata.add(new PortfolioItem(R.drawable.five,"Five"));
        mdata.add(new PortfolioItem(R.drawable.three,"SIX"));


        protfolioAdapter= new ProtfolioAdapter(mdata);
        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(protfolioAdapter);

    }
}