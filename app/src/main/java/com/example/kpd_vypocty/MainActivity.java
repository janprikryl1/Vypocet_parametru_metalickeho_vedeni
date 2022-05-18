package com.example.kpd_vypocty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Objects;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private Button vypocet;
    private EditText R_vstup, L_vstup, C_vstup, G_vstup, f_vstup;
    private TextView Z0_vystup, gama_vystup, alfa_vystup, beta_vystup;

    private float r, L, C, G, f;
    private Complex q, w, y, aa, qq, ww, yy, bb;
    private double z1, z2, fi1, fi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vypocet = findViewById(R.id.button_vypocitat);
        R_vstup = findViewById(R.id.editTextR);
        L_vstup = findViewById(R.id.editTextL);
        C_vstup = findViewById(R.id.editTextC);
        G_vstup = findViewById(R.id.editTextG);
        f_vstup = findViewById(R.id.editTextf);
        Z0_vystup = findViewById(R.id.textView_Z0);
        gama_vystup = findViewById(R.id.textView_gama);
        alfa_vystup = findViewById(R.id.textView_alfa);
        beta_vystup = findViewById(R.id.textView_beta);

        vypocet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                String rR = R_vstup.getText().toString();
                String lL = L_vstup.getText().toString();
                String cC = C_vstup.getText().toString();
                String gG = G_vstup.getText().toString();
                String ff = f_vstup.getText().toString();


                int errors = 0;

                if (rR.isEmpty() || rR.equals("0") || rR.equals(".") || rR.equals(".0")){
                    R_vstup.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    errors++;
                }
                if (lL.isEmpty() || lL.equals("0") || lL.equals(".") || lL.equals(".0")){
                    L_vstup.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    errors++;
                }
                if (cC.isEmpty() || cC.equals("0") ||cC.equals(".") || cC.equals(".0")){
                    C_vstup.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    errors++;
                }
                if (gG.isEmpty() || gG.equals("0") || gG.equals(".") || gG.equals(".0")){
                    G_vstup.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    errors++;
                }
                if (ff.isEmpty() || ff.equals("0") || ff.equals(".") || ff.equals(".0")){
                    f_vstup.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    errors++;
                }
                if (errors>0){
                    new AlertDialog.Builder(MainActivity.this).setTitle("Pozor!!!").setMessage("Vyplňte všechny požadované hodnoty nenulově("+Integer.toString(errors)+").").show();
                    return;
                }

                r = Float.parseFloat(rR);
                L = Float.parseFloat(lL);
                C = Float.parseFloat(cC);
                G = Float.parseFloat(gG);
                f = Float.parseFloat(ff);



                q = new Complex(r, 0);
                w = new Complex(0, 2*Math.PI*f);
                y = new Complex(L, 0);

                aa = w.times(y);
                aa = aa.plus(q);


                qq = new Complex(0.000001*G,0);
                ww = new Complex(0, 2*Math.PI*f);
                yy = new Complex(0.000000001*C, 0);

                bb = ww.times(yy);
                bb = bb.plus(qq);


                z1 = Math.sqrt(Math.pow(aa.re(), 2.0)+ Math.pow(aa.im(), 2.0));
                z2 = Math.sqrt(Math.pow(bb.re(), 2.0)+ Math.pow(bb.im(), 2.0));

                fi1 = Math.toDegrees(Math.atan(aa.im()/aa.re()));
                fi2 = Math.toDegrees(Math.atan(bb.im()/bb.re()));


                Z0_vystup.setText(z0());
                gama_vystup.setText(gama());
                alfa_vystup.setText(alfa());
                beta_vystup.setText(beta());

            }
        });

            R_vstup.addTextChangedListener(new TextWatcher() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //here is your code
                    R_vstup.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }
            });
            L_vstup.addTextChangedListener(new TextWatcher() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //here is your code
                    L_vstup.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }
            });
            C_vstup.addTextChangedListener(new TextWatcher() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //here is your code
                    C_vstup.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }
            });
            G_vstup.addTextChangedListener(new TextWatcher() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //here is your code
                    G_vstup.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }
            });
            f_vstup.addTextChangedListener(new TextWatcher() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //here is your code
                    f_vstup.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }
            });
    }

    public String z0(){
        /*Complex q = new Complex(r, 0);
        Complex w = new Complex(0, 2*Math.PI*f);
        Complex y = new Complex(L, 0);

        Complex aa = w.times(y);
        aa = aa.plus(q);

        /*System.out.println("q: "+q);
        System.out.println("w: "+w);
        System.out.println("y: "+y);
        System.out.println(aa);/

        Complex qq = new Complex(0.000001*G,0);
        Complex ww = new Complex(0, 2*Math.PI*f);
        Complex yy = new Complex(0.000000001*C, 0);

        Complex bb = ww.times(yy);
        bb = bb.plus(qq);

        /*System.out.println("qq: "+qq);
        System.out.println("ww: "+ww);
        System.out.println("yy: "+yy);
        System.out.println(bb);

        double z1 = Math.sqrt(Math.pow(aa.re(), 2.0)+ Math.pow(aa.im(), 2.0));
        double z2 = Math.sqrt(Math.pow(bb.re(), 2.0)+ Math.pow(bb.im(), 2.0));

        double fi1 = Math.toDegrees(Math.atan(aa.im()/aa.re()));
        double fi2 = Math.toDegrees(Math.atan(bb.im()/bb.re()));*/

        double Z = Math.sqrt(z1/z2);
        double fi = (fi1-fi2)/2;

        String[] arr=String.valueOf(fi).split("\\.");
        int e_e = Integer.parseInt(arr[0]);
        if (arr[1].length()>3)
            arr[1] = arr[1].substring(0, 3);

        if (Double.toString(Z).length()>8) {
            Z = BigDecimal.valueOf(Z).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        return "Z0: "+Z+"  e**j "+ e_e + "°" + " " + na_minuty( Integer.parseInt(arr[1])) + "' Ω";
    }

    public String gama(){
        double real = Math.sqrt(z1*z2);
        double e = (fi1+fi2)/2;

        String[] arr=String.valueOf(e).split("\\.");
        int e_e = Integer.parseInt(arr[0]);
        if (arr[1].length()>3)
            arr[1] = arr[1].substring(0, 3);

        //Zaoukrouhlení
        if (Double.toString(real).length()>8) {
            real = BigDecimal.valueOf(real).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        }



        return  "γ: "+real+"  e**j "+ e_e + "°" + " " + na_minuty( Integer.parseInt(arr[1])) + "'";
    }


    public String alfa(){
        double real = Math.sqrt(z1*z2);
        double e = (fi1+fi2)/2;

        double result = (Math.cos(Math.toRadians(e))*real)*8.6;

        if (Double.toString(result).length()>8) {
            result = BigDecimal.valueOf(result).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        }


        return  "α: "+result+" dB/km";
    }

    public String beta(){
        double real = Math.sqrt(z1*z2);
        double e = (fi1+fi2)/2;

        double result = Math.sin(Math.toRadians(e))*real;

        if (Double.toString(result).length()>8) {
            result = BigDecimal.valueOf(result).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        return  "β: "+result+" Rad/km";
    }



    public String na_minuty(int minutes){
        minutes *= 60;
        String minuty =Integer.toString(minutes).substring(0, 3);
        String result = "";
        result += minuty.charAt(0);

        if (Integer.parseInt(String.valueOf(minuty.charAt(2)))>=5){
            result += Integer.toString(Integer.parseInt(String.valueOf(minuty.charAt(1)+1)));
        }
        else {
            result += Integer.toString(Integer.parseInt(String.valueOf(minuty.charAt(1))));
        }


        return result;
    }


    class Complex {
        private final double re;   // the real part
        private final double im;   // the imaginary part

        // create a new object with the given real and imaginary parts
        public Complex(double real, double imag) {
            re = real;
            im = imag;
        }

        // return a string representation of the invoking Complex object
        public String toString() {
            if (im == 0) return re + "";
            if (re == 0) return im + "i";
            if (im <  0) return re + " - " + (-im) + "i";
            return re + " + " + im + "i";
        }

        // return abs/modulus/magnitude
        public double abs() {
            return Math.hypot(re, im);
        }

        // return angle/phase/argument, normalized to be between -pi and pi
        public double phase() {
            return Math.atan2(im, re);
        }

        // return a new Complex object whose value is (this + b)
        public Complex plus(Complex b) {
            Complex a = this;             // invoking object
            double real = a.re + b.re;
            double imag = a.im + b.im;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is (this - b)
        public Complex minus(Complex b) {
            Complex a = this;
            double real = a.re - b.re;
            double imag = a.im - b.im;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is (this * b)
        public Complex times(Complex b) {
            Complex a = this;
            double real = a.re * b.re - a.im * b.im;
            double imag = a.re * b.im + a.im * b.re;
            return new Complex(real, imag);
        }

        // return a new object whose value is (this * alpha)
        public Complex scale(double alpha) {
            return new Complex(alpha * re, alpha * im);
        }

        // return a new Complex object whose value is the conjugate of this
        public Complex conjugate() {
            return new Complex(re, -im);
        }

        // return a new Complex object whose value is the reciprocal of this
        public Complex reciprocal() {
            double scale = re*re + im*im;
            return new Complex(re / scale, -im / scale);
        }

        // return the real or imaginary part
        public double re() { return re; }
        public double im() { return im; }

        // return a / b
        public Complex divides(Complex b) {
            Complex a = this;
            return a.times(b.reciprocal());
        }

        // return a new Complex object whose value is the complex exponential of this
        public Complex exp() {
            return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
        }

        // return a new Complex object whose value is the complex sine of this
        public Complex sin() {
            return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
        }

        // return a new Complex object whose value is the complex cosine of this
        public Complex cos() {
            return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
        }

        // return a new Complex object whose value is the complex tangent of this
        public Complex tan() {
            return sin().divides(cos());
        }



        // a static version of plus
       /* public static Complex plus(Complex a, Complex b) {
            double real = a.re + b.re;
            double imag = a.im + b.im;
            Complex sum = new Complex(real, imag);
            return sum;
        }*/

        // See Section 3.3.
        public boolean equals(Object x) {
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            Complex that = (Complex) x;
            return (this.re == that.re) && (this.im == that.im);
        }

        // See Section 3.3.
        public int hashCode() {
            return Objects.hash(re, im);
        }
    }

}

