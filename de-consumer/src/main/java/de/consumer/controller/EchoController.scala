package de.consumer.controller

import de.service.EchoService
import de.service.version.Version.Default
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

@RestController
private class EchoController {

  @DubboReference(version = Default, check = false)
  private val echoService: EchoService = null

  @GetMapping(Array("echo"))
  def echo(@RequestParam("msg") msg: String): String = echoService.echo(msg)

}
