package com.bellukstudio.kalkulatorbangun.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bellukstudio.kalkulatorbangun.R;

public class CalculateActivity extends AppCompatActivity {

    TextView titleField;
    Intent intent;
    TextView label1;
    TextView label2;
    TextView label3;
    EditText editTextData1;
    EditText editTextData2;
    EditText editTextData3;
    Button btnCalculate;
    TextView resultLabel;
    //variable
    double number1, number2, number3;
    double rumus;
    String combineResult;
    protected CalculateBidang calculateBidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        titleField = findViewById(R.id.titleField);
        label1 = findViewById(R.id.labelData1);
        label2 = findViewById(R.id.labelData2);
        label3 = findViewById(R.id.labelData3);
        editTextData1 = findViewById(R.id.data1);
        editTextData2 = findViewById(R.id.data2);
        editTextData3 = findViewById(R.id.data3);
        btnCalculate = findViewById(R.id.btnCalculate);
        resultLabel = findViewById(R.id.resultCalculate);
        //instantiate
        calculateBidang = new CalculateBidang();
        /// get data from on click listView
        intent = getIntent();
        String dataTitleField = intent.getStringExtra("namaBidang");
        String dataRumusBidang = intent.getStringExtra("rumusBidang");
        String extendTitle = dataRumusBidang + "\n" + dataTitleField;
        titleField.setText(extendTitle);
        // bangun datar
        if (dataTitleField.equalsIgnoreCase("Persegi")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Keliling")) {
                oneEditText("Sisi");
            }
        } else if (dataTitleField.equalsIgnoreCase("Segitiga")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                twoEditText("Alas", "Tinggi");
            } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                oneEditText("Alas");
            }

        } else if (dataTitleField.equalsIgnoreCase("Lingkaran")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Keliling")) {
                oneEditText("Jari - Jari");

            }
        } else if (dataTitleField.equalsIgnoreCase("Persegi Panjang")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Keliling")) {
                twoEditText("Panjang", "Lebar");

            }
        } else if (dataTitleField.equalsIgnoreCase("Belah Ketupat")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                twoEditText("Diagonal 1", "Diagonal 2");

            } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                oneEditText("Sisi");
            }
        } else if (dataTitleField.equalsIgnoreCase("Jajar Genjang")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                twoEditText("Alas", "Tinggi");

            } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                twoEditText("Sisi 1", "Sisi 2");
            }

            // bangun ruang
        } else if (dataTitleField.equalsIgnoreCase("Kubus")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Keliling") || dataRumusBidang.equalsIgnoreCase("Volume")) {
                oneEditText("Sisi");
            }

        } else if (dataTitleField.equalsIgnoreCase("Balok")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Keliling") || dataRumusBidang.equalsIgnoreCase("Volume")) {
                threeEditText("Panjang", "Lebar", "Tinggi");
            }

        } else if (dataTitleField.equalsIgnoreCase("Tabung")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Keliling")) {
                oneEditText("Jari - jari");
            } else if (dataRumusBidang.equalsIgnoreCase("Volume")) {
                twoEditText("Jari - jari", "Tinggi");
            }
        } else if (dataTitleField.equalsIgnoreCase("Kerucut")) {
            if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                twoEditText("Jari - jari", "Sisi");
            } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                oneEditText("Jari - jari");

            } else if (dataRumusBidang.equalsIgnoreCase("Volume")) {
                twoEditText("Jari - Jari", "Tinggi");
            }
        } else if (dataTitleField.equalsIgnoreCase("Bola")) {
            if(dataRumusBidang.equalsIgnoreCase("Luas") || dataRumusBidang.equalsIgnoreCase("Volume")){
                oneEditText("Jari - jari");
            }
        }


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //convert data from edit text to double
                convertDouble();
                if (dataTitleField.equalsIgnoreCase("Persegi")) {
                    //convert value edit text to double
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        //calculate
                        rumus = number1 * number1;
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        //calculate
                        rumus = 4 * number1;
                        calculateKeliling(rumus);
                    }

                } else if (dataTitleField.equalsIgnoreCase("Segitiga")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = (number1 * number2) / 2;
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        rumus = number1 + number1 + number1;
                        calculateKeliling(rumus);
                    }

                } else if (dataTitleField.equalsIgnoreCase("Lingkaran")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = Math.PI * Math.pow(number1, 2);
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        double diamater = number1 * 2;
                        rumus = Math.PI * diamater;
                        calculateKeliling(rumus);
                    }
                } else if (dataTitleField.equalsIgnoreCase("Persegi Panjang")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = number1 * number2;
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        rumus = 2 * (number1 + number2);
                        calculateKeliling(rumus);
                    }
                } else if (dataTitleField.equalsIgnoreCase("Belah Ketupat")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = number1 * number2 * 0.5;
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        rumus = 4 * number1;
                        calculateKeliling(rumus);
                    }
                } else if (dataTitleField.equalsIgnoreCase("Jajar Genjang")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = number1 * number2;
                        calculateLuas(rumus);

                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        rumus = 2 * (number1 + number2);
                        calculateKeliling(rumus);
                    }
                } else if (dataTitleField.equalsIgnoreCase("Kubus")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = 6 * number1;
                        calculateLuas(rumus);

                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        rumus = 12 * number1;
                        calculateKeliling(rumus);

                    } else if (dataRumusBidang.equalsIgnoreCase("Volume")) {
                        rumus = number1 * number1 * number1;
                        calculateVolume(rumus);

                    }
                } else if (dataTitleField.equalsIgnoreCase("Balok")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = 2 * ((number1 * number2) + (number1 * number3) + (number2 * number3));
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        rumus = 4 * (number1 + number2 + number3);
                        calculateKeliling(rumus);

                    } else if (dataRumusBidang.equalsIgnoreCase("Volume")) {
                        rumus = number1 * number2 * number3;
                        calculateVolume(rumus);

                    }
                } else if (dataTitleField.equalsIgnoreCase("Tabung")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = Math.PI * Math.pow(number1, 2);
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        double diamater = number1 * 2;
                        rumus = Math.PI * diamater;
                        calculateKeliling(rumus);

                    } else if (dataRumusBidang.equalsIgnoreCase("Volume")) {
                        rumus = (Math.PI * Math.pow(number1, 2)) * number2;
                        calculateVolume(rumus);

                    }
                } else if (dataTitleField.equalsIgnoreCase("Kerucut")) {
                    if (dataRumusBidang.equalsIgnoreCase("Luas")) {
                        rumus = Math.PI * number1 * (number1 + number2);
                        calculateLuas(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Keliling")) {
                        double diamater = number1 * 2;
                        rumus = Math.PI * diamater;
                        calculateKeliling(rumus);
                    } else if (dataRumusBidang.equalsIgnoreCase("Volume")) {
                        rumus =  Math.PI * Math.pow(number1, 2) * number2 / 3 * 1;
                        calculateVolume(rumus);
                    }
                } else if (dataTitleField.equalsIgnoreCase("Bola")) {
                    if(dataRumusBidang.equalsIgnoreCase("Luas")){
                        rumus = 4 * Math.PI * Math.pow(number1,2);
                        calculateLuas(rumus);
                    }else if(dataRumusBidang.equalsIgnoreCase("Volume")){
                        rumus = Math.PI * Math.pow(number1,3) / 3 * 4;
                        calculateVolume(rumus);
                    }
                }
            }

        });

    }

    void convertDouble() {
        // convert string to double
        String num1 = editTextData1.getText().toString();
        String num2 = editTextData2.getText().toString();
        String num3 = editTextData3.getText().toString();
        number1 = Double.parseDouble(num1);
        number2 = Double.parseDouble(num2);
        number3 = Double.parseDouble(num3);
    }

    void convertDoubleToString(double luas) {
        String result = String.valueOf(luas);
        combineResult = "Hasil " + result;
    }

    void calculateLuas(double data) {
        calculateBidang.setLuas(data);
        //show in textview
        convertDoubleToString(calculateBidang.getLuas());
        resultLabel.setText(combineResult);
    }

    void calculateVolume(double data) {
        calculateBidang.setVolume(data);
        //show in textview
        convertDoubleToString(calculateBidang.getVolume());
        resultLabel.setText(combineResult);
    }

    void calculateKeliling(double data) {
        calculateBidang.setKeliling(data);
        //show in textview
        convertDoubleToString(calculateBidang.getKeliling());
        resultLabel.setText(combineResult);
    }

    void oneEditText(String label) {
        //change label
        label1.setText(label);
        editTextData2.setText("0");
        editTextData3.setText("0");
        //hidden component
        editTextData2.setVisibility(View.GONE);
        editTextData3.setVisibility(View.GONE);
        label2.setVisibility(View.GONE);
        label3.setVisibility(View.GONE);
    }

    void twoEditText(String l1, String l2) {
        label1.setText(l1);
        label2.setText(l2);
        editTextData3.setText("0");
        editTextData3.setVisibility(View.GONE);
        label3.setVisibility(View.GONE);
    }

    void threeEditText(String l1, String l2, String l3) {
        label1.setText(l1);
        label2.setText(l2);
        label3.setText(l3);
    }
}