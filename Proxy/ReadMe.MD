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
So we can create ImageProxy which would tell client "Loading CD cover, please wait..." msg untill our ImageIcon object is ready.\
ImageProxy will also returns the height and width required to show the message. However, if the ImageIcon is ready we can delegate those to RealObject.

How ImageProxy is going to work:
* ImageProxy first creates an ImageIcon and starts loading it from a network URL.
* While the bytes of the image are being retrieved, ImageProxy displays “Loading CD cover, please wait...”.
* When the image is fully loaded, ImageProxy del- egates all method calls to the image icon, including paintIcon(), getWidth() and getHeight().
* If the user requests a new image, we’ll create a new proxy and start the process over
