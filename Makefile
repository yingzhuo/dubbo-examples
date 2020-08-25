
# 版本号
version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')

# jar文件位置
jar-producer := $(CURDIR)/de-producer/target/docker-context/*.jar
jar-consumer := $(CURDIR)/de-consumer/target/docker-context/*.jar

# 镜像名称
image-producer := 192.168.99.115/yingzhuo/de-producer
image-consumer := 192.168.99.115/yingzhuo/de-consumer

# ======================================================================================================================

usage:
	@echo "usage          : 显示用法菜单"
	@echo "build-jar      : 构建Jar文件"
	@echo "build-image    : 构建Docker镜像"
	@echo "push-image     : 推送Docker镜像到Harbor"
	@echo "clean          : 清理"
	@echo "version        : 变更版本号"

build-jar:
	@mvn clean package -P NonLayeredJar -D version=$(version)
	@rm -rf $(CURDIR)/_dist/
	@mkdir -p $(CURDIR)/_dist/
	@cp $(jar-producer) $(CURDIR)/_dist/
	@cp $(jar-consumer) $(CURDIR)/_dist/

build-image:
	@mvn clean package -P LayeredJar -D version=$(version)

	# CORE
	@docker image build -t $(image_delta_core) $(CURDIR)/delta-core/target/docker-context/
	@docker image tag $(image_delta_core) $(image_delta_core_latest)

	# ACCOUNT
	@docker image build -t $(image_delta_account) $(CURDIR)/delta-account/target/docker-context/
	@docker image tag $(image_delta_account) $(image_delta_account_latest)

	# ORDER
	@docker image build -t $(image_delta_order) $(CURDIR)/delta-order/target/docker-context/
	@docker image tag $(image_delta_order) $(image_delta_order_latest)

	# TASK
	@docker image build -t $(image_delta_task) $(CURDIR)/delta-task/target/docker-context/
	@docker image tag $(image_delta_task) $(image_delta_task_latest)

push-image: build-image
	@echo "UGFzc3dvcmQwMSEK" | base64 -d | docker login --username=admin --password-stdin 192.168.99.115
	@docker image push $(image_delta_core)
	@docker image push $(image_delta_core_latest)
	@docker image push $(image_delta_account)
	@docker image push $(image_delta_account_latest)
	@docker image push $(image_delta_order)
	@docker image push $(image_delta_order_latest)
	@docker image push $(image_delta_task)
	@docker image push $(image_delta_task_latest)
	@docker logout 192.168.99.115 &> /dev/null

clean:
	@mvn clean -q
	@rm -rf $(CURDIR)/_dist/ &> /dev/null
	@docker image prune -af  &> /dev/null

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvn -f $(CURDIR)/pom.xml versions:commit

github:
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage build-jar build-image push-image clean version github