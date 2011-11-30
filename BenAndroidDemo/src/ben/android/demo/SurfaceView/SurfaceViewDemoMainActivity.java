package ben.android.demo.SurfaceView;

import ben.android.demo.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SurfaceViewDemoMainActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.surfaceview_main);

		Button button_Movement = (Button) findViewById(R.id.button_surfaceViewTest);
		button_Movement.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				intent.setClass(SurfaceViewDemoMainActivity.this, LittleBallActivity.class);
				startActivity(intent);
			}
		});
	}
}
