# 3.1.1 Beschreibung zu Use Case *4*: choose Robot

asdf  |  asdf
------|-------
Übergeordneter elementarer Geschäftsprozess: | 
Ziel des Use Cases: | passenden _Robot_ für die , durch den _Server_, empfangene _Destination_ auswählen
Umgebende Systemgrenze: | _Robot_ und _Server_
Vorbedingung: | _Server_ hat eine neue _Destination_ bekommen
Nachbedingung bei erfolgreicher Ausführung: | dem ausgewählten _Robot_ wird die Task übertragen
Beteiligte Nutzer: | _Robot_ und _Server_
Auslösendes Ereignis: | _Server_ empfängt neue _Destination_



## Standardablauf

Schritt | Nutzer | Beschreibung der Aktivität
--------|--------|---------------------------
1       | _Server_  | _Server_ sendet Anfragen an alle _Robots_
2       | _Robot_  | _Robots_ empfangen Anfrage und führen dann den Use-Case "read Sensors aus"
3       | _Robot_  | _Robots_ senden ihre ermittelten Sensorwerte an den _Server_
4       | _Server_  | _Server_ empfängt Daten und wählt den am Besten geeigneten _Robot_ aus