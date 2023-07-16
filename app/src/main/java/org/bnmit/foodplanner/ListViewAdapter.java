package org.bnmit.foodplanner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;
    public ListViewAdapter(Context context, ArrayList<String>items){
        super(context, R.layout.list_row, items);
        this.context = context;
        list=items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_row, null);
            TextView name = convertView.findViewById(R.id.name);
            ImageView remove = convertView.findViewById(R.id.remove);
            ImageView add=convertView.findViewById(R.id.addquantity);
            TextView display=convertView.findViewById(R.id.displayquantity);
            ImageView sub=convertView.findViewById(R.id.removequantity);

            TextView number = convertView.findViewById(R.id.number);

            number.setText(position + 1 + ".");
            name.setText(list.get(position));

            // Listeners for duplicating and removing an item.
            // They use the static removeItem and addItem methods created in MainActivity.
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Shopping.removeItem(position);
                }
            });
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int q=Integer.parseInt(display.getText().toString());
                    q++;
                    display.setText(""+q);
                }
            });
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int q=Integer.parseInt(display.getText().toString());
                    if (q==1)
                    {
                        remove.performClick();
                    }
                    else
                    {
                        q--;
                        display.setText(""+q);
                    }
                }
            });

        }
        return convertView;
    }

}
