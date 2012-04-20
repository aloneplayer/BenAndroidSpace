//
package ben.android.BlackCoach;

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

		Button buttonOpenTaskList = (Button) findViewById(R.id.button_OpenTaskList);
		buttonOpenTaskList.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, DailyTaskListActivity.class);
				startActivity(intent);
			}
		});

	}
}