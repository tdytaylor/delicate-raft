package org.delicate.raft.core;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author tdytaylor The Raft implement
 */
public class RaftNode {

  private final int port;

  public static void main(String[] args) {

  }

  public RaftNode(int port) {
    this.port = port;
  }

  /**
   * 启动raft服务
   */
  public void start() {
    ServerBootstrap bootstrap = new ServerBootstrap();
    NioEventLoopGroup dispatch = new NioEventLoopGroup(1);
    NioEventLoopGroup worker = new NioEventLoopGroup();
    bootstrap.group(dispatch, worker)
        .channel(NioServerSocketChannel.class)
        .option(ChannelOption.SO_KEEPALIVE, true)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline();
          }
        });
  }
}
