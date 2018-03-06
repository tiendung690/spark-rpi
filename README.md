spark-rpi-demo README
=====================

So, this is a small demo program with a web server controlling two
digital outputs on a Raspberry Pie. The digital outputs are handled
by the pi4j library, and the web server is based on the spark
framework. The thing is written in java + some Angular javascript
in the frontend.

The work is placed in public domain.


Dependencies
------------
- jdk 1.8
- maven
- tomcat8, tomcat8-admin

All these are as installed from debian packages on Raspberry Pie,
using raspbian.

Installation
------------
As-is, the outputs are assumed wired to the pins 8 and 9 according
to the wiringPi numbering scheme as of http://wiringpi.com/pins/.
This can be reconfigured in the src/main/java/eu/ntig/Config.java
file.

The application is built using a plain *make*.

Contrary to urban legend, the process using the pi4j library does
*not* need run as root. However, it needs to be part of the gpio
group. To make the tomcat8 user running the server part of this
group do

    $ sudo usermod -aG gpio tomcat8

and restart the server.

tomcat can be used by it's autoload features. This requires
write access to the tomcat webapp library, which is rather
painful. I have added a proper interactive login shell to
tomcat8 user and copied my ssh keys to it; there are probably
better ways. In the end, the war files created by *make war*
should be copied to the tomcat webapp library, by default
/var/lib/tomcat8/webapps. From that point, tomcat loads
the war file.

The standard Makefile's *make deploy* performs this copy,
but requires ssh access (above) user and also configuring 
the Makefile constants.


Running
-------

Tomcat presents a page on http://host.fqdn:8080/nti/,
given that the war file is deployed on the *nti* context.
It should be self-explanatory.
