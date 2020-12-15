package com.mycollege.mait;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class NFListContent {


    /**
     * An array of sample (dummy) items.
     */
    public static List<ListItem> ITEMS = new ArrayList<ListItem>();
    public static List<HashMap<String, Object>> ITEMS2 = new ArrayList<HashMap<String, Object>>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static HashMap<String, ListItem> ITEM_MAP = new HashMap<String, ListItem>();
    public static HashMap<String, Object> ITEM_MAP2 = new HashMap<String, Object>();



            static {
                // Add 3 sample items.


                addItem(new ListItem("1", "News Feed Detail page 1", " Desc "));
                addItem(new ListItem("2", "News Feed Detail page 2", " Desc "));
                addItem(new ListItem("3", "News Feed Detail page 3", " Desc "));
                addItem(new ListItem("4", "News Feed Detail page 4", " Desc "));
                addItem(new ListItem("5", "News Feed Detail page 5", " Desc "));
                addItem(new ListItem("6", "News Feed Detail page 6", " Desc "));
                addItem(new ListItem("7", "News Feed Detail page 7", " Desc "));
                addItem(new ListItem("8", "News Feed Detail page 8", " Desc "));
                addItem(new ListItem("9", "News Feed Detail page 9", " Desc "));
                addItem(new ListItem("10", "News Feed Detail page 10", " Desc "));



            }
    static {
        ITEM_MAP2.put("title", "News Feed 1");
        ITEM_MAP2.put("desc", "News Feed Desc 1");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 2");
        ITEM_MAP2.put("desc", "News Feed Desc 2");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 3");
        ITEM_MAP2.put("desc", "News Feed Desc 3");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 4");
        ITEM_MAP2.put("desc", "News Feed Desc 4");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 5");
        ITEM_MAP2.put("desc", "News Feed Desc 5");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 6");
        ITEM_MAP2.put("desc", "News Feed Desc 6");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 7");
        ITEM_MAP2.put("desc", "News Feed Desc 7");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 8");
        ITEM_MAP2.put("desc", "News Feed Desc 8");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 9");
        ITEM_MAP2.put("desc", "News Feed Desc 9");
        ITEMS2.add(ITEM_MAP2);
        ITEM_MAP2.put("title", "News Feed 10");
        ITEM_MAP2.put("desc", "News Feed Desc 10");
        ITEMS2.add(ITEM_MAP2);
    }


    private static void addItem(ListItem item) {
        ITEMS.add(item);
      ITEM_MAP.put(item.id, item);



        }



    /**
     * A dummy item representing a piece of content.
     */
    public static class ListItem {
        public String id;
        public static String TAG_TITLE = "title";
        public static String TAG_DESC = "desc";


        public ListItem(String id, String title,String desc ) {
            this.id = id;
            this.TAG_TITLE = title;
            this.TAG_DESC = desc;
        }


        public String getTAG_TITLE() {
            return TAG_TITLE;
        }
        public String getTAG_DESC(){return TAG_DESC;}
    }
}
