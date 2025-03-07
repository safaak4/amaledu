package com.safaak.amaledu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RaporClass extends ArrayAdapter<String> {

    private final ArrayList<String> ders;
    private final ArrayList<String> isim;
    private final ArrayList<String> konu;
    private final ArrayList<String> sorudakikakontrol;
    private final ArrayList<String> soruvedakika;
    private final ArrayList<String> raportarihi;
    private final ArrayList<String> kullaniciemail;
    private final Activity contextt;

    public RaporClass(ArrayList<String> ders, ArrayList<String> isim, ArrayList<String> konu, ArrayList<String> sorudakikakontrol,
                      ArrayList<String> soruvedakika, ArrayList<String> raportarihi, ArrayList<String> kullaniciemail, Activity contextt) {
        super(contextt, R.layout.custom_rapor_view, isim);
        this.ders = ders;
        this.isim = isim;
        this.konu = konu;
        this.sorudakikakontrol = sorudakikakontrol;
        this.soruvedakika = soruvedakika;
        this.raportarihi = raportarihi;
        this.kullaniciemail = kullaniciemail;
        this.contextt = contextt;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater00 = contextt.getLayoutInflater();
        View customraporview = layoutInflater00.inflate(R.layout.custom_rapor_view, null, true);

        TextView isimtextView = customraporview.findViewById(R.id.isimTextView);
        TextView tarihtextView = customraporview.findViewById(R.id.tarihTextView);
        TextView derstextView = customraporview.findViewById(R.id.dersTextView);
        TextView konutextView = customraporview.findViewById(R.id.konuTextView);
        TextView sorusayisivesuretextView = customraporview.findViewById(R.id.sorusayisivesureTextView);

        isimtextView.setText(isim.get(position));
        tarihtextView.setText(raportarihi.get(position));
        derstextView.setText(ders.get(position));
        konutextView.setText(konu.get(position));
        if (sorudakikakontrol.get(position).equals("0")){
            //dakika
            sorusayisivesuretextView.setText(soruvedakika.get(position) + "dk");
        }else{
            //soru sayisi
            sorusayisivesuretextView.setText(soruvedakika.get(position) + "soru");
        }

        return customraporview;
    }
}
