package com.example.semana10.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.semana10.R;
import com.example.semana10.model.contacto;

import java.util.List;

public class ContactoAdaptador extends ArrayAdapter<contacto> {
    Context context;
    ImageLoader queue; //<-------- Añadir esta variable

    private class ViewHolder {
        NetworkImageView image; //<-------- Añadir esta variable
        TextView phone;
        TextView nickname;

        private ViewHolder() {
        }
    }
    public ContactoAdaptador(Context context, List<contacto> items, ImageLoader _queue) {
        super(context, 0, items);
        this.context = context;
        this.queue = _queue; //<---- Notar esa linea

    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final contacto rowItem = (contacto) getItem(position);
        LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.contacto_item, null);
            holder = new ViewHolder();
            holder.image = (NetworkImageView)convertView.findViewById(R.id.image); //<----- Notar esta linea
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            holder.nickname = (TextView) convertView.findViewById(R.id.nickname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // ( rowItem.getSmallImage() != null ) {
        //   holder.image.setImageUrl(rowItem.getSmallImage(), queue);
       //}
        holder.phone.setText(rowItem.phone);
        holder.nickname.setText(rowItem.nickname);
        return convertView;

    }
}

