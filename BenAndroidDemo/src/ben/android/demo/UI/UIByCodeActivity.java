package ben.android.demo.UI;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


// 容器是android.view.ViewGroup的子类
// ViewGroup 是 View的子类
public class UIByCodeActivity extends Activity
{
	private LinearLayout root;

	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
	    super.onCreate(savedInstanceState);
	    
	    LinearLayout.LayoutParams containerParams 
	    	= new LinearLayout.LayoutParams(
	    			ViewGroup.LayoutParams.FILL_PARENT,
	    			ViewGroup.LayoutParams.WRAP_CONTENT,
	    			0.0F);
	    LinearLayout.LayoutParams widgetParams 
    	= new LinearLayout.LayoutParams(
    			ViewGroup.LayoutParams.FILL_PARENT,
    			ViewGroup.LayoutParams.FILL_PARENT,
    			1.0F);
	    
	    root = new LinearLayout(this);
	    root.setOrientation(LinearLayout.VERTICAL);
	    root.setBackgroundColor(Color.LTGRAY);
	    root.setLayoutParams(containerParams);
	    
	    LinearLayout ll = new LinearLayout(this);
	    ll.setOrientation(LinearLayout.HORIZONTAL);
	    ll.setBackgroundColor(Color.GRAY);
	    ll.setLayoutParams(containerParams);
	    root.addView(ll);
	    
	    EditText tb = new EditText(this);
	    tb.setText("LeftText");
	    tb.setFocusable(false);
	    tb.setLayoutParams(widgetParams);
	    ll.addView(tb);
	    
	    tb = new EditText(this);
	    tb.setText("RightText");
	    tb.setFocusable(false);
	    tb.setLayoutParams(widgetParams);
	    ll.addView(tb);
	    
	    LinearLayout l2 = new LinearLayout(this);
	    l2.setOrientation(LinearLayout.HORIZONTAL);
	    l2.setBackgroundColor(Color.DKGRAY);
	    l2.setLayoutParams(containerParams);
	    root.addView(l2);
	    
	    Button b = new Button(this);
	    b.setText("Red");
	    b.setTextColor(Color.RED);
	    b.setLayoutParams(widgetParams);
	    l2.addView(b);
	    
	    b= new Button(this);
	    b.setText("Green");
	    b.setTextColor(Color.GREEN);
	    b.setLayoutParams(widgetParams);
	    l2.addView(b);
	    
	    setContentView(root);    
    }
	
}
