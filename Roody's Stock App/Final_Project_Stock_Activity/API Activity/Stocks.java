package com.fau_cop4655_Z23572422.mystockapppoc;

import com.google.gson.annotations.SerializedName;

public class Stocks {
    // Declare each serialized name for GSON request
    @SerializedName("01. symbol")private String symbol;
    @SerializedName("02. open")private String open;
    @SerializedName("03. high")private String high;
    @SerializedName("04. low")private String low;
    @SerializedName("05. price")private String price;
    @SerializedName("06. volume")private String volume;
    @SerializedName("07. latest trading day") private String latest_trading_day;
    @SerializedName("08. previous close") private String previous_close;
    @SerializedName("09. change")private String change;
    @SerializedName("10. change percent") private String change_percent;

    // Declare the "Set" methods
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public void setOpen(String open){
        this.open = open;
    }

    public void setHigh(String high){
        this.high = high;
    }

    public void setLow(String low){
        this.low = low;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setVolume(String volume){
        this.volume = volume;
    }

    public void setLatest_trading_day(String ltd){
        this.latest_trading_day = ltd;
    }

    public void setChange(String c){
        this.change = c;
    }

    public void setPrevious_close(String pc){
        this.previous_close = pc;
    }

    public void setChange_percent(String cp){
        this.change_percent = cp;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String getOpen(){
        return this.open;
    }

    public String getHigh(){
        return this.high;
    }

    // Declare the "Get" methods
    public String getLow(){
        return this.low;
    }

    public String getPrice(){
        return this.price;
    }

    public String getVolume(){
        return this.volume;
    }

    public String getChange(){
        return this.change;
    }

    public String getLatest_trading_day(){
        return this.latest_trading_day;
    }

    public String getPrevious_close(){
        return this.previous_close;
    }

    public String getChange_percent(){
        return this.change_percent;
    }

}
