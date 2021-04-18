# H1 p1
# Quadratic Functions

import math
import pylab

offset = 2

a_str = input("Enter a: ")

while a_str != "" :
    a = float(a_str)
    if a == 0:
        print("Error! a cannot be zero")
        exit(1)
    
    b = float(input("Enter b: "))
    c = float(input("Enter c: "))
    
    delta = b * b - 4 * a * c
    
    if delta < 0:
        print("no real solutions")
        xopt = -b / (2 * a)
        xmin = xopt - offset
        xmax = xopt + offset
        
    elif delta == 0:
        x = -b / (2 * a)
        xmin = x - offset
        xmax = x + offset
        print("one solution", x)
        
    else:
        x1 = (-b - math.sqrt(delta)) / (2 * a)
        x2 = (-b + math.sqrt(delta)) / (2 * a)
        print("two solutions x1 = ", x1, "x2 = ", x2)
        
        offset = (x2 - x1) / 4.0
        xmin = x1 - offset
        xmax = x2 + offset
        
    # graph
    
    xs = []
    ys = []
    
    n = 150
    
    dx = (xmax - xmin) / n
    
    x = xmin
    
    while x <= xmax:
        xs.append(x)
        y = a * x**2 + b * x + c
        ys.append(y)
        x += dx
    #End of loop
    pylab.plot(xs, ys, "b-")    # Create graph
    pylab.title("{}x^2 + {}x + {}".format(a, b, c))
    pylab.xlabel("x")
    pylab.ylabel("y")
    # draw axes
    pylab.axhline(0, color = 'black')
    pylab.axvline(0, color = 'black')
    
    pylab.show()    # Display graph
    # Repeat loop
    a_str = input("Enter a: ")
    
    # End of program