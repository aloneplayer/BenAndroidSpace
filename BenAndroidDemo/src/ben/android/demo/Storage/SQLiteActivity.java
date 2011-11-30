package ben.android.demo.Storage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
// 1. Create db: onCreate, onUpgrade
// 2. Call get...Database() get BD object
// 3. DB.insert,update
public class SQLiteActivity extends Activity
{
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
	    // TODO Auto-generated method stub
	    super.onCreate(savedInstanceState);
    }
	
	
	private void InsertDB()
	{
		DemoSQLiteHelper sh= new DemoSQLiteHelper(this, "MyDB", null, 1);
		SQLiteDatabase db = sh.getWritableDatabase(); //call onCreate
		
		ContentValues values= new ContentValues();
		values.put("id", 1);
		values.put("name", "Ben");
		values.put("id", 2);
		values.put("name", "Lily");
		db.insert("user", null, values);
	}
	
	class DemoSQLiteHelper extends SQLiteOpenHelper
	{
		//Must has a constructor
		public DemoSQLiteHelper(Context context, String name, CursorFactory factory, int version)
        {
	        super(context, name, factory, version);
	        // TODO Auto-generated constructor stub
        }

		//Create table
		@Override
        public void onCreate(SQLiteDatabase db)
        {
			String sql = "create Table user(id int, name varchar(20))";
	        db.execSQL(sql);
	        
        }

		//Will be called when version changed
		@Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
	        if(newVersion==2)
	        {
	        	
	        	
	        }        
        }
	
	}
}
