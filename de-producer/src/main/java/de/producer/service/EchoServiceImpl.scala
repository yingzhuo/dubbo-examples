package de.producer.service

import de.service.EchoService
import org.apache.dubbo.config.annotation.DubboService

@DubboService(version = "1.0.0")
class EchoServiceImpl extends AnyRef with EchoService {

  override def echo(message: String): String = message

}
