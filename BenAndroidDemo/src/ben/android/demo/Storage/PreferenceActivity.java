package ben.android.demo.Storage;

import ben.android.demo.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class PreferenceActivity extends Activity
{
	//--Get preference xml
	//adb pull /data/data/<package name>/shared_pref/*.xml d:/
	//--缺点： 不安全，效率低
	//一般用来做配置文件
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storage_preference);
	}
	private void SaveSettings()
	{
		//MyPreference is the xml file's name
		SharedPreferences sp = this.getSharedPreferences("MyPreference", Activity.MODE_PRIVATE);
		SharedPreferences.Editor e = sp.edit();
		e.putString("Item1", "Hello");
		e.putString("Item2", "World");
		e.commit();
		
		Toast.makeText(this, "SharedPreference Creatd", 3000).show();
	}
	
	private void ReadSettings()
	{
		SharedPreferences sp = this.getSharedPreferences("MyPreference", Activity.MODE_PRIVATE);
		String v1 = sp.getString("Item1", "Default value");
	}
}
