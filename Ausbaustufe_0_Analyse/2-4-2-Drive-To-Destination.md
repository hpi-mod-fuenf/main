# Beschreibung zu 2: Drive to Destination

adsf     |  asdf
---------|-----
Auslösendes Ereignis: | Ein *Robot* hat eine *Destination* erhalten.
Ergebnis: | Der *Robot* ist unter Umfahrung von womöglichen *Obstacles* zur *Destination* gefahren.
Mitwirkende: | Ein einzelner, autonomer *Robot*.

Dieser Prozess wird autonom vom *Robot* ausgeführt. Er wird genau dann ausgeführt, wenn der Roboter eine *Destination* vom Server erhalten hat, die er anfahren soll. Da der *Robot* an dieser Stelle dem Server schon bestätigt hat, dass sein Akkustand hoch genug ist, ist der einzige Sonderfall, den wir betrachten müssen, dass ein *Obstacle* auf der direkten Linie zwischen *Robot* und *Destination* liegt. Dann wird der *Robot* nach Wahl des besten Umweges das *Obstacle* umfahren und wieder die Fahrt zur *Destination* Aufnehmen.
