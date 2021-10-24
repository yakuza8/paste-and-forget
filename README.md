# paste-and-forget
Something like pastebin but with spring webflux (hopefully)

## Execution

```shell
# Never ending helper command
docker compose up
```

## To connect MySQL admin page

```yaml
phpmyadmin:
  image: phpmyadmin/phpmyadmin
  container_name: pma
  links:
    - mysql
  environment:
    PMA_HOST: mysql
    PMA_PORT: 3306
    PMA_ARBITRARY: 1
  restart: always
  ports:
    - 8081:80
```