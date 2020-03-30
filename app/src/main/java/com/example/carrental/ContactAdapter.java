package com.example.carrental;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Car> {
    private ArrayList<Car> items;
    private Context adapterContext;
    public ContactAdapter(Context context, ArrayList<Car> items) {
        super(context, R.layout.car_info, items);
        adapterContext = context;
        this.items = items;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            Car car = items.get(position);

            if(v == null){
                LayoutInflater vi =(LayoutInflater) adapterContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                v = vi.inflate(R.layout.car_info, null);
            }
            TextView textCarName = (TextView) v.findViewById(R.id.textCarName);
            TextView textCarMpg=(TextView) v.findViewById(R.id.textAddy) ;
            TextView textCarTpye=(TextView) v.findViewById(R.id.textCarType) ;
            TextView textCarPrice=(TextView) v.findViewById(R.id.textPrice) ;

            Button b = (Button) v.findViewById(R.id.buttonReserveCar);
            ImageView photo= (ImageView) v.findViewById(R.id.imageView);
            textCarName.setText(car.getCarName());
            textCarMpg.setText("MPG:"+car.getMpg());
            textCarPrice.setText("$"+car.getPrice());

            textCarTpye.setText(car.getCarType());



            photo.setImageBitmap(car.getPicture());



            b.setVisibility((View.VISIBLE));
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return v;
    }

}
