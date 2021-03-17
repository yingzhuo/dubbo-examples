package de.producer.service

import de.service.EchoService
import de.service.exception.NotImplemented
import org.apache.dubbo.config.annotation.DubboService

@DubboService(version = "1.0.0")
class EchoServiceImpl extends AnyRef with EchoService {

  override def echo(message: String): String = message

  override def brokenEcho(message: String): Nothing = throw NotImplemented()

}
