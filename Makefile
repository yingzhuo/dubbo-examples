# 版本号
version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')

usage:
	@echo "usage          : 菜单"
	@echo "dist           : 构建"
	@echo "clean          : 清理"
	@echo "version        : 变更版本号"
	@echo "github         : 推送源码"

release: clean
	@mvn package -P"dist" -D"version=$(version)"

clean:
	@mvn clean -q
	@rm -rf $(CURDIR)/release

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvn -f $(CURDIR)/pom.xml versions:commit

github: clean
	@cd $(CURDIR)
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage release clean version github