package io.higgs;

import io.higgs.ssl.SSLConfigFactory;
import io.higgs.ssl.SSLContextFactory;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

public abstract class HiggsPipeline extends ChannelInitializer<SocketChannel> {
    protected boolean sslClientMode = true;

    public SslHandler ssl() {
        SSLEngine engine = SSLContextFactory.getSSLSocket(SSLConfigFactory.sslConfiguration).createSSLEngine();
        engine.setUseClientMode(sslClientMode);
        return new SslHandler(engine);
    }
}