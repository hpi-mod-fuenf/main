#### Server
Auf dem *Server* läuft, da nicht anders angegeben, ein Standard-Betriebssystem. Darauf läuft eine Laufzeitumgebung, die die benötigten Methoden zur Kommunikation mit den Robots bereitstellt. Die wichtigste (und einzige bisher spezifizierte) Methode, ist die CallRobot() Methode um einen *Robot* anzurufen und einen Datenaustausch herzustellen.

##### IServerMessageHandler
Der *IServerMessageHandler* ist die Komponente, die ausgehende Informationen des *Servers* für einen *Robot* versendet. Das Verhalten und die enthaltenen Methoden sind dabei allerdings nicht näher spezifiziert.

#### Robot
Nachfolgend werden die zentralen Softwareschnittstellen des *Robots* beschrieben.

##### IRobotCore
Auf der zentralen Recheneinheit des *Robots*, dem *IRobotCore*, läuft eine JavaRuntimeEnvironment, in der sich die gesamte Steuerung und die Verwendung der Komponenten und Schnittstellen abspielt. Die einzelnen Komponenten mit ihren Methoden werden im folgenden näher erläutert.

##### IRSensorDistance
Die *IRSensorDistance* Komponente stellt drei Methoden bereit, mit denen die Distanz  und der Winkel des entdeckten Objekts und der an der Entdeckung beteiligte Infrarotsensor erfasst und in Arrays gespeichert werden.

##### IDistanceSensor
Die besagten Arrays kann der *IDistanceSensor* auslesen. Er hat dazu ebenfalls drei Methoden. getIRDistances() gibt ein Array mit allen erfassten Objekten zurück, getIRDistancesInRange() gibt ebenfalls ein Array zurück, das allerdings nur die Objekte in einem gewissen Abstand enthält und getNearestIRDistances() gibt nur das nächste Objekt zurück.

##### INorthStar
Die Komponente *INorthStar* ist für die Positionierung zuständig und greift dabei auf ein Device zur Standortbestimmung zurück. Sie hat zwei Methoden. Eine liest die aktuelle Position aus, die andere die aktuelle Ausrichtung. Die Position besteht dabei aus zwei float-Werten, einer x- und einer y-Koordinate.

##### IRobotMessageHandler
Der *IRobotMessageHandler* ist die Komponente, die eintreffende Anrufe des *Servers* verarbeitet. Das Verhalten und die enthaltenen Methoden sind dabei allerdings nicht näher spezifiziert. So kann man davon ausgehen, dass jegliche Methoden der anderen Komponenten über den *IRobotCore* aufgerufen und die Ergebnisse an die *IMessageHandler* Komponente übergeben werden können, damit diese die Informationen auf Anfrage des *Servers* beschaffen und übermitteln kann.

##### IBumperHandler
Die *IBumperHandler* ist die Komponente zum Umgang mit Zusammenstößen. Die Kollisionserkennung *IBumper* registriert einen Aufprall und die *IBumperHandler* Komponente stellt zwei Methoden zum Umgang mit dem Aufprall bereit.

##### IDrive
Die Bewegungssteuerung des Robots heißt *IDrive*. Sie stellt vier Methoden bereit. Die Methoden driveToPosition() und driveToPositionCautiously() erwarten beide eine Position, eine Geschwindigkeit und einen ArrivalHandler, der eine Methode zur Meldung aufruft, wenn der *Robot* am Ziel angekommen ist. Die Methoden sind beide dafür da, ein gegebenes Ziel anzufahren, wobei bei der Zweiten die Höchstgeschwindigkeit geringer ist. Die höchstgeschwindigkeit für Cautiously, Regular und Fast Methoden stellt die *IDrive* Komponente bereit, wobei Cautiously ≤ Regular ≤ Fast gilt.
Die anderen beiden Methoden, drive() und driveCautiously() unterscheiden sich ebenfalls nur in der Höchstgeschwindigkeit und ermöglichen ein manuelles Fahren. Dabei erwarten sie die Drehung des *Robots* als float-Wert sowie die Vorwärts- und die Seitwärtsgeschwindigkeit, ebenfalls als float-Wert.

##### IBattery
Bei *IBattery* handelt es sich um die Akkusteuerung des *Robots*. Sie stellt zwei Methoden bereit. getBatteryLevel() gibt den aktuellen Akkuladestand als float-Wert zurück, getChargingPosition() gibt die Position des zugeordneten *Chargers* zurück.
