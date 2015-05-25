package com.itcode.semiCircle;


import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class MainActivity extends RoboActivity {

	@InjectView(R.id.semiCircle)
	public MyDrawSemicircle semiCircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        semiCircle.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.testqn));
    }

}
