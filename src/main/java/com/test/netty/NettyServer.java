package com.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 丢弃任何进入的数据 启动服务端的ServerHandler
 */
public class NettyServer {
	private int port;

	public NettyServer(int port) {
		this.port = port;
	}

	public void run() {
		/***
		 * NioEventLoopGroup 是用来处理I/O操作的多线程事件循环器，
		 * Netty提供了许多不同的EventLoopGroup的实现用来处理不同传输协议。 在这个例子中我们实现了一个服务端的应用，
		 * 因此会有2个NioEventLoopGroup会被使用。 第一个经常被叫做‘boss’，用来接收进来的连接。
		 * 第二个经常被叫做‘worker’，用来处理已经被接收的连接， 一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。
		 * 如何知道多少个线程已经被使用，如何映射到已经创建的Channels上都需要依赖于EventLoopGroup的实现，
		 * 并且可以通过构造函数来配置他们的关系。
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup(); // 用于处理服务器端接收客户端连接
		EventLoopGroup workerGroup = new NioEventLoopGroup(); // 进行网络通信（读写）
		try {
			ServerBootstrap bootstrap = new ServerBootstrap(); // 辅助工具类，用于服务器通道的一系列配置
			bootstrap.group(bossGroup, workerGroup) // 绑定两个线程组
					.channel(NioServerSocketChannel.class) // 指定NIO的模式
					.childHandler(new ChannelInitializer<SocketChannel>() { // 配置具体的数据处理方式
								@Override
								protected void initChannel(SocketChannel socketChannel) throws Exception {
									socketChannel.pipeline().addLast(new ServerHandler());
								}
							})
					/**
					 * 对于ChannelOption.SO_BACKLOG的解释：
					 * 服务器端TCP内核维护有两个队列，我们称之为A、B队列
					 * 。客户端向服务器端connect时，会发送带有SYN标志的包（第一次握手），服务器端
					 * 接收到客户端发送的SYN时，向客户端发送SYN
					 * ACK确认（第二次握手），此时TCP内核模块把客户端连接加入到A队列中，然后服务器接收到
					 * 客户端发送的ACK时（第三次握手
					 * ），TCP内核模块把客户端连接从A队列移动到B队列，连接完成，应用程序的accept会返回。也就是说accept
					 * 从B队列中取出完成了三次握手的连接。
					 * A队列和B队列的长度之和就是backlog。当A、B队列的长度之和大于ChannelOption
					 * .SO_BACKLOG时，新的连接将会被TCP内核拒绝。
					 * 所以，如果backlog过小，可能会出现accept速度跟不上
					 * ，A、B队列满了，导致新的客户端无法连接。要注意的是，backlog对程序支持的
					 * 连接数并无影响，backlog影响的只是还没有被accept取出的连接
					 */
					.option(ChannelOption.SO_BACKLOG, 128) // 设置TCP缓冲区
					.option(ChannelOption.SO_SNDBUF, 32 * 1024) // 设置发送数据缓冲大小
					.option(ChannelOption.SO_RCVBUF, 32 * 1024) // 设置接受数据缓冲大小
					.childOption(ChannelOption.SO_KEEPALIVE, true); // 保持连接
			ChannelFuture future = bootstrap.bind(port).sync();
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		new NettyServer(8379).run();
	}
}
