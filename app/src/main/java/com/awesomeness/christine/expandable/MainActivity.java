package com.awesomeness.christine.expandable;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import java.util.ArrayList;


public class MainActivity extends Activity {

    private ExpandableListView mExpandableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mExpandableList = (ExpandableListView)findViewById(R.id.expandable_list);

        ArrayList<parent> arrayParents = new ArrayList<parent>();
        ArrayList<String> arrayChildren = new ArrayList<String>();

        parent notifications = new parent();
        notifications.setTitle("Notifications");

        arrayChildren = new ArrayList<String>();

        //here we set the parents and the children
        for (int j = 0; j < 5; j++) {
            arrayChildren.add("N " + j);
        }
        notifications.setArrayChildren(arrayChildren);

        //in this array we add the Parent object. We will use the arrayParents at the setAdapter
        arrayParents.add(notifications);

        parent messages = new parent();
        messages.setTitle("Messages");

        arrayChildren = new ArrayList<String>();

        //here we set the parents and the children
        for (int j = 0; j < 5; j++) {
            arrayChildren.add("M " + j);
        }
        messages.setArrayChildren(arrayChildren);

        arrayParents.add(messages);

        //sets the adapter that provides data to the list.
        mExpandableList.setAdapter(new MyCustomAdapter(MainActivity.this,arrayParents));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
