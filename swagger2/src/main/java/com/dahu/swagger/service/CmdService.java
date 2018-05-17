package com.dahu.swagger.service;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
 * Created by zzh on 2018/5/11.
 */
@Service
public class CmdService {

  /**
   * 执行系统命令, 返回执行结果
   *
   * @param cmd 需要执行的命令
   * @param dir 执行命令的子进程的工作目录, null 表示和当前主进程工作目录相同
   */
  public  String execCmd(String cmd, File dir,HttpServletResponse response) throws Exception {
    StringBuilder result = new StringBuilder();

    Process process = null;
    BufferedReader bufrIn = null;
    BufferedReader bufrError = null;
    PrintWriter writer = null;

    try {
      // 执行命令, 返回一个子进程对象（命令在子进程中执行）
      process = Runtime.getRuntime().exec(cmd, null, dir);

      // 方法阻塞, 等待命令执行完成（成功会返回0）
      process.waitFor();

      // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
      bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
      bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

      // 读取输出
      String line = null;
      writer = response.getWriter();
      while ((line = bufrIn.readLine()) != null) {
        result.append(line).append('\n');
        writer.print(line+"\\n");
      }
      while ((line = bufrError.readLine()) != null) {
        result.append(line).append('\n');
        writer.print(line+"\\n");
      }

    } finally {
      closeStream(bufrIn);
      closeStream(bufrError);
      writer.close();


      // 销毁子进程
      if (process != null) {
        process.destroy();
      }
    }

    // 返回执行结果
    return result.toString();
  }

  private static void closeStream(Closeable stream) {
    if (stream != null) {
      try {
        stream.close();
      } catch (Exception e) {
        // nothing
      }
    }
  }

}
