# Main Repository

https://github.com/rpointjour/django_tutorial.git

# Django Tutorial

From W3 Schools: https://www.w3schools.com/django/index.php

## Overview

This tutorial provides a basis for **Back-End development** with **Python** using the Django framework.
I also wanted to learn how to implement databases into my applications, so this tutorial was the perfect place to start.
Django uses ORM (Object Relational Mapping) which makes it simplier to communicate with databases. 
Together with **SQLite** and the DB Browser program I was able to successfully add, modify, 
and delete records efficiently from a database table with changes appearing instantly from my apps.

## Django Project & App Development
1. Create Virtual Environment

    `python -m venv myproject`

2. Activate Virtual Environment

    `myproject\Scripts\activate.bat`
    
3. Install Django into Virtual Environment

    `python -m pip install Django`
    
4. Create Django Project

    `django-admin startproject djangoworld`
    
5. Run Django Project

    `python manage.py runserver`
    
6. Create Django App

    `python manage.py startapp members`
    
7. Create index View

    `members/views.py`
    
    `def index(request):`
        
8. Add Template(s)

    `members/templates`
    
    `/templates/index.html`
    
9. Include Template(s) in View

    `members/views.py`
    
    `from django.template import loader`
    
    `template = loader.get_template('index.html')`
    
10. Modify Project Settings

    `djangoworld/settings.py`
    
    `members.apps.MembersConfig`
    
11. Migrate App(s)

    `python manage.py makemigrations members`

## Django Framework: MVT Model

- Model
  - `models.py`
  - **Tables for databases**
- View
  - `views.py`
  - **Python functions that take http requests and return an http response**
- Template
  - `/templates`
  - **Response from View (usually in HTML)**
  
  ## Structure

![django](https://user-images.githubusercontent.com/54840122/205463140-55d19147-3d97-43ab-ae70-6c5f8b7fb988.JPG)

## Django Apps

- **Members**

<img src="https://user-images.githubusercontent.com/54840122/206818949-20628654-d6a4-495b-b5f3-ce7d55a5b870.png" alt="Members App" style="width:50%;height:50%;">

- **Users**

<img src="https://user-images.githubusercontent.com/54840122/206008721-95ff6b4b-fb4d-4382-89e7-2b5f5b887fef.png" 
alt="Users App" style="width:70%;height:80%;">

## Django Template Structure

- Django Variables

<img src="https://user-images.githubusercontent.com/54840122/205572937-37111aff-5c06-4f9b-b4cf-0b5a78e836d5.png" alt="Variables Template" style="width:70%;height:70%;">

- Django Template Tags

<img src="https://user-images.githubusercontent.com/54840122/205749877-e0fd721e-18e5-4603-82c0-02c35e531d77.png" alt = "Template Tags" style="width:70%;height:70%;">

- Django 404 Template

<img src="https://user-images.githubusercontent.com/54840122/206095898-3885e9fe-689d-4b8c-8120-89473055a678.png" alt="404 template" style="width:70%;height:70%;">

## Most Common Tags
- Django If Else

<img src="https://user-images.githubusercontent.com/54840122/205763875-93bef81a-8b84-4d83-9db0-96ce97ac7e9c.png" alt="If Else Tag" style="width:60%;height:60%;">

- Django For Loop

<img src="https://user-images.githubusercontent.com/54840122/205852350-67ae2111-2165-4680-a7a9-2d8115c49352.png" alt="For Loop Tag" style="width:70%;height:70%;">

- Django Cycle

<img src="https://user-images.githubusercontent.com/54840122/206019912-4eafc924-b0be-4718-9307-ffe8ef0bc130.png" alt="Cycle Tag" style="width:70%;height:70%" >

- Django Extends

<img src="https://user-images.githubusercontent.com/54840122/206077489-157607b9-6ebb-4464-99c2-c00fb1a893a8.png" alt="Extends Tag" style="width:70%;height:70%">

- Django Include

<img src="https://user-images.githubusercontent.com/54840122/206083659-63996ee9-c1fa-4d98-9e3f-938c818e8998.png" alt="Include Tag" style="width:70%;height:70%;">

- Django Filter

<img src="https://user-images.githubusercontent.com/54840122/206090855-e7be63e3-ba6a-413e-b681-7b45ee5996a6.png" alt="Filter Tag" style="width:70%;height:70%;">

## Static Files

- `members.css`
- `IMG_3046.JPG`
- `myfile.js`

## Django QuerySet Structure

- QuerySet
- Get Data
- Filter
- Order By

## Django QuerySets

<img src="https://user-images.githubusercontent.com/54840122/206816208-b02829d9-5bd1-4434-970d-6a7b066e8a73.png" alt="QuerySet Users" style="width:70%;height:70%;">

- **Query Data**
  - `Users.objects.all()`
- **Get Data**
  - `Users.objects.all().values()`
- **Return Specific Data**
  - `Users.objects.values_list('username')`
- **Filter Data**
  - `Users.objects.filter(username='starfox').values()`
- **Order Data**
  - `Users.objects.all().order_by('username').values()`
