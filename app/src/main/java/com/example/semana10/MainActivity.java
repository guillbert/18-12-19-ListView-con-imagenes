package com.example.semana10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.semana10.adapters.ContactoAdaptador;
import com.example.semana10.helpers.QueueUtils;
import com.example.semana10.model.contacto;

public class MainActivity extends AppCompatActivity {

    ListView List;
    ContactoAdaptador contactoAdaptador;
    QueueUtils.QueueObject queue = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = QueueUtils.getInstance(this.getApplicationContext());
      List = findViewById(R.id.List);
        contactoAdaptador = new ContactoAdaptador(this, contacto.getCollection(), queue.getImageLoader());
       List.setAdapter(contactoAdaptador);

    }
}
