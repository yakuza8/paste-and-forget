# paste-and-forget
Something like pastebin but with spring webflux (hopefully)

## Execution

```shell
# To run docker instance first pull the image
sudo docker pull mysql:latest

# And run the image
sudo  docker run --name paste-and-forget-mysql -e MYSQL_ROOT_PASSWORD=yakuza-secret-root -e MYSQL_USER=yakuza -e MYSQL_PASSWORD=greatpassword -d mysql:latest
```