from django.http import HttpResponse
from django.template import loader
from .models import Users

"""
QuerySets:

RETURN DATA
<QuerySet [<Model : Model objects>,] >> Model.objects.all()  : Query Data
<QuerySet [<Model: Model objects>, ] >> Model.objects.all().values() : Get all data!

FILTER DATA
<QuerySet [<Model: Model objects>, ] >> Model.objects.values_list('column') : Return specific columns
 i.e. use cut filter to remove unnecessary characters from template
 filter() method : ,(AND) | (OR)
 Field Lookups

"""

# Index View: Users Template
def users(request):
    template = loader.get_template('users.html')
    return HttpResponse(template.render())

# Variables View: Variables Template
def variables(request):
    template = loader.get_template('variables.html')
    context = {     # Create variable(s) using context object to render to template
        'user': 'new user',
        'car' : 'Ford Mustang GT',
        'cost' : '37000',
        'yes' : 'true',
        'temperature' : '25.4'
    }
    return HttpResponse(template.render(context, request))

# Tags View: Tags Template
def tags(request):
    template = loader.get_template('tags.html')
    return HttpResponse(template.render())

# If Else View: If Else Template
def ifelse(request):
    template = loader.get_template('ifElse.html')
    context = {
        'greeting' : 1,
        'apple' : 'red',
        'paper' : 'green',
        'jeans' : 'blue',
        'mobile': ['phones', 'watches', 'tablets'],
        'devices' : ['phones', 'watches', 'tablets'],
    }
    return HttpResponse(template.render(context, request))

# For Loop View: For Loop Template
def forloop(request):
    template = loader.get_template('forloop.html')
    context = {         # Define Python Lists and Dictionary for the loop
        'heroes' : ['Spider-Man', 'Hulk', 'Thor', 'Wolverine', 'Blade'],
        'villains' : ['Venom', 'Green Goblin', 'Magneto', 'Doctor Doom', 'Thanos'],
        'phones' : [
            {
                'brand': 'Apple',
                'model' : 'iPhone 13 Pro',
                'size' : '256GB'
            },
            {
                'brand': 'Samsung',
                'model' : 'Galaxy',
                'size' : '128GB'
            }
        ]
    }
    return HttpResponse(template.render(context, request))

# Cycle View: Cycle Template
def cycle(request):
    template = loader.get_template('cycle.html')
    context = {
        'colors' : ['red', 'green', 'blue', 'yellow', 'orange', 'purple']
    }
    return HttpResponse(template.render(context, request))

# Extends View : Extends Template
def extends(request):
    template = loader.get_template('extends.html')
    return HttpResponse(template.render())

# User Table View: For Model
def usertable(request):     # QuerySet : Users, objects: Users objects
    userdata = Users.objects.all().values()     # Get records!
    userinfo = Users.objects.values_list('username')

    context = {
        'usertable' : userdata,
        'usernames' : userinfo
    }
    template = loader.get_template('usertable.html')
    return HttpResponse(template.render(context, request))

