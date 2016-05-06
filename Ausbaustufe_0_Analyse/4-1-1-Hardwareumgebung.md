#### Server
Es existiert ein zentraler *Server*. Dieser *Server* verfügt über ausreichende Ressourcen und ist in der Lage direkt mit den Transportvehikeln zu kommunizieren.

##### IServerCore
Der *Server* verfügt über einen zentralen Hauptprozessor, über den auf alle weiteren Komponenten zugegriffen werden kann. Dies wird der Einfachheit halber angenommen.

##### IServerMessageHandler
Mit der Kommunikationseinheit *IServerMessageHandler* kann der *Server* Nachrichten direkt an einen *Robot* senden. Der Einfachheit wegen wird angenommen, die Komponente ist stets empfangsbereit und die dahinterstehende Infrastruktur zur Übertragung von Nachrichten stabil.

#### Robot
Das Transportvehikel *Robot* erfüllt Grundfunktionalitäten wie das Anfahren von Zielen, das Umfahren von Hindernissen und das Laden des Akkumulators. Nachfolgend werden die zentralen Hardwarekomponenten des *Robots* beschrieben.

##### IRobotCore
Der *Robot* verfügt über einen zentralen Hauptprozessor, über den auf alle weiteren Komponenten zugegriffen werden kann. Dies wird der Einfachheit halber angenommen.

##### IRobotMessageHandler
Mit der Kommunikationseinheit *IRobotMessageHandler* kann der *Robot* Nachrichten, die vom zentralen *Server* für das Vehikel abgesetzt wurden, direkt empfangen.

##### IRobotEngine
Als Antrieb nutzt das Transportvehikel einen omnidirektionalen Antrieb mit 3 Motoren, über welchen es sich vorwärts, nach rechts, nach links oder durch Drehen um die eigene Achse bewegen lässt. Der Antrieb ermöglich eine Fahrt in verschiedenen Geschwindigkeiten, wobei eine nicht näher spezifizierte Grenze nicht überschritten werden kann.

##### IBattery
Jeder *Robot* verfügt über einen Akkumulator, der zur Energieversorgung dient. Eine ausreichende Ladung des Akkumulators ist deshalb zum Betrieb des *Robot* unbedingt erforderlich. Der Akkumulator hat eine maximale Ladekapazität und kann über einen *Charger* geladen werden. Die genaue Beschaffenheit des Akkumulators ist nicht bekannt.

##### INorthStar
Die Komponente *INorthStar* kann ähnlich einem GPS-Modul die Position des *Robots* feststellen. Hierbei ist die Komponente in der Lage, die Koordinaten der Position in einem zweidimensionalen Koodinatensystem und die aktuelle Ausrichtung des Vehikels zu ermitteln.

##### IRSensorDistance
Das Transportvehikel verfügt über 9 Infarotdistanzsensoren, die an der kreisförmigen Außenwand des Vehikels im Abstand von jeweils 40° angeordnet sind. Über sie ist die Feststellung der Entfernung des Vehikels von allen bewegten und unbewegten Objekten in der Umgebung möglich.

##### IBumper
Bei einer Kollision des *Robots* mit einem anderen Objekt wird dieses Ereignis über die Sensorik eine Kollisionserkennung, worauf weitere Schritte eingeleitet werden können.

#### Charger
Es existieren Ladestationen, über die sich die *IBattery* der *Robots* vollständig laden lässt. Eine Ladestation ist dabei genau einem *Robot* zugeordnet. Zum Laden muss ein *Robot* seine Ladestation anfahren, worauf die Ladung sofort beginnt. Jede Ladestation verfügt über eine genaue Position.
