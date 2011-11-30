package ben.android.demo;

import ben.android.demo.SurfaceView.SurfaceViewDemoMainActivity;
import ben.android.demo.Threading.ThreadingMainActivity;
import ben.android.demo.UI.UIDemoMain;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button;
		// UI
		button = (Button) findViewById(R.id.button_UIDemo);
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, UIDemoMain.class);
				startActivity(intent);
			}
		});
		
		// Surface View
		button = (Button) findViewById(R.id.button_surfaceViewTest);

		button.setOnClickListener(new OnClickListener()
		{

			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SurfaceViewDemoMainActivity.class);
				startActivity(intent);
			}
		});

		// Threading
		button = (Button) findViewById(R.id.button_threading);

		button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ThreadingMainActivity.class);
				startActivity(intent);
			}
		});
	}
}