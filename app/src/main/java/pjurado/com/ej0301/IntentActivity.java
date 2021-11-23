package pjurado.com.ej0301;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {
    private Contacto persona;
    private Button email;
    private Button llamar;
    private TextView tvNombre;
    private ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        email = findViewById(R.id.buttonEmail);
        llamar = findViewById(R.id.buttonLlamar);
        tvNombre = findViewById(R.id.textViewIntentNombre);
        ivFoto = findViewById(R.id.imageView2);

        persona = getIntent().getParcelableExtra("persona");
        Toast.makeText(this, persona.getNombre(), Toast.LENGTH_SHORT).show();

        tvNombre.setText(persona.getNombre());
        ivFoto.setImageResource(persona.getFoto());

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llama(persona.getEmail());
            }
        });

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(persona.getTelefono());
            }
        });
    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void llama(String email){
        // Create the text message with a string
        String[] destinatario= {""};
        destinatario[0] = email;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_EMAIL, destinatario);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "textMessage");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto de email de prueba");
        //sendIntent.setType("text/plain");
        sendIntent.setType("message/rfc822");

        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }
}