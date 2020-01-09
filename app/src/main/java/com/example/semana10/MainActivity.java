package com.example.semana10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.semana10.adapters.ContactoAdaptador;
import com.example.semana10.helpers.QueueUtils;
import com.example.semana10.model.contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView List;
    ContactoAdaptador contactoAdaptador;
    QueueUtils.QueueObject queue = null;
    ArrayList<contacto> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        List = findViewById(R.id.List);
        items = new ArrayList<>();
        contacto.injectContactsFromCloud(queue, items, this);

        contactoAdaptador = new ContactoAdaptador(this, items,queue.getImageLoader());
        List.setAdapter(contactoAdaptador);

    }
    public void refreshList(){
        if ( contactoAdaptador != null ) {
            contactoAdaptador.notifyDataSetChanged();
        }
    }
}

