package com.example.news_app;

import android.graphics.Movie;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.news_app.model.Films;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import static com.example.news_app.utils.NetworkUtils.generalURL;
//import static com.example.news_app.utils.NetworkUtils.getResponseFromURL;
//
//asdasfasdsafsdfwafsdfa
public class MainActivity extends AppCompatActivity {

    private  static final String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=4e1808f48673a589b0697bd4184f1edc";
    List<Films> filmsList;
    RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        result = findViewById(R.id.filmTitle);
//        search = findViewById(R.id.searchView);

        filmsList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        

        FilmQuery filmQuery = new FilmQuery();
        filmQuery.execute();
    }


//    TextView result;
//    EditText search;
//
//
//
    class FilmQuery extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... urls) {

         String current = "";

         try {

         URL url;
            HttpURLConnection urlConnection = null;
           try {
               url = new URL(JSON_URL);
               urlConnection = (HttpURLConnection) url.openConnection();

               InputStream inputStream = urlConnection.getInputStream();
               InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

               int data = inputStreamReader.read();
               while (data != -1) {
                   current += (char) data;
                   data = inputStreamReader.read();
               }

               return current;

           }catch (MalformedURLException e){
               e.printStackTrace();
        }    catch (IOException e) {
               e.printStackTrace();
           } finally {
               if (urlConnection != null){
                   urlConnection.disconnect();
               }
           }
           } catch (Exception e) {
             e.printStackTrace();
         }

         return current;

        }


        @Override
        protected void onPostExecute(String s){

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    Films model = new Films();
                    model.setFilmTitle(jsonObject1.getString("title"));
                    model.setFilmId(jsonObject1.getInt("id"));
                    model.setFilmDate(jsonObject1.getString("release_date"));
                    model.setFilmDesc(jsonObject1.getString("overview"));
                    model.setFilmRating(jsonObject1.getString("vote_average"));
                    model.setFilmImage(jsonObject1.getString("poster_path"));
                    filmsList.add(model);

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
            PutDateIntoRecyclerView(filmsList);

        }
    }

    private void PutDateIntoRecyclerView(List<Films> filmsList) {

        FilmAdapter filmAdapter = new FilmAdapter(this,filmsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(filmAdapter);
    }


}
//
//
//
//    public void Onclick(View view){
//        URL generatedURL = generalURL("550");
//        new FilmQuery().execute(generatedURL);
//    }
