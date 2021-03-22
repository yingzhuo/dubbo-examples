#!/bin/bash

set -e

cd /opt

mkdir -p /home/app && chown app:app /home/app

exec gosu app:app java \
  -Djava.security.egd=file:/dev/./urandom \
  -Duser.timezone="Asia/Shanghai" \
  -Duser.language="zh" \
  -Duser.country="CN" \
  -Djava.io.tmpdir=/var/tmp \
  org.springframework.boot.loader.JarLauncher \
  "$@"
