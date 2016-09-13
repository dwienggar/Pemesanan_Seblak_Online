package id.sch.smktelkom_mlg.tugas01.xiirpl1014.pemesananseblakonline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etalamat, etnohp;
    RadioGroup rgpilihan;
    RadioButton rbo, rbs;
    CheckBox cbb, cbso, cbsi;
    Spinner spP;
    Button button;
    TextView tvnama, tvalamat, tvnohp, tvpilihan, tvtopping, tvpembayaran, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etalamat = (EditText) findViewById(R.id.editTextAlamat);
        etnohp = (EditText) findViewById(R.id.editTextNohp);
        rgpilihan = (RadioGroup) findViewById(R.id.rgpilihan);
        cbb = (CheckBox) findViewById(R.id.checkBoxB);
        cbso = (CheckBox) findViewById(R.id.checkBoxSO);
        cbsi = (CheckBox) findViewById(R.id.checkBoxSI);
        spP = (Spinner) findViewById(R.id.spinnerPembayaran);
        button = (Button) findViewById(R.id.button);
        tvnama = (TextView) findViewById(R.id.textViewNama);
        tvalamat = (TextView) findViewById(R.id.textViewAlamat);
        tvnohp = (TextView) findViewById(R.id.textViewNohp);
        tvpilihan = (TextView) findViewById(R.id.textViewPilihan);
        tvtopping = (TextView) findViewById(R.id.textViewTopping);
        tvpembayaran = (TextView) findViewById(R.id.textViewPembayaran);
        tv5 = (TextView) findViewById(R.id.textView5);
        rbo = (RadioButton) findViewById(R.id.radioButtonSO);
        rbs = (RadioButton) findViewById(R.id.radioButtonSS);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doclick();
            }
        });

    }

    private void doclick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            tvnama.setText("Nama             : " + nama);
            String alamat = etalamat.getText().toString();
            tvalamat.setText("Alamat           : " + alamat);
            String nohp = etnohp.getText().toString();
            tvnohp.setText("No HP            : " + nohp);


            String pilihan = null;
            int hargapilihan = 0;
            if (rgpilihan.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgpilihan.getCheckedRadioButtonId());
                pilihan = rb.getText().toString();
                pilihan = pilihan.substring(0, 15);
            }
            if (rbo.isChecked()) {
                hargapilihan = 10000;
            } else if (rbs.isChecked()) {
                hargapilihan = 15000;
            }
            if (pilihan == null) {
                tvpilihan.setText("Pilihan           : Belum Memilih Pilihan Seblak");
            } else {
                tvpilihan.setText("Pilihan           : " + pilihan);
            }

            String topping = "";
            int harga1, harga2, harga3;
            harga1 = 0;
            harga2 = 0;
            harga3 = 0;
            int startlen = topping.length();
            if (cbb.isChecked()) {
                topping += "Bakso ";
                harga1 = 3000;
            }
            if (cbso.isChecked()) {
                topping += "Sosis ";
                harga2 = 3500;
            }
            if (cbsi.isChecked()) {
                topping += "Siomay ";
                harga3 = 4000;
            }
            if (topping.length() == startlen) topping += "Tidak memilih topping";
            tvtopping.setText("Topping         : " + topping);
            int hargatotal = hargapilihan + harga1 + harga2 + harga3;


            String pembayaran = "";
            pembayaran = spP.getSelectedItem().toString();
            int position;
            position = spP.getSelectedItemPosition();
            if (position == 1)
                pembayaran += "\nSilakan mentransfer ke bank ABC dg no rekening 1234567890 a.n Seblak Online";
            tvpembayaran.setText("Pembayaran  : " + pembayaran + " sebesar " + hargatotal);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String alamat = etalamat.getText().toString();
        String nohp = etnohp.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (alamat.isEmpty()) {
            etalamat.setError("Alamat belum diisi");
            valid = false;
        } else if (alamat.length() < 10) {
            etalamat.setError("Alamat minimal 10 karakter. Isikan alamat dengan sejelas-jelasnya.");
            valid = false;
        } else {
            etalamat.setError(null);
        }

        if (nohp.isEmpty()) {
            etnohp.setError("No HP belum diisi");
            valid = false;
        } else if (nohp.length() < 10 || nohp.length() > 13) {
            etnohp.setError("No HP tidak valid, minimal 10 angka dan tidak lebih dari 13 angka");
            valid = false;
        } else {
            etnohp.setError(null);
        }

        String pilihan = null;
        if (rgpilihan.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgpilihan.getCheckedRadioButtonId());
            pilihan = rb.getText().toString();
        }
        if (pilihan == null) {
            valid = false;
            findViewById(R.id.textView5).setVisibility(View.VISIBLE);
            tv5.setText("Anda Belum Memilih Pilihan Seblak");
        } else {
            findViewById(R.id.textView5).setVisibility(View.GONE);
        }

        return valid;
    }
}
