# 版本号
version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')

# ======================================================================================================================

usage:
	@echo "usage          : 显示用法菜单"
	@echo "build-jar      : 构建Jar文件"
	@echo "clean          : 清理"
	@echo "version        : 变更版本号"
	@echo "version        : 变更版本号"

build-jar:
	@mvn clean package -D"version=$(version)"

clean:
	@mvn clean -q

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvn -f $(CURDIR)/pom.xml versions:commit

github: clean
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage build-jar clean version github