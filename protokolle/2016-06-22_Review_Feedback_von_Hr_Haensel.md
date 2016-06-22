# Feedback von Hr. Hänsel

- Menge der Information sollte von Analyse zu Entwurf zunehmen, nicht gleich bleiben
    + z.B. Sequenzdiagramme sind relativ wenig vertreten im Entwurf
    + z.B. Drive to Destination ist momentan in Analyse und Entwurf quasi gleich
        * bei diesem Geschäftsprozess: in Analyse max. 1 Aktivität, die intern mehrere Methodenaufrufe beinhaltet
- Der Akteur `Robot` ist kein Akteure, sondern max. ein System, das dem Server gegenüber bestimmte Use Cases erbringt. Ein Akteur wäre `RobotUnit`
- Akteur `Hospital` ist okay
- Use Cases: sollen nicht das sein, was der Akteur macht, sondern das, was das System für den Akteur macht
- "Überlegen, ob wir ein paar (essentielle) Teile aus der 0. Iteration wieder entfernen"
- **Wichtig:** Vom Lehrstuhl gegebene Interfaces nicht in eigene Komponenten (insb. **nicht in eigene Pakete**) verpacken, sondern als Interfaces nutzen. Die Verbindung dann nur im *Deployment-Diagramm* grafisch verdeutlichen
- *Konkrete Architekur:* Hospital, Robot und NetworkAccess rausnehmen
- Entwurf Abbildung auf Seite 11:
    + `ITask` und `Task` müssen ggf. "erbt von"-Beziehung zueinander haben
    + `VirtualRobot` muss ggf. `Task` enthalten
- ggf. Sequenzdiagramme zu Server ergänzen
- Großes Sequenzdiagramm von Jonathan:
    + um *Expressions* eckige Klammern
    + `yes` und `no` geht nicht in Ordnung, muss z.B. `true` und `false` als Antwort auf eine *Expression* ODER alternativ über ein *Guard* modelliert werden
    + jump back to `DriveToDestination`: Zurückspringen nicht nötig, einfach neuer Aufruf der Methode reicht
- *Deployment-Diagramme*: 
    + alle `devices` sind eigentlich `interfaces`
- Vermeiden, dass irgendwo *Deadlocks* auftreten
- rät an, mit zwei verschiedenen VP-Projekten zu arbeiten, da sich z.B. eine Analyse-Klasse stark von einer Entwurfs-Klasse unterscheidet
- Hinweis: *ChargingStation* kommuniziert nicht mit dem *Robot*, insb. erhält der Robot in der Simulationsumgebung ausschließlich über den steigenden Ladezustand ein Feedback über den Ladevorgang

# Roadmap
- Gesamtsystem ist ein *System of Systems*
- bei Entwurf schon auf gutem Weg
- viel entschlacken: 
    + Sachen, die vom Lehrstuhl gegeben sind
    + Sachen, die falschen Abstraktionsgrad enthalten
