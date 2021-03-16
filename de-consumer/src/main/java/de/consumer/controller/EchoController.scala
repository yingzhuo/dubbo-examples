package de.consumer.controller

import de.service.EchoService
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

@RestController
private class EchoController {

  @DubboReference(version = "1.0.0", check = false)
  private val echoService: EchoService = null

  @GetMapping(Array("echo"))
  def echo(@RequestParam("msg") msg: String): String = echoService.echo(msg)

}
