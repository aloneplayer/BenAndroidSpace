package ben.android.demo.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class UIDemoMain extends Activity implements OnClickListener
{
	private Button button_UIByCode;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
		        ViewGroup.LayoutParams.FILL_PARENT, 0.0F);

		LinearLayout root = new LinearLayout(this);
		root.setOrientation(LinearLayout.VERTICAL);
		root.setLayoutParams(containerParams);

		LinearLayout.LayoutParams buttonLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT, 0.0F);

		button_UIByCode = new Button(this);
		button_UIByCode.setText("Create UI by code");
		button_UIByCode.setLayoutParams(buttonLayout);
		button_UIByCode.setOnClickListener(this);
		root.addView(button_UIByCode);

		setContentView(root);

	}

	public void onClick(View button)
	{
		// TODO Auto-generated method stub
		if (button.getId() == this.button_UIByCode.getId())
		{
			Intent intent = new Intent();
			intent.setClass(this, UIByCodeActivity.class);
			startActivity(intent);
		}

	}
}
