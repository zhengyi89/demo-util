package com.demo.netty;

/**
 * Created by IntelliJ IDEA.
 * User: flychao88
 * Date: 12-6-6
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
import org.jboss.netty.channel.*;


public class TimeClientHandler extends SimpleChannelUpstreamHandler  {
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        e.getChannel().write("abcd");
        int i = 1000;
        while (true){
            e.getChannel().write("abcd"+(i++));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        System.out.println("receive message " + e.getMessage());
        e.getChannel().close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        e.getCause().printStackTrace();
        e.getChannel().close();
    }
}