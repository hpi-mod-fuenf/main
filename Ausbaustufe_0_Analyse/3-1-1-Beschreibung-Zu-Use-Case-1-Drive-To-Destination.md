# 3.1.1 Beschreibung zu Use Case `1`: Drive to Destination

 | 
-|-
Übergeordneter elementarer Geschäftsprozess: | Drive to Destination
Ziel des Use Cases: | `Robot` fährt an ein Ziel an
Umgebende Systemgrenze: | `Robot`
Vorbedingung: | Ein spezieller `Robot` wurde vom Server ausgewählt und sein Akkustand ist hoch genug um den Auftrag auszuführen
Nachbedingung bei erfolgreicher Ausführung: | `Robot` ist am Ziel angekommen und meldet dies dem `Server`
Beteiligte Nutzer: | `Robot`
Auslösendes Ereignis: | `Robot` hat eine `Destination` erhalten.

Dieser Use Case wird dann benutzt, wenn ein `Robot` ein aktuelles Ziel hat.
In dieser Ausbaustufe betrachten wir lediglich das Anfahren eines Ziels von einem Roboter. 
Der Roboter dreht sich zunächst in die Richtung des Ziels und fährt so lange in Luftlinie, 
bis er entweder ankommt oder ein Hindernis erkennt. Ein konkreter Prozess zur Erkennung 
eines Hindernisses ist eine Entwurfsentscheidung und wird daher noch nicht berücksichtigt.
Wenn der `Robot` ein Hindernis erkennt,  dann sucht er einen guten Weg um das Hindernis herum.
Wie er diesen Weg sucht ist auch zunächst eine Entwurfsentscheidung und noch nicht relevant.
Auf diesem Weg umfährt er dann das Hindernis und nimmt erneut die Fahrt auf Luftlinie auf.

## Standardablauf

Schritt | Nutzer | Beschreibung der Aktivität
--------|--------|---------------------------
1		| Robot  | `Robot` dreht sich in Richtung aktueller `Destination`
2		| Robot  | `Robot` fährt geradeaus
3		| Robot  | `Robot` erreicht Ziel

## Alternativer Ablauf

Schritt | Bedingung für Alternative | Beschreibung der Aktivität
--------|---------------------------|---------------------------
3		| Robot erkennt ein Hindernis zwischen auf seinem Weg zum Ziel | `Robot` sucht sich einen Umweg um das Hindernis, umfährt das Hindernis und nimmt schließlich Standardablauf wieder auf

