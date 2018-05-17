package com.dahu.swagger.controller;

import com.dahu.swagger.service.CmdService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zzh on 2018/5/11.
 */
@RestController
@RequestMapping("/cmd")
public class ComdController {
  @Autowired
  CmdService cmdService;

  @RequestMapping("/execCmd")
  public String comd(String cmd,HttpServletResponse response){
    try {
      cmdService.execCmd(cmd,null,response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

}
