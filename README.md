### Setting up RMS-API Database

To set up the RMS-API database, you can use the following Docker command to run a PostgreSQL container. This command will create a new PostgreSQL database with the specified user and password.

```bash
docker run --name rms-db -p 5432:5432 -e POSTGRES_PASSWORD=rms-pswd -e POSTGRES_USER=rms-user -e POSTGRES_DB=rms-db -d postgres 
```
