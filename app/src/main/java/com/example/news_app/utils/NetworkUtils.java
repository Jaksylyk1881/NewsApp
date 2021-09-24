//package com.example.news_app.utils;
//
//import android.net.Uri;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Scanner;
//
//public class NetworkUtils {
//    private static final String API_BASE = "https://api.themoviedb.org";
//    private static final String FILMS_GET = "/3/movie/";
//    private static final String API_KEY = "api_key";
//
//
//    public static URL generalURL(String movie_id){
//        Uri builtUri = Uri.parse(API_BASE+FILMS_GET+movie_id+"?api_key="+API_KEY);
//        URL url = null;
//        try {
//            url = new URL(builtUri.toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return url;
//    }
//
//    public static String getResponseFromURL(URL url) throws IOException {
//
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//       try {
//
//           InputStream in = urlConnection.getInputStream();
//           Scanner scanner = new Scanner(in);
//           scanner.useDelimiter("\\A");
//
//           boolean hasInput = scanner.hasNext();
//           if (hasInput) {
//               return scanner.next();
//           } else {
//               return null;
//           }
//       } finally {
//           urlConnection.disconnect();
//       }
//    }
//}
