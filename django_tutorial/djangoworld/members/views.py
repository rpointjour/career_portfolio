# Views are python functions that take http requests and returns an http response like in HTML docs
# Add http response for views
# Add templates for response
# template = loader.get_template('myfirst.html')
"""
For adding records:

  mymembers = Members.objects.all().values()
  output = ""
  for x in mymembers:
    output += x["firstname"]
  return HttpResponse(output)
  """
from django.http import HttpResponse, HttpResponseRedirect
from django.template import loader
from django.urls import reverse
from .models import Members

def index(request):
  mymembers = Members.objects.all().values()  # 1.) Create a mymembers object with all the values of the Members model.
  template = loader.get_template('index.html')  # 2.) Load the index.html template.
  context = {                                   # 3.) Create an object containing the mymember object within a context
    'mymembers': mymembers,
  }                                             # 4.) Send the object to the template by context.
  return HttpResponse(template.render(context, request))   # 5.) Render HTML from template, output response from request!

# New view: Add
def add(request):
  template = loader.get_template('add.html')
  return HttpResponse(template.render({}, request))

# New view: AddRecord  
def addrecord(request):
  x = request.POST['first']
  y = request.POST['last']
  member = Members(firstname=x, lastname=y)
  member.save()
  return HttpResponseRedirect(reverse('index')) 

# New view: Delete
def delete(request, id):    # Function gets id, locates record by id, deletes record, redirects to index
  member = Members.objects.get(id=id)
  member.delete()
  return HttpResponseRedirect(reverse('index'))

# New view: Update
def update(request, id):    # Function gets id, locates record by id, loads update, creates context, sends response
  mymember = Members.objects.get(id=id)
  template = loader.get_template('update.html')
  context = {
    'mymember': mymember,
  }
  return HttpResponse(template.render(context, request))

# New view: UpdateRecord
def updaterecord(request, id):    # Function  updates the record in the members table with the selected ID.
  first = request.POST['first']
  last = request.POST['last']
  member = Members.objects.get(id=id)
  member.firstname = first
  member.lastname = last
  member.save()
  return HttpResponseRedirect(reverse('index'))