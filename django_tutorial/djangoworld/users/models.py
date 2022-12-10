from django.db import models

# Create your models here.
class Users(models.Model):      # CREATE TABLE users_users ( col1, col2, col3, ...)
    username = models.CharField(max_length=255)     # username varchar(255) 
    email = models.CharField(max_length=255)        # email varchar(255) 
    password = models.CharField(max_length=255)     # password varchar(255) 