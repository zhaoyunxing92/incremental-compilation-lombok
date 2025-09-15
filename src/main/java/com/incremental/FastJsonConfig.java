package com.incremental;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.SymbolTable;
import com.alibaba.fastjson2.filter.Filter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FastJsonConfig {
    private Charset charset;
    private String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private JSONReader.Feature[] readerFeatures;
    private JSONWriter.Feature[] writerFeatures;
    private Filter[] readerFilters;
    private Filter[] writerFilters;
    private boolean writeContentLength;
    private boolean jsonb;
    private SymbolTable symbolTable;

    public FastJsonConfig() {
        this.charset = StandardCharsets.UTF_8;
        this.readerFeatures = new JSONReader.Feature[0];
        this.writerFeatures = new JSONWriter.Feature[]{JSONWriter.Feature.WriteByteArrayAsBase64, JSONWriter.Feature.BrowserSecure};
        this.readerFilters = new Filter[0];
        this.writerFilters = new Filter[0];
        this.writeContentLength = true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public JSONReader.Feature[] getReaderFeatures() {
        return this.readerFeatures;
    }

    public void setReaderFeatures(JSONReader.Feature... readerFeatures) {
        this.readerFeatures = readerFeatures;
    }

    public JSONWriter.Feature[] getWriterFeatures() {
        return this.writerFeatures;
    }

    public void setWriterFeatures(JSONWriter.Feature... writerFeatures) {
        this.writerFeatures = writerFeatures;
    }

    public Filter[] getReaderFilters() {
        return this.readerFilters;
    }

    public void setReaderFilters(Filter... readerFilters) {
        this.readerFilters = readerFilters;
    }

    public Filter[] getWriterFilters() {
        return this.writerFilters;
    }

    public void setWriterFilters(Filter... writerFilters) {
        this.writerFilters = writerFilters;
    }

    public boolean isWriteContentLength() {
        return this.writeContentLength;
    }

    public void setWriteContentLength(boolean writeContentLength) {
        this.writeContentLength = writeContentLength;
    }

    public boolean isJSONB() {
        return this.jsonb;
    }

    public void setJSONB(boolean jsonb) {
        this.jsonb = jsonb;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void setSymbolTable(String... names) {
        this.symbolTable = JSONB.symbolTable(names);
    }
}
