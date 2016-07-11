# Entwurf:

- [ ] Aktualisierte Sequenz-Diagramme (2.) und aktualisiertes ITask als SVG exportieren
- [ ] 8.: Diagramme an veränderte Use Cases anpassen
- [x] OCL shit
- [x] "Select best match"-Aktivitätsdiagramm einfügen @Baschdl 
- [x] "Enters" einfügen
- [ ] Aktivitätsdiagramm driveAroundObstacle @josauder 
- [ ] Bildunterschriften @bakoe @Fluepke 
- [ ] Erklärung Netzwerkkomponenten/ Kommunikation (Remote Procedure Calls) ("NetworkAccess implementiert IWlanAdapter und MessageHandler")
- [x] Diagramm zu Queue
- [x] "VirtualRobots" auf dem Server verwenden, Methoden können nicht direkt auf der "RobotUnit" aufgerufen werden
- [ ] Methoden der Interfaces irgendwo verwenden
- [x] Sequenzdiagramme für IWlanAdapter und MessageHandler modellieren (RPC)
- [x] Benötigen wir wirklich die taskDistribution?
- [x] evt. kollidiert das "Select Best Match"-Sequenzdiagramm und die Modellierung bei den Paketdetails
- [x] Return void bei Interfaces
- Diagramme
  - [x] receiveMessage
  - [x] RPC
  - [x] handleArrival
  - queue @jcremerius @jonashering 
     - [x] add
     - [x] addTopOfType
     - [x] poll
     - [x] remove
  - [x] TaskPriorityQueue
  - [x] OCL
  - [x] SelectBestMatch
- [x] Klassendiagramm layouten
- [x] Fehlen unter "3.2 Interfaces" noch die Interfaces IRepair und ...? @Fluepke @jcremerius 
- [x] "Interaktion bei Ausführung von Receive Order & Cancel Order" Enthält, dass die Warteliste beim Krankentransport nur von theoretischer Natur ist, aber das betrachte ich als falsch.
- [ ] ChooseRobot überarbeiten (Server weiß jetzt, welche VirtualRobotUnit momentan welchen Task ausführt)
- [ ] Initialisierungssequenz (IMessageHandler, IBumperHandler, weitere?)
- [ ] Aktivitätsdiagramm zur Queue aktualisieren: Fall hinzufügen, dass ein Robot gewählt wird, der bereits einen Taxi-Task auswählt. Dann muss ein neuer Task (aktualisierte Destinations!) erstellt werden und der Queue hinzugefügt werden. 
- [ ] Beschreibung zu Figure 4 und 5
- [x] Sequenzdiagramme Kapitel 2 überprüfen+korrigieren
- [x] Datentyp von Task.type von `String` zu `enum` (hospital, taxi) ändern
- [ ] Beschreibungen zu aktualisierten Sequenzdiagrammen in 2. Interaktion der Komponenten aktualisieren (Wichtig: "Unser sendQueueIndex() ruft bei Taxi-Aufträgen intern die gegebene reportNumberInList()-Methode auf")
- [ ] Möglichkeit für "cancel order" einbauen
- [ ] Methoden des AppContainers etc. einbauen
- [ ] Im Text daruf hinweisen: Es gibt höchstens so viele Krankenhaustransporte wie Robots, inbesondere: Krankenhaustransporte werden immer sofort ausgeführt und können nicht in die Warteliste


## nachträgliche Änderungen Analyse:

- [ ] "Obstacle" soll laut Max/ Hänsel nicht modelliert werden
- [ ] Datentypen (Position, Destination) ebenso nicht
- [ ] Use-Case-Namen vielleicht irgendwo erklären
- [ ] "Robot" und "RobotUnit" konsistenter
- [ ] Annahme "Es gibt mind. einen Roboter"
- [ ] "Figure 2: Illustration von 1: Choose Robot durch Aktivitätendiagramm" Swimlane mit Plural "Robots" bezeichnen, da dort nicht nur ein Robot angefragt wird
- [ ] Typo im ersten Teil @bakoe 
- [ ] Annahme "Es kann mehr Krankentransporte als Roboter geben"

## Verbesserungen nach dem Review übernehmen
- [ ] Abstrakte Architektur anpassen @dschwenkert 
- [ ] "Take Patient To Hospital"-Sequenzdiagramm: Referenz (?) und evt. gestrichelte Linie verwenden @jakobbraun @djdj10x10 
- [ ] "Select Best Match"-Sequenzdiagramm alternatives vertauschen @jakobbraun @djdj10x10 
- [x] Konkrete Architektur der RobotSoftware anpassen, richtiger Name @Fluepke @jcremerius 
- [x] HardwareInterfaces aus Paketstruktur löschen @josauder @bakoe @baschdl
- [ ] Kapitel 7: mehr Diagramme
- [ ] komische Lebenslinien, auf Parallelität/ Deadlocks achten
- [ ] "Interaktion bei Ausführung von Use Case 4 – Charging" steht irgendwas mit Kommunikation von RobotUnit und ChargingStation
- [x] Kapitel 9: Interface "IWlanAdapter" @jonashering 

# Proofread

- [ ] Abgeschnittene Texte in Diagrammen
- [ ] `TaskSystem` zu `TaskPriorityQueue`
- [ ] `RobotControlSystem` zu `VirtualRobotManager`
- [ ] `RobotUnit` verwenden, nicht `Robot`
