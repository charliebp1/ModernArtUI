package com.example.modernartui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

@SuppressLint("NewApi")
public class WebFragment extends DialogFragment{
	public Dialog onCreateDialog(Bundle savedInstanceState) {

        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            
            public void onClick(DialogInterface dialog, int which) {
                

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.moma.org"));
                getActivity().startActivity(intent);
            }
        };

        DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
           
        	public void onClick(DialogInterface dialog, int which) {
             
                dismiss();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       
        builder.setNegativeButton("Not Now", negativeClick);
        builder.setPositiveButton("Visit MOMA", positiveClick);
        builder.setTitle("Visit the following link to learn more about MOMA");
        Dialog dialog = builder.create();
        return dialog;
    }

	
}
