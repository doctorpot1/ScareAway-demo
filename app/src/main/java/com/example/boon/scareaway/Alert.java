package com.example.boon.scareaway;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * TODO: document your custom view class.
 */
public class Alert extends DialogFragment {
    public Alert() {
    }
    public static Alert newInstance(String title) {
        Alert frag = new Alert();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.sample_alert, null);
        builder.setView(layout);
        String title = getArguments().getString("title", "Risky Place");
        TextView textView = (TextView) layout.findViewById(R.id.text_dialog);
        textView.setText(title);
        Button dialogButton = (Button) layout.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alert.this.getDialog().dismiss();
            }
        });
        return builder.create();
    }
}
