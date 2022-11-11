package com.example.cryptoexchange.externalRequests;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "symbol",
        "name",
        "image",
        "current_price",
        "market_cap",
        "market_cap_rank",
        "fully_diluted_valuation",
        "total_volume",
        "high_24h",
        "low_24h",
        "price_change_24h",
        "price_change_percentage_24h",
        "market_cap_change_24h",
        "market_cap_change_percentage_24h",
        "circulating_supply",
        "total_supply",
        "max_supply",
        "ath",
        "ath_change_percentage",
        "ath_date",
        "atl",
        "atl_change_percentage",
        "atl_date",
        "roi",
        "last_updated"
})
@Generated("jsonschema2pojo")
public class CGCryptocurrency {

    @JsonProperty("id")
    private String id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("current_price")
    private Double currentPrice;
    @JsonProperty("market_cap")
    private Long marketCap;
    @JsonProperty("market_cap_rank")
    private Integer marketCapRank;
    @JsonProperty("fully_diluted_valuation")
    private Object fullyDilutedValuation;
    @JsonProperty("total_volume")
    private Double totalVolume;
    @JsonProperty("high_24h")
    private Double high24h;
    @JsonProperty("low_24h")
    private Double low24h;
    @JsonProperty("price_change_24h")
    private Double priceChange24h;
    @JsonProperty("price_change_percentage_24h")
    private Double priceChangePercentage24h;
    @JsonProperty("market_cap_change_24h")
    private Double marketCapChange24h;
    @JsonProperty("market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;
    @JsonProperty("circulating_supply")
    private Double circulatingSupply;
    @JsonProperty("total_supply")
    private Double totalSupply;
    @JsonProperty("max_supply")
    private Object maxSupply;
    @JsonProperty("ath")
    private Double ath;
    @JsonProperty("ath_change_percentage")
    private Double athChangePercentage;
    @JsonProperty("ath_date")
    private String athDate;
    @JsonProperty("atl")
    private Double atl;
    @JsonProperty("atl_change_percentage")
    private Double atlChangePercentage;
    @JsonProperty("atl_date")
    private String atlDate;
    @JsonProperty("roi")
    private Object roi;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("current_price")
    public Double getCurrentPrice() {
        return currentPrice;
    }

    @JsonProperty("current_price")
    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @JsonProperty("market_cap")
    public Long getMarketCap() {
        return marketCap;
    }

    @JsonProperty("market_cap")
    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    @JsonProperty("market_cap_rank")
    public Integer getMarketCapRank() {
        return marketCapRank;
    }

    @JsonProperty("market_cap_rank")
    public void setMarketCapRank(Integer marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    @JsonProperty("fully_diluted_valuation")
    public Object getFullyDilutedValuation() {
        return fullyDilutedValuation;
    }

    @JsonProperty("fully_diluted_valuation")
    public void setFullyDilutedValuation(Object fullyDilutedValuation) {
        this.fullyDilutedValuation = fullyDilutedValuation;
    }

    @JsonProperty("total_volume")
    public Double getTotalVolume() {
        return totalVolume;
    }

    @JsonProperty("total_volume")
    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    @JsonProperty("high_24h")
    public Double getHigh24h() {
        return high24h;
    }

    @JsonProperty("high_24h")
    public void setHigh24h(Double high24h) {
        this.high24h = high24h;
    }

    @JsonProperty("low_24h")
    public Double getLow24h() {
        return low24h;
    }

    @JsonProperty("low_24h")
    public void setLow24h(Double low24h) {
        this.low24h = low24h;
    }

    @JsonProperty("price_change_24h")
    public Double getPriceChange24h() {
        return priceChange24h;
    }

    @JsonProperty("price_change_24h")
    public void setPriceChange24h(Double priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    @JsonProperty("price_change_percentage_24h")
    public Double getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    @JsonProperty("price_change_percentage_24h")
    public void setPriceChangePercentage24h(Double priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }

    @JsonProperty("market_cap_change_24h")
    public Double getMarketCapChange24h() {
        return marketCapChange24h;
    }

    @JsonProperty("market_cap_change_24h")
    public void setMarketCapChange24h(Double marketCapChange24h) {
        this.marketCapChange24h = marketCapChange24h;
    }

    @JsonProperty("market_cap_change_percentage_24h")
    public Double getMarketCapChangePercentage24h() {
        return marketCapChangePercentage24h;
    }

    @JsonProperty("market_cap_change_percentage_24h")
    public void setMarketCapChangePercentage24h(Double marketCapChangePercentage24h) {
        this.marketCapChangePercentage24h = marketCapChangePercentage24h;
    }

    @JsonProperty("circulating_supply")
    public Double getCirculatingSupply() {
        return circulatingSupply;
    }

    @JsonProperty("circulating_supply")
    public void setCirculatingSupply(Double circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    @JsonProperty("total_supply")
    public Double getTotalSupply() {
        return totalSupply;
    }

    @JsonProperty("total_supply")
    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    @JsonProperty("max_supply")
    public Object getMaxSupply() {
        return maxSupply;
    }

    @JsonProperty("max_supply")
    public void setMaxSupply(Object maxSupply) {
        this.maxSupply = maxSupply;
    }

    @JsonProperty("ath")
    public Double getAth() {
        return ath;
    }

    @JsonProperty("ath")
    public void setAth(Double ath) {
        this.ath = ath;
    }

    @JsonProperty("ath_change_percentage")
    public Double getAthChangePercentage() {
        return athChangePercentage;
    }

    @JsonProperty("ath_change_percentage")
    public void setAthChangePercentage(Double athChangePercentage) {
        this.athChangePercentage = athChangePercentage;
    }

    @JsonProperty("ath_date")
    public String getAthDate() {
        return athDate;
    }

    @JsonProperty("ath_date")
    public void setAthDate(String athDate) {
        this.athDate = athDate;
    }

    @JsonProperty("atl")
    public Double getAtl() {
        return atl;
    }

    @JsonProperty("atl")
    public void setAtl(Double atl) {
        this.atl = atl;
    }

    @JsonProperty("atl_change_percentage")
    public Double getAtlChangePercentage() {
        return atlChangePercentage;
    }

    @JsonProperty("atl_change_percentage")
    public void setAtlChangePercentage(Double atlChangePercentage) {
        this.atlChangePercentage = atlChangePercentage;
    }

    @JsonProperty("atl_date")
    public String getAtlDate() {
        return atlDate;
    }

    @JsonProperty("atl_date")
    public void setAtlDate(String atlDate) {
        this.atlDate = atlDate;
    }

    @JsonProperty("roi")
    public Object getRoi() {
        return roi;
    }

    @JsonProperty("roi")
    public void setRoi(Object roi) {
        this.roi = roi;
    }

    @JsonProperty("last_updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}