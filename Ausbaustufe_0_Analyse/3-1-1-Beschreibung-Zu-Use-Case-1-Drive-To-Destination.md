# 3.1.1 Beschreibung zu Use Case *1*: Drive to Destination

        |       
--------|-------
Übergeordneter elementarer Geschäftsprozess: | Drive to Destination
Ziel des Use Cases: | *Robot* fährt ein *Destination* an
Umgebende Systemgrenze: | *Robot*
Vorbedingung: | Ein spezieller *Robot* wurde vom *Server* ausgewählt und sein Akkustand ist hoch genug um den Auftrag auszuführen
Nachbedingung bei erfolgreicher Ausführung: | *Robot* ist am *Destination* angekommen und meldet dies dem *Server*
Beteiligte Nutzer: | *Robot*
Auslösendes Ereignis: | *Robot* hat eine *Destination* erhalten.

Dieser Use Case wird dann benutzt, wenn ein *Robot* ein aktuelles *Destination* hat. In dieser Ausbaustufe betrachten wir lediglich das Anfahren eines *Destination*s von einem *Robot*. Der *Robot* dreht sich zunächst in die Richtung des *Destination*s und fährt so lange in Luftlinie, bis er entweder ankommt oder ein *Obstacle* erkennt. Ein konkreter Prozess zur Erkennung eines *Obstacle*ses ist eine Entwurfsentscheidung und wird daher noch nicht berücksichtigt. Wenn der *Robot* ein *Obstacle* erkennt,  dann sucht er einen guten Weg um das *Obstacle* herum. Wie er diesen Weg sucht ist auch zunächst eine Entwurfsentscheidung und noch nicht relevant. Auf diesem Weg umfährt er dann das *Obstacle* und nimmt erneut die Fahrt auf Luftlinie auf.

## Standardablauf

Schritt | Nutzer | Beschreibung der Aktivität
--------|--------|---------------------------
1		| *Robot*  | *Robot* dreht sich in Richtung aktueller *Destination*
2		| *Robot*  | *Robot* fährt geradeaus
3		| *Robot*  | *Robot* erreicht *Destination*

## Alternativer Ablauf

Schritt | Bedingung für Alternative | Beschreibung der Aktivität
--------|---------------------------|---------------------------
3		| *Robot* erkennt ein *Obstacle* zwischen auf seinem Weg zum *Destination* | *Robot* sucht sich einen Umweg um das *Obstacle*, umfährt das *Obstacle* und nimmt schließlich Standardablauf wieder auf

