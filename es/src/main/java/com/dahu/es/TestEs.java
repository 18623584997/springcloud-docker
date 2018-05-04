package com.dahu.es;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * Created by zzh on 2018/4/26.
 */
public class TestEs {

  public static void main(String[] args) {

    try {
      TransportClient client = TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress(
          InetAddress.getByName("192.168.95.128"), 9300));
      System.out.println(client);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

  }

}
