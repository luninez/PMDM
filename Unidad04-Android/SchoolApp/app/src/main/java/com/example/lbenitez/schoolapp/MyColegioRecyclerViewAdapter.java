package com.example.lbenitez.schoolapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyColegioRecyclerViewAdapter extends RecyclerView.Adapter<MyColegioRecyclerViewAdapter.ViewHolder> {

  private final List<Colegio> mValues;
  private final ColegiosInteractionListener mListener;
  Context ctx;

  public MyColegioRecyclerViewAdapter(Context ctx, int layout, List<Colegio> items, ColegiosInteractionListener listener) {
    mValues = items;
    mListener = listener;
    this.ctx = ctx;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.fragment_colegio, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    holder.mName.setText(holder.mItem.getNombre_colegio());
    holder.mEtapa.setText(holder.mItem.getEtapas_educativas());

    Glide.with(ctx).load(holder.mItem.getLogotipo()).into(holder.mImage);

    holder.mDireccion.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (null != mListener) {
          mListener.onColegioDireccionClick(holder.mItem.getDireccion());
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final ImageView mImage;
    public final TextView mName;
    public final TextView mEtapa;
    public final Button mDireccion;
    public Colegio mItem;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mImage = view.findViewById(R.id.image);
      mName = view.findViewById(R.id.nombre);
      mEtapa = view.findViewById(R.id.etapas);
      mDireccion = view.findViewById(R.id.btnDireccion);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mName.getText() + "'" + mDireccion.getText() + "'";
    }
  }
}
