package redcarpet.com.br.driver.Activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckInternet {
    public static boolean isNetwork(Context context) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public static boolean isNotNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();

    }
}

/*
public static void isInternetAccessWorking(Context context, final InternetAccessListener listener) {

    StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.google.com",
            new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    listener.hasInternet(true);
                }
            },
            new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   listener.hasInternet(false);
               }
    });

    Volley.newRequestQueue(context).add(stringRequest);
}
 */
