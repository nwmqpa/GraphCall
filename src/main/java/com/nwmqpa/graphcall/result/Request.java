package com.nwmqpa.graphcall.result;

import com.nwmqpa.graphcall.interfaces.ISendable;
import com.nwmqpa.graphcall.result.Result;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Request implements ISendable {

    private final String request;

    public Request(String request, boolean debug) {
        request = request.replace("\n", "\t").replace("\t", " ").replaceAll(" +", " ");
        StringBuilder sb = new StringBuilder();
        sb.append("{\"query\": \"").append(request).append("\"}");
        this.request = sb.toString();
        if (debug)
            System.out.println(this.request);
    }

    public Request(String request) {
        this(request, false);
    }

    @Override
    public Result send(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");
        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(this.request);
        wr.flush();
        StringBuilder sb = new StringBuilder();
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return new Result(sb.toString());
        } else {
            return null;
        }
    }
}
