package be.arno.crud_fetcher;

import android.net.Uri;

public class myApp {

	//	android:name=".items.ItemContentProvider"
    //	android:authorities="be.arno.crud.ItemProvider"
    //	android:exported="true"
	
	public static final String ITEM_PROVIDER_STR = "content://be.arno.crud.ItemProvider/items";
	public static final Uri    ITEM_PROVIDER_URI = Uri.parse(ITEM_PROVIDER_STR);

}
