package com.mycollege.mait;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class NewsFeed extends ListFragment {

	private ArrayList<HashMap<String, Object>> data;
	ListView lv;

	private static final String TAG_TITLE = "title";
	private static final String TAG_DESC = "desc";
	private static final String TAG_IMAGE = "image";

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		getListView();

		PrepareData();
	/*	SimpleAdapter adapter = new SimpleAdapter(getActivity(), data,
				R.layout.newsfeed_list_lay, new String[] { TAG_TITLE, TAG_DESC,
						TAG_IMAGE }, new int[] { R.id.tv_nf_title,
						R.id.tv_nf_desc, R.id.iv_nf_image });
		setListAdapter(adapter);*/

	}

    private void PrepareData() {
		data = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> item;

		for (int i = 0; i <= 20; ++i) {
			item = new HashMap<String, Object>();
			item.put(TAG_TITLE, "News Feed " + i);
			item.put(TAG_DESC, "News Feed Desc " + i);
			if (i % 3 == 0)
				item.put(TAG_IMAGE, R.drawable.marker_1);
			else if (i % 2 == 0)
				item.put(TAG_IMAGE, R.drawable.marker_2);
			else
				item.put(TAG_IMAGE, R.drawable.marker_2);
			data.add(item);
		}

	}

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


    }
}
