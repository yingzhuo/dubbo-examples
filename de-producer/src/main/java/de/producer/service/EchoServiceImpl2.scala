package de.producer.service

import de.service.EchoService
import de.service.exception.NotImplemented
import de.service.version.Version
import org.apache.dubbo.config.annotation.DubboService
import org.slf4j.LoggerFactory

@DubboService(version = Version.v2)
class EchoServiceImpl2 extends AnyRef with EchoService {

  private val log = LoggerFactory.getLogger(classOf[EchoServiceImpl2])

  override def echo(message: String): String = {
    log.debug("version: {}", Version.v2)
    message
  }

  override def brokenEcho(message: String): Nothing = throw NotImplemented()

}
