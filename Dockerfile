FROM mongo:5.0
COPY keys/mongo-replica-set.key /data/db/mongo-replica-set.key
RUN chown 999:999 /data/db/mongo-replica-set.key