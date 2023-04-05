package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnZero;
    private Button btnDot;
    private Button btnEqual;
    private Button btnMulti;
    private Button btnDivide;
    private Button btnAdd;
    private Button btnSub;
    private Button btnClear;
    private Button btnPercentage;
    private Button btnPlusOrMinus;
    private TextView tvInput;
    private TextView tvOutput;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();

       try {
           btnOne.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "1");
               }
           });

           btnTwo.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "2");
               }
           });

           btnThree.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "3");
               }
           });

           btnFour.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "4");
               }
           });

           btnFive.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "5");
               }
           });

           btnSix.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "6");
               }
           });

           btnSeven.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "7");
               }
           });

           btnEight.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "8");
               }
           });

           btnNine.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "9");
               }
           });

           btnZero.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   ifErrorOnOutput();
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + "0");
               }
           });

           btnDot.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   exceedLength();
                   tvInput.setText(tvInput.getText().toString() + ".");
               }
           });

           btnPercentage.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       ACTION = MODULUS;
                       operation();
                       if (!ifReallyDecimal()) {
                           tvOutput.setText(val1 + "%");
                       } else {
                           tvOutput.setText((int) val1 + "%");
                       }
                       tvInput.setText(null);
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnAdd.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       ACTION = ADDITION;
                       operation();
                       if (!ifReallyDecimal()) {
                           tvOutput.setText(val1 + "+");
                       } else {
                           tvOutput.setText((int) val1 + "+");
                       }
                       tvInput.setText(null);
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnSub.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       ACTION = SUBTRACTION;
                       operation();
                       if (tvInput.getText().length() > 0)
                           if (!ifReallyDecimal()) {
                               tvOutput.setText(val1 + "-");
                           } else {
                               tvOutput.setText((int) val1 + "-");
                           }
                       tvInput.setText(null);
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnMulti.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       ACTION = MULTIPLICATION;
                       operation();
                       if (!ifReallyDecimal()) {
                           tvOutput.setText(val1 + "×");
                       } else {
                           tvOutput.setText((int) val1 + "×");
                       }
                       tvInput.setText(null);
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnDivide.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       ACTION = DIVISION;
                       operation();
                       if (ifReallyDecimal()) {
                           tvOutput.setText((int) val1 + "/");
                       } else {
                           tvOutput.setText(val1 + "/");
                       }
                       tvInput.setText(null);
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnPlusOrMinus.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (!tvOutput.getText().toString().isEmpty() || !tvInput.getText().toString().isEmpty()) {
                       val1 = Double.parseDouble(tvInput.getText().toString());
                       ACTION = EXTRA;
                       tvOutput.setText("-" + tvInput.getText().toString());
                       tvInput.setText("");
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnEqual.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       operation();
                       ACTION = EQU;
                       if (!ifReallyDecimal()) {
                           tvOutput.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf(val1));
                       } else {
                           tvOutput.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf((int) val1));
                       }
                       tvInput.setText(null);
                   } else {
                       tvOutput.setText("Error");
                   }
               }
           });

           btnClear.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (tvInput.getText().length() > 0) {
                       CharSequence name = tvInput.getText().toString();
                       tvInput.setText(name.subSequence(0, name.length() - 1));
                   } else {
                       val1 = Double.NaN;
                       val2 = Double.NaN;
                       tvInput.setText("");
                       tvOutput.setText("");
                   }
               }
           });

           // Empty text views on long click.
           btnClear.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View view) {
                   val1 = Double.NaN;
                   val2 = Double.NaN;
                   tvInput.setText("");
                   tvOutput.setText("");
                   return true;
               }
           });
       }catch (Exception e){
           System.out.println(e);
           Toast.makeText(this, "Unknown Error Occurred!!", Toast.LENGTH_SHORT).show();
       }
    }


    private boolean ifReallyDecimal() {
        return val1 == (int) val1;
    }

    private void operation() {
        if (!Double.isNaN(val1)) {
            if (tvOutput.getText().toString().charAt(0) == '-') {
                val1 = (-1) * val1;
            }
            val2 = Double.parseDouble(tvInput.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EXTRA:
                    val1 = (-1) * val1;
                    break;
                case MODULUS:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(tvInput.getText().toString());
        }
    }

    private void exceedLength() {
        if (tvInput.getText().toString().length() > 10) {
            tvInput.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }

    private void ifErrorOnOutput() {
        if (tvOutput.getText().toString().equals("Error")) {
            tvOutput.setText("");
        }
    }

    private void viewSetup() {
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);
        btnDot = findViewById(R.id.btnDot);
        btnPercentage = findViewById(R.id.btnPercentage);

        btnEqual = findViewById(R.id.btnEqual);

        btnClear = findViewById(R.id.btnClear);
        btnPlusOrMinus = findViewById(R.id.btnPlusOrMinus);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);
    }
}