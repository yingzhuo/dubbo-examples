# 版本号
version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')

usage:
	@echo "usage                : 菜单"
	@echo "release-jar          : 构建"
	@echo "release-docker-image : 构建"
	@echo "clean                : 清理"
	@echo "version              : 变更版本号"
	@echo "github               : 推送源码"

release-jar: clean
	@mvn -f $(CURDIR)/pom.xml package -P"dist" -D"version=$(version)"

release-docker-image: clean
	@mvn -f $(CURDIR)/pom.xml package -P"docker" -D"version=$(version)"
	@docker image build --tag yingzhuo/de-consumer:latest $(CURDIR)/de-consumer/target/docker-context/
	@docker image build --tag yingzhuo/de-producer:latest $(CURDIR)/de-producer/target/docker-context/

clean:
	@mvn -f $(CURDIR)/pom.xml clean -q
	@rm -rf $(CURDIR)/release
	@docker image rm yingzhuo/de-consumer:latest &> /dev/null || true
	@docker image rm yingzhuo/de-producer:latest &> /dev/null || true

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvn -f $(CURDIR)/pom.xml versions:commit

github: clean
	@cd $(CURDIR)
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"

.PHONY: usage release-jar release-docker-image clean version github