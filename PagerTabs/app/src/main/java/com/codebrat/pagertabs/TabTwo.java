package com.codebrat.pagertabs;

import android.Manifest;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Bharath on 5/10/2017.
 */

public class TabTwo extends Fragment implements View.OnClickListener {

    Button getAccess;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_two, container, false);
        getAccess = (Button) view.findViewById(R.id.getAccess);
        getAccess.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getAccess:
                if (checkPermission()) {
                    Toast.makeText(getContext(), "Premission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    getPermission();
                }
                break;

            default:

                break;
        }
    }

    private boolean checkPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);
        if (permissionCheck == PermissionChecker.PERMISSION_GRANTED)
            return true;
        return false;
    }

    private void getPermission() {
        boolean result = FragmentCompat.shouldShowRequestPermissionRationale(TabTwo.this , Manifest.permission.CAMERA);
        Log.d("CodeBrat", "Should i show rationale " + result);
        Toast.makeText(getContext(), "Should i show rationale " + result, Toast.LENGTH_SHORT).show();
        if (result) {
            new AlertDialog.Builder(getActivity())
                    .setMessage("You need to allow access to the calendar.")
                    .setNegativeButton("cancel", null)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(final DialogInterface dialog, final int which) {
                            FragmentCompat.requestPermissions(TabTwo.this, new String[]{Manifest.permission.CAMERA}, 0);
                        }
                    })
                    .setCancelable(true)
                    .create()
                    .show();
        }
        else {
            FragmentCompat.requestPermissions(TabTwo.this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }
}
