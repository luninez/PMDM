package com.example.lbenitez.schoolapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbenitez.schoolapp.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

public class ColegioFragment extends Fragment {

  // TODO: Customize parameter argument names
  private static final String ARG_COLUMN_COUNT = "column-count";
  // TODO: Customize parameters
  private int mColumnCount = 1;
  private ColegiosInteractionListener mListener;
  MyColegioRecyclerViewAdapter adapter;
  Context ctx;
  List<Colegio> colegios;

  public ColegioFragment() { }

  // TODO: Customize parameter initialization
  @SuppressWarnings("unused")
  public static ColegioFragment newInstance(int columnCount) {
    ColegioFragment fragment = new ColegioFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_COLUMN_COUNT, columnCount);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getArguments() != null) {
      mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_colegio_list, container, false);

    // Set the adapter
    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      RecyclerView recyclerView = (RecyclerView) view;
      if (mColumnCount <= 1) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
      } else {
        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
      }

      colegios = new ArrayList<>();
      colegios.add(new Colegio("", "IES Triana", "ESO, Bachillerato y FP", "C/San Jacinto"));
      colegios.add(new Colegio("", "IES Politecnico", "Bachillerato y FP", "C/ Virgen de la Victoria"));
      colegios.add(new Colegio("", "IES Nervion", "ESO, Bachillerato y FP", "C/ Prof. Buenaventura Pinillos"));

      adapter = new MyColegioRecyclerViewAdapter(
        ctx,
        R.layout.fragment_colegio,
        colegios,
        mListener
      );

      //recyclerView.setAdapter(new MyColegioRecyclerViewAdapter(getActivity(), DummyContent.ITEMS, mListener));
    }
    return view;
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.ctx = context;
    if (context instanceof OnListFragmentInteractionListener) {
      mListener = (ColegiosInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
        + " must implement OnListFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }


}
