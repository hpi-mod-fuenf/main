# 3.2.2 Beschreibung zu Use Case *2*: Read Sensors

       |         
-------|---------
Übergeordneter elementarer Geschäftsprozess: | Choose *Robot*
Ziel des Use Cases: | *Robot* kann über seinen Akkustand und seine Position Auskunft geben
Umgebende Systemgrenze: | *Robot*
Vorbedingung: | *Robot* hat eine Anfrage vom *Server* erhalten
Nachbedingung bei erfolgreicher Ausführung: | *Robot* schickt die ermittelten Informationen an den *Server*
Beteiligte Nutzer: | *Robot*
Auslösendes Ereignis: | *Robot* hat eine Anfrage vom *Server* erhalten, seine Sensoren zu lesen und sie dem *Server* zu schicken

Im Rahmen vom Geschäftsprozess *Choose *Robot** sammelt der *Server* Informationen über jeden *Robot*. Diese Informationen (z.B Akkustand, aktuelle Position, ob der *Robot* gerade ein *Destination* verfolgt) kann der *Robot* von seinen Hardware-Schnittstellen anfordern. Dieses Use Case wird dann ausgefüht, wenn der *Robot* eine Anfrage vom *Server* erhält, seine Sensoren zu lesen, und endet damit, dass der *Robot* die zusammengefassten Informationen an den *Server* schickt.

## Standardablauf

Schritt | Nutzer | Beschreibung der Aktivität
--------|--------|---------------------------
1		| *Robot*  | *Robot* erhält Anfrage vom *Server*
2		| *Robot*  | *Robot* sammelt Informationen von seiner Hardwareschnittstelle und fasst sie zusammen
3		| *Robot*  | *Robot* schickt zusammengefasste Informationen an den *Server*
