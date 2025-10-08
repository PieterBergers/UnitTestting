# Oefening op mocking

Implementeer de functie MaintenanceService.findMachinesToMaintain, die een lijst van integers teruggeeft. Elk getal
stelt een machine voor die onderhoud nodig heeft.

De klasse MaintenanceService gebruikt een andere klasse van het type MachineController. De implementatie ervan zit
in een library van de fabrikant. Ze is om veiligheidsredenen niet beschikbaar voor jou, maar je kreeg wel de interface.
Wanneer je MaintenanceService in productie gaat zal het de echte implementatie gebruiken.

De functie MachineController.getMachineCount geeft aan hoeveel machines er in de fabriek staan.

De functie MachineController.getEngineTemperature geeft voor een bepaalde machine de temperatuur. Wanneer die hoger is
dan 80 (graden) heeft de machine een onderhoudsbeurt nodig om te voorkomen dat ze faalt. Is de temperatuur lager dan
20 betekent dat wellicht dat de machine niet meer werkt, en dus zeker nood heeft aan onderhoud. Deze krijgen prioriteit
boven de andere machines en dat betekent dat ze vooraan in de lijst staan. Verder staan de nummers gesorteerd van
klein naar groot.

Stel, er zijn 10 machines. Machines 3, 7 en 8 hebben een te hoge temperatuur. Machine 4 en 9 hebben een te lage
temperatuur. Het resultaat van findMachinesToMaintain is dan [4, 9, 3, 7, 8].

_Tip: Doe jezelf een plezier en probeer het eens in TDD? Begin met 1 test, implementeer dan de code voor die test, en
bouw zo verder met de tweede test, enz. Welke test zou je eerst schrijven?_