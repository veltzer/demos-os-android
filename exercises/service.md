# Service exercise

## Phase I
Rewrite the Async exercise using an IntentService.
Whenever the user pressed "execute" send an Intent with some data to the service.
The service will conduct some long calculation.
The service, upon completion of the calculation, will display
the result of the calculation using a Notification.

## Phase II
Display the results of the calculation, upon completion, using StartActivity
from the service. This will display an activity specifically designed
to display the results of the calculation.

* This approach is quite intrusive since if the user is using some other
application then our application will interrupt his work flow.

## Phase III
What if the GUI is not there?
Use a Notification (like in Phase I) with a PendingIntent in order
to display a notification which is associated with an intent. When
the user wants to investigate he launches the intent of his own accord.
