package com.example.boon.scareaway;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SafeEntryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SafeEntryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SafeEntryFragment extends Fragment {
    ImageView checked;
    Button in;
    Button out;
    TextView centerText;
    TextView loadingText;
    ProgressBar progress;

    public SafeEntryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SafeEntryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SafeEntryFragment newInstance(String param1, String param2) {
        SafeEntryFragment fragment = new SafeEntryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ConstraintLayout parent = (ConstraintLayout)  inflater.inflate(R.layout.fragment_safe_entry, container, false) ;
        in = (Button) parent.findViewById(R.id.checkInButton);
        in.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { checkIn(); } });
        out = (Button) parent.findViewById(R.id.checkOutButton);
        out.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { checkOut(); } });
        progress = (ProgressBar) parent.findViewById(R.id.progressBar2);
        progress.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { showChoice(); } });
        loadingText = (TextView) parent.findViewById(R.id.searchText);
        loadingText.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { showChoice(); } });
        centerText = (TextView) parent.findViewById(R.id.centerText);
        checked = (ImageView) parent.findViewById(R.id.checkImage);
        checked.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { showChoice(); } });
        return parent;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void checkIn() {
        checked.setImageResource(R.drawable.checked_in);
        checked.setVisibility(View.VISIBLE);
        in.setVisibility(View.INVISIBLE);
        out.setVisibility(View.INVISIBLE);
        Log.e("checkIn","Checked");
    }

    private void checkOut() {
        checked.setImageResource(R.drawable.checked_out);
        centerText.setVisibility(View.VISIBLE);
        checked.setVisibility(View.VISIBLE);
        in.setVisibility(View.INVISIBLE);
        out.setVisibility(View.INVISIBLE);
        Log.e("checkOut","Checked");
    }

    private void showChoice() {
        Log.e("checkOut","Checked");
        progress.setVisibility(View.INVISIBLE);
        loadingText.setVisibility(View.INVISIBLE);
        checked.setVisibility(View.INVISIBLE);
        centerText.setVisibility(View.VISIBLE);
        in.setVisibility(View.VISIBLE);
        out.setVisibility(View.VISIBLE);
    }
}
