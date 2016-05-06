# 3.1.3 Beschreibung zu Use Case *3*: Charging
Jedem Robot wird, laut Aufgabenstellung, eine feste Ladestation zugewiesen. Der Robot fährt vollständig autonom diese Ladestation an. Daher ist keine Kommunikation mit dem Server notwendig.
### Charaktersierende Informationen
| asdfasdf                                    | asdfasdf                                                             |
|---------------------------------------------|----------------------------------------------------------------------|
| Übergeordneter elementarer Geschäftsprozess | Drive to destination                                                 |
| Ziel des Use-Cases                          | Ziel ist es, dem Robot zu ermöglichen seine Ladestation anzufahren |
| Umgebende Systemgrenze                      | Robot                                                                |
| Nachbedingung bei erfolgreicher Ausführung  | Der Robot muss sein vorgegebenes Ziel erreichen                    |
| Beteiligte Nutzer                           | Robot                                                                |
| Auslösendes Ereignis                        | Robot erreicht Ziel (Use-Case)                                     |

### Szenario für den Standardablauf
| Schritt |  Nutzer |           Beschreibung der Aktivität           |
|:-------:|:-------:|:----------------------------------------------:|
| 1.      | Robot | Robot erreicht Ziel                          |
| 2.      | Robot | Robot fährt zur Ladestation                  |
| 3.      | Robot | Robot erreicht Ladestation und lädt sich auf |
| 4.      | Robot | Robot erhält neues Ziel und fährt dorthin    |
