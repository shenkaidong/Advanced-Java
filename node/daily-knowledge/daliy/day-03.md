|Concepts                                           |Definitions                                                                                                                                                                                                                                                              |
|---------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|TCP                                                |3 way handshake, establish connection between server and client for sending and receiving requests 1. Client send sync package to server 2. Server send sync + acknowledge package back to the client 3. Client send acknowledge package to the server -> connection established (prevent asynchonized connection)|
|UDP                                                |Server streams data to client                                                                                                                                                                                                                                            |
|Send buffer                                        |The TCP send buffer contains all data sent to the remote host but not yet acknowledged by that host                                                                                                                                                                      |
|Send payload                                       |Serial number &#124; length &#124; data payload                                                                                                                                                                                                                                    |
|Package loss and disorder                          |Client is not receiving data in order                                                                                                                                                                                                                                    |
|Disconnection                                      |4 way handshake, time wait to inspect any leftover request 1. Server senD FIN package to Client 2. Client send ACK back 3. Time wait 4. Client send FIN package 5. Server send ACK package and the connection is closed                                                  |
|Server                                             |Deploy web resource, handle client's requesrs                                                                                                                                                                                                                            |
|Static web resources                               |Always return the same result when client make request. HTML, txt, movie file                                                                                                                                                                                            |
|Dynamic web resource                               |JSP Servlet                                                                                                                                                                                                                                                              |
|Tomcat                                             |Web server by Apache organization supporting jps and servlet. Ligjtweight javaweb container (free)                                                                                                                                                                       |
|Jboss                                              |Open source, following JaveEE rules. Pure java EJB server                                                                                                                                                                                                                |
|GlassFish                                          |Develop by Oracle, robust commercial server                                                                                                                                                                                                                              |
|Resin                                              |Develop by CAUCHO. Excellent performance. Developed in Java                                                                                                                                                                                                              |
|Weblogic                                           |Develop by Oracle. Following javeEE rules. Adaptive for large scale project                                                                                                                                                                                              |
|JPS                                                |Javapage Server                                                                                                                                                                                                                                                          |
|Servlet                                            |                                                                                                                                                                                                                                                                         |