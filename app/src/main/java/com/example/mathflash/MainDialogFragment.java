package com.example.mathflash;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;


public class MainDialogFragment extends BlurDialogFragment {
    private RadioGroup radioGroup, radioGroup2;
    private RadioButton radioButton, radioButton2;
    private MainDialogListener mainDialogListener;


    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle SavedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        radioGroup = view.findViewById(R.id.radio_group);
        radioGroup2 = view.findViewById(R.id.radio_group2);
        view.findViewById(R.id.startGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)radioGroup.findViewById(selectedId);
                CharSequence gameMode = radioButton.getText();

                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = (RadioButton)radioGroup2.findViewById(selectedId2);
                CharSequence gameLength = radioButton2.getText();

                mainDialogListener.submittedInfo(v, gameMode, gameLength);
                dismiss();

            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mainDialogListener = (MainDialogListener) context;
        }catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}