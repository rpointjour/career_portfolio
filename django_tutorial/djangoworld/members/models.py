# Models are tables in your databases
from django.db import models

# Create your models here.
class Members(models.Model):
  firstname = models.CharField(max_length=255)
  lastname = models.CharField(max_length=255)

'''
The first field, "firstname" is a Text field, and will contain the first name of the members.

The second field, "lastname" is also a Text field, with the members' last name.

Both "firstname" and "lastname" is set up to have a maximum of 255 characters.

Equivalent to creating a table in SQL/MySQL:

 CREATE TABLE model (
    FirstName varchar(255),
    LastName varchar(255)
 );

'''