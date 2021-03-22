package de.producer.service

import de.service.EchoService
import de.service.exception.NotImplemented
import de.service.version.Version
import org.apache.dubbo.config.annotation.DubboService
import org.slf4j.LoggerFactory

@DubboService(version = Version.v1)
class EchoServiceImpl1 extends AnyRef with EchoService {

  private val log = LoggerFactory.getLogger(classOf[EchoServiceImpl1])

  override def echo(message: String): String = {
    log.debug("version: {}", Version.v1)
    message
  }

  override def brokenEcho(message: String): Nothing = throw NotImplemented()

}
