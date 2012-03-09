package ben.android.demo.Threading;

import ben.android.demo.R;
import ben.android.demo.SurfaceView.LittleBallActivity;
import ben.android.demo.SurfaceView.SurfaceViewDemoMainActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreadJoinActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_join);

		Button button_Threading_Join = (Button) findViewById(R.id.button_Threading_Join);
		button_Threading_Join.setOnClickListener(new OnClickListener()
		{
			public void onClick(View view)
			{
				String text = (String) ((Button)view).getText();
				((Button)view).setText("Running...");
				mainThreadFunction();
				((Button)view).setText(text);
			}
		});

	}

	private void mainThreadFunction()
	{
		for (int j = 0; j < 10; j++)
		{
			if (j == 3)
			{
				Thread newThread = new Thread(new Runnable()
				{
					public void run()
					{
						for (int i = 0; i < 5; i++)
						{
							Log.i("", ">New thread: " + "i =  " + i);
							try
                            {
	                            Thread.sleep(1000);
                            }
                            catch (InterruptedException e)
                            {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
                            }
						}
						Log.i("","New thread has finished");
					}
				});

				newThread.start();
				//
				// Block calling thread (main thread), until new thread
				// terminates, 否则 main thread和 new thread会交替执行
				//
				try
				{
					newThread.join();
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				Log.i("", "Main thread: " + "   j =  " + j);
				try
                {
	                Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
                }
			}
		}
	}
}
