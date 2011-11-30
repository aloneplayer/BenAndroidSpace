package ben.android.demo.SurfaceView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LittleBallActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LittleBallView mv = new LittleBallView(this);
		setContentView(mv);
	}

	public class LittleBallView extends SurfaceView implements SurfaceHolder.Callback
	{
		// 小球的活动空间
		private int width;
		private int height;
		// 小球的位置
		private int xPos;
		private int yPos;
		// 小球的速度
		private int xVel;
		private int yVel;
		// 小球的半径
		private int circleRadius;

		// 画小球的画笔
		private Paint circlePaint;

		UpdateThread updateThread;

		public LittleBallView(Context context)
		{
			super(context);
			//
			getHolder().addCallback(this);

			circleRadius = 10;
			circlePaint = new Paint();
			circlePaint.setColor(Color.BLUE);

			xVel = 2;
			yVel = 2;
		}

		@Override
		protected void onDraw(Canvas canvas)
		{
			canvas.drawColor(Color.WHITE);
			canvas.drawCircle(xPos, yPos, circleRadius, circlePaint);
		}

		// 更新小球的位置信息，如果小球撞墙就改变方向
		public void updatePhysics()
		{
			// 小球移动，根据速度更新当前位置
			xPos += xVel;
			yPos += yVel;

			if (yPos - circleRadius < 0 || yPos + circleRadius > height)
			{
				if (yPos - circleRadius < 0)
				{
					yPos = circleRadius;
				}
				else
				{
					yPos = height - circleRadius;
				}
				yVel *= -1;
			}
			if (xPos - circleRadius < 0 || xPos + circleRadius > width)
			{
				if (xPos - circleRadius < 0)
				{
					xPos = circleRadius;
				}
				else
				{
					xPos = width - circleRadius;
				}
				xVel *= -1; // Change direction
			}
		}

		public void surfaceCreated(SurfaceHolder holder)
		{
			//
			Rect surfaceFrame = holder.getSurfaceFrame();
			width = surfaceFrame.width();
			height = surfaceFrame.height();

			xPos = width / 2;
			yPos = circleRadius;

			updateThread = new UpdateThread(this);
			updateThread.setRunning(true);
			updateThread.start();
		}

		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
		{
		}

		public void surfaceDestroyed(SurfaceHolder holder)
		{
			boolean retry = true;
			
			updateThread.setRunning(false);  //stop updateThread
			while (retry)
			{
				try
				{
					//MainThread就被停止执行，updateThread线程执行完毕。
					updateThread.join();
					retry = false;
				}
				catch (InterruptedException e)
				{
				}
			}
		}

		public class UpdateThread extends Thread
		{
			private long time;
			private final int fps = 20;
			private boolean toRun = false;
			private LittleBallView targetView;
			private SurfaceHolder surfaceHolder;

			public UpdateThread(LittleBallView view)
			{
				targetView = view;
				surfaceHolder = targetView.getHolder();
			}

			public void setRunning(boolean run)
			{
				toRun = run;
			}

			public void run()
			{
				Canvas c;
				while (toRun)
				{
					long cTime = System.currentTimeMillis();

					if ((cTime - time) <= (1000 / fps))
					{
						c = null;
						try
						{
							//从surfaceHolder得到Surface view的 canvas
							c = surfaceHolder.lockCanvas(null);

							targetView.updatePhysics();
							targetView.onDraw(c);
						}
						finally
						{
							if (c != null)
							{
								surfaceHolder.unlockCanvasAndPost(c);
							}
						}
					}
					time = cTime;
				}
			}
		}
	}
}
