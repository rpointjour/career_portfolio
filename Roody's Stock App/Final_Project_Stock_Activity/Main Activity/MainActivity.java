package com.fau_cop4655_Z23572422.mystockapppoc;

import androidx.appcompat.app.AppCompatActivity;

// Import class "recyclerview" to implement recycler view
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Import Volley Class to implement Volley methods
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create string to display the stocks from GSON
    private final String[] stocks = {"IBM", "AAPL", "GOOGL", "AMZN", "TSLA"};
    // Declare array to display place the stocks
    private ArrayList<Stocks> theStocks;
    RecyclerView example;
    // Use Stock adapter for Recycler View
    StockRecyclerAdapter exampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content for activity_stock
        setContentView(R.layout.activity_stock);

        theStocks = new ArrayList<Stocks>();
        example = findViewById(R.id.recycler);
        // Get the stocks from the API
        for (String s : stocks) {
            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol={{REPLACE_KEY}}&apikey= {}".replace("{{REPLACE_KEY}}", s);
            RequestQueue queue = Volley.newRequestQueue(this);

            // Use Gson to request stock data from Global Quote
            GsonRequest<GlobalQuote> req = new GsonRequest<GlobalQuote>(url, GlobalQuote.class, null, new Response.Listener<GlobalQuote>() {
                @Override
                public void onResponse(GlobalQuote response) {

                    System.out.println("Successful Response");
                    System.out.println(response.getGlobalQuote().getSymbol());
                    theStocks.add(response.getGlobalQuote());

                    if (theStocks.size() == stocks.length) {
                        doView();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("That didn't work!");
                }
            });

            queue.add(req);

        }


    }
    // Method to display the stock from Recycler View using the adapter
    private void doView() {
        exampleAdapter = new StockRecyclerAdapter(theStocks);
        example.setAdapter(exampleAdapter);
        example.setLayoutManager(new LinearLayoutManager(this));
    }

    // Move to the News Activity upon "newsButton" click
    public void onSigninClick(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        TextView sn = (TextView) findViewById(R.id.newsButton);
        String message = sn.getText().toString();
        startActivity(intent);
    }


}
