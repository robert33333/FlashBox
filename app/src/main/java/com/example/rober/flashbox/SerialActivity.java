package com.example.rober.flashbox;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rober.flashbox.date.Comanda;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.Episod;
import com.example.rober.flashbox.date.EpisodFavorit;
import com.example.rober.flashbox.date.Serial;
import com.example.rober.flashbox.date.Sezon;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.rober.flashbox.date.DataBase.ois;
import static com.example.rober.flashbox.date.DataBase.oos;
import static com.example.rober.flashbox.date.DataBase.serialCurent;

public class SerialActivity extends AppCompatActivity {
    private static int idEpisod=-1;
    private static final ArrayList<TextView> viewSezoane = new ArrayList<>();
    private static final ArrayList<TextView> viewEpisoade = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (DataBase.socket == null) {
                        DataBase.initialize();
                    }
                    Comanda cmd = new Comanda("get serial", DataBase.serialCurent.getNume());
                    oos.writeObject(cmd);
                    DataBase.serialCurent = (Serial) ois.readObject();
                    DataBase.getEpisoadeFavorite();
                    for (EpisodFavorit e: DataBase.episoadeFavorite) {
                        if (serialCurent.getNume().equals(e.getNumeSerial())){
                            idEpisod = e.getIdEpisod();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ImageView poza = findViewById(R.id.poza_serial);
        Glide.with(this).load(serialCurent.getLink_poza()).into(poza);
        TextView titlu = findViewById(R.id.title);
        titlu.setText(serialCurent.getNume());
        titlu.setTextAppearance(this, R.style.BoldMov);
        TextView descriere = findViewById(R.id.description);
        descriere.setText(serialCurent.getDescriere());
        descriere.setTextAppearance(this, R.style.DefaultMov);
        descriere.setTextSize(15);

        TextView season = findViewById(R.id.season);
        season.setTextAppearance(this, R.style.BoldMov);
        season.setTextSize(25);
        TextView episode = findViewById(R.id.episode);
        episode.setTextAppearance(this, R.style.BoldMov);
        episode.setTextSize(25);

        final LinearLayout listaSezoane = findViewById(R.id.lista_sezoane);
        if(serialCurent.getListaSezoane() != null) {
            viewSezoane.clear();
            for (Sezon sezon : serialCurent.getListaSezoane()) {
                final TextView tv = new TextView(this);
                tv.setText(sezon.getNumar()+" ");
                tv.setTextAppearance(getApplicationContext(), R.style.DefaultMov);
                listaSezoane.addView(tv);
                viewSezoane.add(tv);
                tv.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(View view) {
                        viewEpisoade.clear();
                        for(View v: viewSezoane) {
                            TextView vv = (TextView)v;
                            vv.setTextAppearance(getApplicationContext(), R.style.DefaultMov);
                            v.setBackground(null);
                        }
                        tv.setTextAppearance(getApplicationContext(), R.style.DefaultRoz);
                        LinearLayout listaEpisoade = findViewById(R.id.lista_episoade);
                        if(listaEpisoade.getChildCount() > 0)
                            listaEpisoade.removeAllViews();
                            final Sezon sezonCurent = DataBase.serialCurent.getListaSezoane().get(Integer.parseInt(tv.getText().toString().trim())-1);
                        for(final Episod episod: sezonCurent.getListaEpisoade()) {
                            final TextView tv2 = new TextView(getApplicationContext());
                            tv2.setText(episod.getNumar()+" ");
                            tv2.setTextAppearance(getApplicationContext(), R.style.DefaultMov);
                            tv2.setTextSize(30);
                            listaEpisoade.addView(tv2);
                            viewEpisoade.add(tv2);
                            tv2.setOnClickListener(new View.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onClick(View view) {
                                    for(View v: viewEpisoade) {
                                        TextView vv = (TextView)v;
                                        vv.setTextAppearance(getApplicationContext(), R.style.DefaultMov);
                                        v.setBackground(null);
                                    }
                                    tv2.setTextAppearance(getApplicationContext(), R.style.DefaultRoz);
                                    LinearLayout detaliiEpisodNume = findViewById(R.id.layout_episoade_nume);
                                    if(detaliiEpisodNume.getChildCount() > 0)
                                        detaliiEpisodNume.removeAllViews();
                                    LinearLayout detaliiEpisodDescriere = findViewById(R.id.layout_episoade_descriere);
                                    if(detaliiEpisodDescriere.getChildCount() > 0)
                                        detaliiEpisodDescriere.removeAllViews();
                                    final Episod episodCurent = sezonCurent.getListaEpisoade().get(Integer.parseInt(tv2.getText().toString().trim())-1);

                                    TextView titluTitlu = new TextView(getApplicationContext());
                                    titluTitlu.setText("Titlu episod: ");
                                    titluTitlu.setTextAppearance(getApplicationContext(), R.style.DefaultMov);
                                    titluTitlu.setTextSize(25);
                                    TextView titlu = new TextView(getApplicationContext());
                                    titlu.setText(episodCurent.getNume());
                                    titlu.setTextSize(30);

                                    TextView titluDescriere = new TextView(getApplicationContext());
                                    titluDescriere.setText("Descriere: ");
                                    titluDescriere.setTextAppearance(getApplicationContext(), R.style.DefaultMov);
                                    titluDescriere.setTextSize(25);
                                    TextView descriere = new TextView(getApplicationContext());
                                    descriere.setText(episodCurent.getDescriere());
                                    descriere.setTextSize(30);

                                    detaliiEpisodNume.addView(titluTitlu);
                                    detaliiEpisodNume.addView(titlu);

                                    detaliiEpisodDescriere.addView(titluDescriere);
                                    detaliiEpisodDescriere.addView(descriere);

                                    // Buton favorite
                                    final ImageButton imageButton = new ImageButton(getApplicationContext());
                                    imageButton.setBackground(null);
                                    if (idEpisod == episodCurent.getId()) {
                                        DataBase.isChecked = true;
                                        imageButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.btn_star_big_on));
                                    }
                                    else {
                                        DataBase.isChecked = false;
                                        imageButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
                                    }
                                    LinearLayout layoutsteluta = findViewById(R.id.layout_episoade_steluta);
                                    if(layoutsteluta.getChildCount() > 0)
                                        layoutsteluta.removeAllViews();
                                    layoutsteluta.addView(imageButton);
                                    imageButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(!DataBase.isChecked) {
                                                DataBase.isChecked = true;
                                                imageButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.btn_star_big_on));
                                                idEpisod  = episodCurent.getId();
                                            }

                                            else {
                                                idEpisod = episodCurent.getId()+500;
                                                DataBase.isChecked = false;
                                                imageButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        //do stuff

        if (idEpisod > 0) {
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        if (DataBase.socket == null) {
                            DataBase.initialize();
                        }
                        Comanda cmd = new Comanda("update episod favorit", new EpisodFavorit(DataBase.utilizatorCurent.getIdUtilizator(), idEpisod));
                        oos.writeObject(cmd);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread myThread = new Thread(myRunnable);
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.onBackPressed();
    }
}


