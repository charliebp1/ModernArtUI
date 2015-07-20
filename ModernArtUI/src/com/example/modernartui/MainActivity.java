package com.example.modernartui;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Build;
import android.content.Intent;
import android.graphics.Color;

public class MainActivity extends Activity {
	
	SeekBar seekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		final View rect_one = findViewById(R.id.rect_1);
		final View rect_two = findViewById(R.id.rect_2);
		final View rect_three = findViewById(R.id.rect_3);
		final View rect_four = findViewById(R.id.rect_4);
		final View rect_five = findViewById(R.id.rect_5);

		
		rect_one.setBackgroundColor(Color.RED);
		rect_two.setBackgroundColor(Color.WHITE);
		rect_three.setBackgroundColor(Color.BLUE);
		rect_four.setBackgroundColor(Color.YELLOW);
		rect_five.setBackgroundColor(Color.GRAY);
		
		 seekBar=(SeekBar)findViewById(R.id.seekBar);
		
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            
			int progress = 0;
			// 0 & 360 are Red in HSV color spectre
            int maxProgress = 360;
			// 120 is Green in HSV color spectre
			int maxProgress2 = 120;
			// 60 is Yellow in HSV color spectre
			int maxProgress3 = 60;
			// 240 is Blue in HSV color spectre
			int maxProgress4 = 240;
			// 520 is Cyan in HSV color spectre
			int maxProgress5 = 520;
			
			
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				
			
				int num = i;
				
				//Change view color using HSV color
				progress = i;
				float [] hsvColor1 = {0,1,1}; 
				hsvColor1[0] = 360f * progress / maxProgress;
				rect_one.setBackgroundColor(Color.HSVToColor(hsvColor1));
				
				float [] hsvColor2 = {0, 1, 1};
				hsvColor2[0] = 360f * progress / maxProgress2;
				rect_two.setBackgroundColor(Color.HSVToColor(hsvColor2));
				
				float [] hsvColor3 = {0, 1, 1};
				hsvColor3[0] = 360f * progress / maxProgress3;
				rect_three.setBackgroundColor(Color.HSVToColor(hsvColor3));
				
				float [] hsvColor4 = {0, 1, 1};
				hsvColor4[0] = 360f * progress / maxProgress4;
				rect_four.setBackgroundColor(Color.HSVToColor(hsvColor4));
				
				float [] hsvColor5 = {0, 1, 1};
				hsvColor5[0] = 360f * progress / maxProgress5;
				rect_five.setBackgroundColor(Color.HSVToColor(hsvColor5));
				
				// Reset colors to it´s original state
				if(num == 0){
					rect_one.setBackgroundColor(Color.RED);
					rect_two.setBackgroundColor(Color.WHITE);
					rect_three.setBackgroundColor(Color.BLUE);
					rect_four.setBackgroundColor(Color.YELLOW);
					rect_five.setBackgroundColor(Color.GRAY);
            
				}
			}
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
      
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
		
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_info) {
			webFragment();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	private void webFragment() {
		// TODO Auto-generated method stub
		android.app.FragmentManager wf = getFragmentManager();
		WebFragment mwdf = new WebFragment();
		
		mwdf.show(wf, "make your choice");
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
