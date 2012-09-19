/**
 * ViewCurrentBugsActivity.java Created by: Nahuel Barrios: 14/04/2012, 09:42:04.
 */
package com.nbempire.android.magicannotator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.nbempire.android.magicannotator.R;

/**
 * TODO : JavaDoc : for ViewCurrentBugsActivity.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 14/04/2012, 09:42:04.
 */
public class ViewCurrentBugsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcurrentbugs);

        this.loadBugs();
    }

    /**
     * Cargo dinámicamente el listado de bugs en la GUI.
     * 
     * @author Nahuel Barrios.
     * @since 14/04/2012.
     */
    private void loadBugs() {
        TableLayout bugsLayout = (TableLayout) findViewById(R.id.viewCurrentBugs_bugsLayout);
        TableRow tableRow = new TableRow(bugsLayout.getContext());

        ArrayAdapter<CharSequence> bugs = ArrayAdapter.createFromResource(this, R.array.viewCurrentBugs_bugsValues, 0);
        for (int iterator = 0; iterator < bugs.getCount(); iterator++) {
            tableRow = new TableRow(this);
            TextView eachBug = new TextView(tableRow.getContext());
            eachBug.setText(bugs.getItem(iterator));
            eachBug.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            // eachBug.setHeight(GUIKeys.VIEW_CURRENT_BUGS_TEXT_SIZE_FOR_BUGS_DETAIL);
            tableRow.addView(eachBug);
            bugsLayout.addView(tableRow);
        }
    }

}
