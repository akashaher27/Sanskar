package com.example.common.view.viewPager;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Interface definition for a callback to be invoked when an item in this RecyclerView has been clicked.
 *
 * @author Akash
 */
public interface OnRecyclerViewOnItemClickListener {

    /**
     * Callback method to be invoked when an item in this RecyclerView has been clicked.
     *
     * @param parent   The RecyclerView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     */
    void onItemClick(RecyclerView parent, View view, int position);

}
