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
      colegios.add(new Colegio("https://sites.google.com/site/hitechtriana/_/rsrc/1391250643245/Home/IES%20TRIANA.jpg", "IES Triana", "ESO, Bachillerato y FP", "Calle San Jacinto, 79, 41010 Sevilla"));
      colegios.add(new Colegio("https://i1.wp.com/www.iespolitecnico.es/wp-content/uploads/2017/06/logo-ies-florituras.jpg?fit=300%2C212", "IES Politecnico", "Bachillerato y FP", "Calle Virgen de la Victoria, 50, 41011 Sevilla"));
      colegios.add(new Colegio("data:image/png;base64,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", "IES Nervion", "ESO, Bachillerato y FP", "Calle Prof. Buenaventura Pinillos, 2, 41005 Sevilla"));

      adapter = new MyColegioRecyclerViewAdapter(
        ctx,
        R.layout.fragment_colegio,
        colegios,
        mListener
      );

      recyclerView.setAdapter(adapter);
      //recyclerView.setAdapter(new MyColegioRecyclerViewAdapter(getActivity(), DummyContent.ITEMS, mListener));
    }
    return view;
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.ctx = context;
    if (context instanceof ColegiosInteractionListener) {
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
