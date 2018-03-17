package np.com.premlamsal.lovecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView innerheart;
        innerheart=findViewById(R.id.innerheart);
        int getres=Variables.result;
        innerheart.setText(String.valueOf(getres)+"%");
    }
}
