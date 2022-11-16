package com.fau_cop4655_Z23572422.mystockapppoc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fau_cop4655_Z23572422.mystockapppoc.R;

import java.util.ArrayList;

public class StockSearchFragment extends Fragment {

    EditText mQuery;
    ImageButton mSearch;
    ListView mList;
    ArrayList<StockHistory> mStocks;
    // Initialize string to Favorites
    String[] mTestStocks = {"IBM","AAPL"};
    ListView mStockListView;
    StockListAdapter mStockListAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        mStocks = new ArrayList<StockHistory>();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AlphaVantage av = AlphaVantage.getInstance();
        mStockListView = getView().findViewById(R.id.searchView);
        StockHistory stonk;
        for(String s : mTestStocks){
            stonk = av.getStock(s);
            if(stonk != null){
                mStocks.add(stonk);
            }

        }
        mStockListAdapter = new StockListAdapter(getContext(),mStocks);
        mStockListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Add code here to do what you want when an Item is clicked
                //Toast.makeText(getContext(), mStocks.get(i).getSymbol().toString(), Toast.LENGTH_SHORT).show();
                if(LoginActivity.isFav(mStocks.get(i).getSymbol())){
                    LoginActivity.remFav(mStocks.get(i).getSymbol());
                    Toast.makeText(getContext(), mStocks.get(i).getSymbol() + " REMOVED FROM FAVORITES", Toast.LENGTH_SHORT).show();
                }
                else{
                    LoginActivity.addFav(mStocks.get(i).getSymbol());
                    Toast.makeText(getContext(), mStocks.get(i).getSymbol() + " ADDED TO FAVORITES", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mStockListView.setAdapter(mStockListAdapter);
        mSearch = getView().findViewById(R.id.searchButton);
        mQuery = getView().findViewById(R.id.query);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch();
            }
        });

    }

    // Search for user specified stocks
    public void onSearch(){
        //TODO: Validation
        AlphaVantage av = AlphaVantage.getInstance();
        String q = mQuery.getText().toString();
        StockHistory stk = av.getStock(q);
        if (stk != null) {
            mStocks.add(stk);
        }
        mStockListView.setAdapter(mStockListAdapter);


    }
}
