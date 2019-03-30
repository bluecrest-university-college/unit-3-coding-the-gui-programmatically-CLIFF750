package com.example.newcarlease;



import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.leasepaymentapp.R;

import java.text.NumberFormat;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ImageView ImageView;
    private TextView homepage;
    private InputType durationID;
    private InputType lease;
    private InputType DownPaymentID;
    private InputType CarValueID;
    private Button calculate;
    private TextView testing;
    public NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.titleID)
        tv.setSelected(true);


        durationID = (InputType) findViewById(R.id.durationID);
        lease = (InputType) findViewById(R.id.lease);
        DownPaymentID = (InputType) findViewById(R.id.downpaymentID);
        CarValueID = (InputType) findViewById(R.id.CarvalueID);
        IDcheck = (TextView) findViewById(R.id.IDcheck);
        calculate = (Button);findViewById(R.id.Calculate);



        calculate(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(durationID.getEditText().getText().toString(),
                        lease.getEditText().getText().toString(),
                        downpayment.getEditText().getText().toString(),
                        carvalue.getEditText().getText().toString());

                //monthly payment for a car rented out
                String month = durationID.getEditText().getText
                        ().toString();
                String down = leaseID.getEditText().getText
                        ().toString();
                String rate = downpaymentID.getEditText().getText().toString
                        ();
                String value = carvalue.getEditText().getText
                        ().toString();

                try {
                    //passing to the next activity to see total amount
                    through intent action
                    Intent intent = new Intent(getApplicationContext(),
                            CalculateActivity.class);
                    Bundle params = new Bundle();
                    params.putDouble("month", Double.valueOf(month));
                    params.putDouble("rate", Double.valueOf(rate));
                    params.putDouble("down", Double.valueOf(down));
                    params.putDouble("value", Double.valueOf(value));
                    intent.putExtras(params);

                    startActivity(intent);

                } catch (NumberFormatException nfe)

            }
        });
        //odd codes
           /*
        double month = Double.parseDouble(month);
        double rate = Double.parseDouble(rate);
        double down = Double.parseDouble(down);

        double amount = Double.parseDouble(amount);
        double total = 0.0;
        total = (rate / 100 * amount) * (month / down);
        testing.setText(money.format(total));
          */

    }

    private void calculate(String duration_month, String payment,
                           String leases, String amount) {

        if (duration_month.isEmpty() && payment.isEmpty() &&
                leases.isEmpty() && amount.isEmpty()) {
            duration.setError("Field cant be empty");
            lease.setError("Field cant be empty");
            dpwnpayment.setError("Field cant be empty");
            car_amount.setError("Field cant be empty");
        }else{
            duration.setError(null);
            lease.setError(null);
            downpayment.setError(null);
            carvalue.setError(null);
            calculate.setEnabled(true);
        }

    }


}
}