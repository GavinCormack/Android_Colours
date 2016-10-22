package com.example.colours;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity implements OnTouchListener {

	ImageView iv;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.imageView1);
		iv.setOnTouchListener(this);
		
		b = (Button) findViewById(R.id.button1);
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		
		float x,y;
		
		
		x = event.getX();
		y = event.getY();
		
		float[] hsvColor = {1f, 1f, 1f};
		
		if(y < height/3)
		{
			//White <-> Normal
			hsvColor[0] =  360f * x / width;
			hsvColor[1] = y / (height/3);
			hsvColor[2] = 1f;
		}
		else if((y >= height/3) && (y < (height/3) *2))
		{
			//Normal
			hsvColor[0] =  360f * x / width;
			hsvColor[1] = 1f;
			hsvColor[2] = 1f;
		}
		else if(y >= (height/3) *2)
		{
			
			//Normal <-> Black
			hsvColor[0] =  360f * x / width;
			hsvColor[1] = 1f;
			hsvColor[2] = 1 - ( ( y - ( (height/3) *2) ) / (height/3) );
		}
		
		b.setBackgroundColor(Color.HSVToColor(hsvColor));
		
		
		return true;
	}

	
}
