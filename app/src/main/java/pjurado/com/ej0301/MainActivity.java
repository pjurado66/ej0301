package pjurado.com.ej0301;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacto> directorio = new ArrayList<>();
    private RecyclerView myRecyclerView;
    private AdapterDirectorio myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creaDatos();

        myRecyclerView = findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);

        myAdapter = new AdapterDirectorio(directorio);

        myRecyclerView.setAdapter(myAdapter);

    }

    private void creaDatos(){
        directorio.add(new Contacto("Pedro Jurado", "987123456", "pjurado@gmail.com", R.drawable.foto));
        directorio.add(new Contacto("Pepe Pérez", "987121256", "ppe@gmail.com", R.drawable.foto));
        directorio.add(new Contacto("Antonio Gómex", "934643456", "aoox@gmail.com", R.drawable.foto));
    }
}