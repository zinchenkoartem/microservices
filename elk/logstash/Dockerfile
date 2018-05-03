FROM docker.elastic.co/logstash/logstash:6.2.4

# add custom config
COPY logstash.conf /config-dir/logstash.conf

# add templates
COPY ./templates/ /config-dir/templates/
