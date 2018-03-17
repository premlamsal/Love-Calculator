package np.com.premlamsal.lovecalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        final TextView showpercentage,about,about_calculator;
        final EditText yourname,lovename;
        btn=findViewById(R.id.btn);
        yourname=findViewById(R.id.yourname);
        lovename=findViewById(R.id.lovename);
        about=findViewById(R.id.about);
        about_calculator=findViewById(R.id.about_calculator);
        showpercentage=findViewById(R.id.showpercentage);
        about_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String name1,name2;
                int totname1=0,totname2=0;
                int per;
                Variables.result=0;
                name1=yourname.getText().toString();
                name1=name1.toUpperCase();
                name2=lovename.getText().toString();
                name2= name2.toUpperCase();
                if(name1.isEmpty()&&name2.isEmpty()){
                    yourname.setError("Enter Your Name");
                    lovename.setError("Enter Your Love Name");
                }
                else {
                    for (int i = 0; i < name1.length(); i++) {
                        char c = name1.charAt(i);
                        int j = (int) c;
                        totname1 += j;
                    }
                    for (int i = 0; i < name2.length(); i++) {
                        char c = name2.charAt(i);
                        int j = (int) c;
                        totname2 += j;
                    }
                    if(totname1>totname2){
                        per = totname1 % totname2;
                        if(per>=100){
                            per=100;
                        }

                        Variables.result=per;
                        Intent res_act=new Intent(MainActivity.this,Result.class);
                        startActivity(res_act);
                      //  showpercentage.setText(String.valueOf(per) +"%");
                    }
                    else{
                        per = totname2 % totname1;
                        if(per>=100){
                            per=100;
                        }
                     //   showpercentage.setText(String.valueOf(per) +"%");
                        Variables.result=per;

                        Intent res_act=new Intent(MainActivity.this,Result.class);
                        startActivity(res_act);
                    }


                }
            }
        });

    }
}
