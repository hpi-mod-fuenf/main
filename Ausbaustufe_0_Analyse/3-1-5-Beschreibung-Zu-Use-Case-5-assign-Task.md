# 3.1.1 Beschreibung zu Use Case *5*: assign Task

asdf  |  asdf
------|-------
Übergeordneter elementarer Geschäftsprozess: | 
Ziel des Use Cases: | _Robot_ den Task (die _Destination_) zuweisen
Umgebende Systemgrenze: | _Server_ und _Robot_
Vorbedingung: | "choose Robot" hat am Besten geeigneten _Robot_ gefunden und ausgewählt
Nachbedingung bei erfolgreicher Ausführung: | ausgewähler _Robot_ steuert die _Destination_ an
Beteiligte Nutzer: | _Server_ und _Robot_
Auslösendes Ereignis: | im Use-Case "choose Robot" wurde passender _Robot_ ausgewählt



## Standardablauf

Schritt | Nutzer | Beschreibung der Aktivität
--------|--------|---------------------------
1       | _Server_  | _Server_ überträgt ausgewähltem _Robot_ den Task