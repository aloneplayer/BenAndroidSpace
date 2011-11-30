package ben.android.demo.Storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import ben.android.demo.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class FileActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storage_preference);
	}

	// in SDK card
	// in RAM

	private void Write(String message)
	{
		String SDCardPath = GetExternalStoragePath();

		if (SDCardPath != null)
		{
			String logFolderPath = "/Log/";
			String logFilePath = SDCardPath + logFolderPath + "log.txt";
			try
			{
				//????this.CreateFile(logFilePath);
				FileOutputStream os = new FileOutputStream(logFilePath);
				byte[] bytes = message.getBytes();
				os.write(bytes);
				os.close();
			}
			catch (Exception exp)
			{
				exp.printStackTrace();

			}

		}
	}

	private String Read()
	{
		String SDCardPath = GetExternalStoragePath();

		if (SDCardPath != null)
		{
			String logFolderPath = "/Log/";
			String logFilePath = SDCardPath + logFolderPath + "log.txt";
			try
			{
				FileInputStream is = new FileInputStream(logFilePath);
				int length = is.available();
				byte[] buffer = new byte[length];
				is.read(buffer);
				String message = new String(buffer);

				is.close();
				
				return message;
			}
			catch (Exception exp)
			{
				exp.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static String GetExternalStoragePath()
	{
		// 获取SdCard状态
		String state = android.os.Environment.getExternalStorageState();

		// 判断SdCard是否存在并且是可用的
		if (android.os.Environment.MEDIA_MOUNTED.equals(state))
		{
			if (android.os.Environment.getExternalStorageDirectory().canWrite())
			{
				return android.os.Environment.getExternalStorageDirectory().getPath();
			}
		}

		return null;
	}
}
