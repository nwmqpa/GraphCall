package com.nwmqpa.graphcall.interfaces;

import com.nwmqpa.graphcall.result.Result;

import java.io.IOException;
import java.net.URL;

public interface ISendable {

    Result send(URL url) throws IOException;
}
