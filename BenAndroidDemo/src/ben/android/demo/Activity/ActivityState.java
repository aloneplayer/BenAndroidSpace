package ben.android.demo.Activity;

import android.app.Activity;
import android.os.Bundle;

public class ActivityState extends Activity
{
	private static final String SAVE_INSTANCE_TAG = "Activity State";

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		// 在onCreate之后执行
		String state = savedInstanceState.getString("myState");
		
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		//系统回收当前Activity 之前执行, 点击 back & Home 键不会被调用
		// 接电话会时发生
		if (outState != null)
		{
			outState.putString("myState", "onSaving");
		}
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onPause()
	{
		//Save activity state via preference at onPause 
		//点击 back & Home 键时发生
		super.onPause();

		this.getPreferences(MODE_PRIVATE).edit().putString("myKey", "Hello");
	}

	@Override
	protected void onResume()
	{
		// Restore activity state at onResume
		super.onResume();
		String s = this.getPreferences(MODE_PRIVATE).getString("key", "");
	}
	
	//屏幕旋转时保存Activity State
}
