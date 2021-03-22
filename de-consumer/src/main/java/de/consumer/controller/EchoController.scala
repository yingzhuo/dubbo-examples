package de.consumer.controller

import de.service.EchoService
import de.service.version.Version
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

import java.util.UUID

@RestController
private class EchoController {

  @DubboReference(version = Version.Random, check = false)
  private val echoService: EchoService = null

  @GetMapping(Array("echo"))
  def echo(@RequestParam("msg") msg: String): String = echoService.echo(msg)

  @GetMapping(Array("broken"))
  def broken(): Unit = {
    echoService.brokenEcho(UUID.randomUUID().toString)
  }

}
