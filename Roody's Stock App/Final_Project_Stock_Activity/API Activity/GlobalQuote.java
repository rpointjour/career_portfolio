package com.fau_cop4655_Z23572422.mystockapppoc;

import com.google.gson.annotations.SerializedName;

// Use GlobalQuote class to access global quote data from API
public class GlobalQuote {
    @SerializedName("Global Quote") private Stocks globalQuote;

    public void setGlobalQuote(Stocks s){
        this.globalQuote = s;
    }

    public Stocks getGlobalQuote(){
        return this.globalQuote;
    }

}
