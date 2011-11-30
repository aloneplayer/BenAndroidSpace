package ben.android.demo.Threading;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import ben.android.demo.R;

public class ThreadingMainActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.threading_main);

		Button button = (Button) findViewById(R.id.button_Thread_Join);

		button.setOnClickListener(new OnClickListener()
		{

			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				intent.setClass(ThreadingMainActivity.this, ThreadJoinActivity.class);
				startActivity(intent);
			}
		});
	}

}
