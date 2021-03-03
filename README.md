# Full Stack: Angular and Java Spring Boot
**Spring Ecommerce Backend**

## Docker commands
### MySQL

docker run --name tw-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -v ~/prog/docker/data/mysql-ecommerce:/var/lib/mysql -p 3306:3306 --cap-add sys_nice -d mysql

