package be.arno.crud_fetcher;

import java.util.ArrayList;

import be.arno.crud_fetcher.Item;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String DB_NAME       = "itemsDB";
	public static final String TABLE_ITEMS   = "items";
	public static final String COLUMN_ID     = "_id";
	public static final String COLUMN_NAME   = "name";
	public static final String COLUMN_DATE   = "date";
	public static final String COLUMN_RATING = "rating";
	public static final String COLUMN_BOOL   = "bool";
	
	Cursor curseur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView txvw = (TextView)findViewById(R.id.TextView1);

		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(myApp.ITEM_PROVIDER_URI, null, null, null, null);

		
		if ( c != null ) {

			ArrayList<Item> items = new ArrayList<Item>();

			int i = 0;
			c.moveToFirst();
			while ( i < c.getCount() ) {
				items.add(cursorToItem(c));
				c.moveToNext();
				i = i + 1;
			}

			txvw.setText(items.toString());
		} else {
			txvw.setText("null");
			
		}
	}

	private Item cursorToItem(Cursor c) {
		Item item = new Item();
		item.setId(c.getInt(c.getColumnIndex(COLUMN_ID)));
		item.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
		item.setDate(c.getString(c.getColumnIndex(COLUMN_DATE)));
		item.setRating(c.getFloat(c.getColumnIndex(COLUMN_RATING)));		
		item.setBool(c.getInt(c.getColumnIndex(COLUMN_BOOL)));
		return item;
	}
	
}
