# ----------------------------------------------------------------------------------------------------------------------
# 预构建
# ----------------------------------------------------------------------------------------------------------------------
ARG BASE_IMAGE=192.168.99.115/library/springboot:8

FROM $BASE_IMAGE AS builder

COPY *.jar /opt/app.jar

RUN java -Djarmode=layertools -jar /opt/app.jar extract && \
    rm -rf /opt/dependencies/BOOT-INF/lib/spring-boot-jarmode-layertools-*.jar && \
    rm -rf /opt/application/BOOT-INF/classpath.idx && \
    rm -rf /opt/application/BOOT-INF/layers.idx

# ----------------------------------------------------------------------------------------------------------------------
# 构建
# ----------------------------------------------------------------------------------------------------------------------
FROM $BASE_IMAGE

LABEL maintainer="应卓 <yingzhor@gmail.com>"

COPY --from=builder /opt/dependencies/ ./
COPY --from=builder /opt/spring-boot-loader/ ./
COPY --from=builder /opt/snapshot-dependencies/ ./
COPY --from=builder /opt/internal-dependencies/ ./
COPY --from=builder /opt/application/ ./

ENV APP_PROFILES=k8s

EXPOSE 8080