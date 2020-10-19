## The Proxy Pattern : The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.
  
There are many variations of the Proxy Pattern, and the variations typically revolve around the way the proxy “controls access.”\
We’re going to talk more about this later, but for now here are a few ways proxies control access:
* As we know, a remote proxy controls access to a remote object.
* A virtual proxy controls access to a resource that is expensive to create.
* A protection proxy controls access to a resource based on access rights.

Use the Proxy Pattern to create a representative object that controls access to another object: 
  * which may be remote 
  * expensive to create 
  * in need of securing

![UML Proxy](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Proxy/img/UMLProxy.png)

First we have a Subject, which provides an interface for the RealSubject and the Proxy. By implementing the same interface, the Proxy can be substituted for the RealSubject anywhere it occurs. The RealSubject is the object that does the real work. It’s the object that the Proxy represents and controls access to. The Proxy holds a reference to the RealSubject. In some cases, the Proxy may be responsible for creating and destroying the RealSubject.

![UML Proxy](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Proxy/img/RemoteVirtualProxy.png)

### Virtual Proxy
lets say, ImageIcon which loads image from network URL and displays it (Expensive to load).\
So we can create ImageProxy which would tell client "Loading CD cover, please wait..." msg untill our ImageIcon object is ready.

How ImageProxy is going to work:
* ImageProxy first creates an ImageIcon and starts loading it from a network URL.
* While the bytes of the image are being retrieved, ImageProxy displays “Loading CD cover, please wait...”.
* When the image is fully loaded, ImageProxy delegates all method calls to the image icon, including paintIcon(), getWidth() and getHeight().
* If the user requests a new image, we’ll create a new proxy and start the process over

You’ll find a lot of variants of the Proxy Pattern in the real world; what they all have in common is that they intercept a method invocation that
the client is making on the subject.

**ImageProxy seems just like a Decorator to me. I mean, we are basically wrapping one object with another and then delegating the calls to the ImageIcon. What am I missing?**\
Sometimes Proxy and Decorator look very similar, but their purposes are different: a decorator adds behavior to a class, while a proxy controls access
to it.\
You might say,“Isn’t the loading message adding behavior?” In someways it is; however, more importantly, the ImageProxy is controlling access to an ImageIcon.\
How does it control access? Well, think about it this way: the proxy is decoupling the client from the ImageIcon.\
If they were coupled the client would have to wait until each image is retrieved before it could paint it entire interface.\ 
The proxy controls access to the ImageIcon so that before it is fully created, the proxy provides another on screen representation.\
Once the ImageIcon is created the proxy allows access.\
Technically Proxy sometimes also handles the object creation of RealSubject Decorator accepts already created objects.


**How do I make clients use the Proxy rather than the Real Subject?**\
One common technique is to provide a factory that instantiates and returns the subject. Because this happens in a factory method we can then wrap the subject with a proxy before returning it. The client never knows or cares that it’s using a proxy instead of the real thing.

**You could implement something similar to the ImageProxy that caches past retrievals.**\
A caching proxy maintains a cache of previous created objects and when a request is made it returns cached object, if possible.


* Adapter changes the interface of the objects it adapts, while the Proxy implements the same interface.
