from django.urls import path
from . import views

urlpatterns = [
    path('', views.users, name='users'),
    path('variables/', views.variables, name='variables'),
    path('tags/', views.tags, name='tags' ),
    path('ifElse/', views.ifelse, name='ifelse'),
    path('forloop/', views.forloop, name='forloop'),
    path('cycle/', views.cycle, name='cycle'),
    path('extends/', views.extends, name='extends'),
    path('usertable/', views.usertable, name='usertable'),
]