package com.example.luishurtado.mystore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.Timer;
import java.util.TimerTask;

import cz.msebera.android.httpclient.Header;

/**
 * Created by luis.hurtado on 28/05/2018.
 */
public class FragmentHome extends Fragment {

    private ViewPager viewPager_campaigns;


    private String urlimages = "https://androidmystore.000webhostapp.com/web_services/campaings_images.php";

    private Gson gson;

    private AsyncHttpClient client;
    public static Timer timer = new Timer();

    ResponseCampaignImages responseCampaignImages;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager_campaigns = (ViewPager) view.findViewById(R.id.ViewPager);




        DescargarImagenesCampaña();

        return  view;
    }

    private void DescargarImagenesCampaña() {



        client = new AsyncHttpClient();
        client.get(getActivity(), urlimages, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseSTR = new String(responseBody);


                if (responseBody.length >= 3) {

                    gson = new Gson();
                    responseCampaignImages = gson.fromJson(responseSTR, ResponseCampaignImages.class);
                    AdapterCampaingsImages viewAdapter = new AdapterCampaingsImages(getActivity(), responseCampaignImages.getImagenes());
                    viewPager_campaigns.setAdapter(viewAdapter);


                } else if (responseBody.length <= 2) {

                    Toast.makeText(getActivity(), "Tamaño: " + responseSTR.length() + " Sin resultados", Toast.LENGTH_SHORT).show();
                    viewPager_campaigns.setBackgroundResource(R.color.salmon);

                } else if (responseBody.length <= 0) {

                    Toast.makeText(getActivity(), "Error de Servidor", Toast.LENGTH_SHORT).show();
                    viewPager_campaigns.setBackgroundResource(R.color.salmon);

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                // Toast.makeText(getApplicationContext(), "Verifica tu conexión!", Toast.LENGTH_SHORT).show();

            }
        });

        //Toast.makeText(getApplicationContext(), viewPagerResponse.getImagenes().size(), Toast.LENGTH_SHORT).show();


       timer.scheduleAtFixedRate(new TimerTS(),2000,4000);

    }

    public class  TimerTS extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {



                    if (viewPager_campaigns.getCurrentItem() == 0){
                        viewPager_campaigns.setCurrentItem(1);
                    }else if (viewPager_campaigns.getCurrentItem() == 1){
                        viewPager_campaigns.setCurrentItem(2);
                    }else if (viewPager_campaigns.getCurrentItem() == 2){
                        viewPager_campaigns.setCurrentItem(0);
                    }


                }
            });
        }
    }

}
