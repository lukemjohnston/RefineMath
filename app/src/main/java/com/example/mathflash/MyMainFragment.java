package com.example.mathflash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;


public class MyMainFragment extends BlurDialogFragment {
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle SavedInstanceState) {
        super.onCreateView(inflater, container, SavedInstanceState);
        return inflater.inflate(R.layout.dialog_fragment, container, false);
    }
}