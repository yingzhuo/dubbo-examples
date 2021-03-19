package de.consumer.controller

import de.common.domain.Author
import de.service.AuthorService
import de.service.version.Version
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
private class AuthorController {

  @DubboReference(version = Version.Default, check = false)
  private val authorService: AuthorService = null

  @GetMapping(Array("author"))
  def author(): Author = authorService.get

}
