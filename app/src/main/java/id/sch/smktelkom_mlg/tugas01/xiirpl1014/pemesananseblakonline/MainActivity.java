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
    CheckBox cbb, cbso, cbsi;
    Spinner spP;
    Button button;
    TextView tvnama, tvalamat, tvnohp, tvpilihan, tvtopping, tvpembayaran;

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

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doclick();
            }
        });

    }

    private void doclick() {
        String nama = etNama.getText().toString();
        tvnama.setText("Nama             : " + nama);
        String alamat = etalamat.getText().toString();
        tvalamat.setText("Alamat           : " + alamat);
        String nohp = etnohp.getText().toString();
        tvnohp.setText("No HP            : " + nohp);


        String pilihan = null;
        if (rgpilihan.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgpilihan.getCheckedRadioButtonId());
            pilihan = rb.getText().toString();
            pilihan = pilihan.substring(0, 15);
        }
        if (pilihan == null) {
            tvpilihan.setText("Pilihan           : Belum Memilih Pilihan Seblak");
        } else {
            tvpilihan.setText("Pilihan           : " + pilihan);
        }


        String topping = "";
        int startlen = topping.length();
        if (cbb.isChecked()) topping += "Bakso ";
        if (cbso.isChecked()) topping += "Sosis ";
        if (cbsi.isChecked()) topping += "Siomay ";
        if (topping.length() == startlen) topping += "Tidak memakai topping";
        tvtopping.setText("Topping         : " + topping);


        String pembayaran = "";
        pembayaran = spP.getSelectedItem().toString();
        int position;
        position = spP.getSelectedItemPosition();
        if (position == 1)
            pembayaran += "\nSilakan mentransfer ke bank ABC dg no rekening 1234567890 a.n Seblak Online";
        tvpembayaran.setText("Pembayaran  : " + pembayaran);
    }
}
