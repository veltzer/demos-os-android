# Save and Restore state

Create an app with a single Activity and a single EditText

Save the text inside the EditText whenever the application is stopped.
Restore the text into the EditText whenever the application is started.

Try to use the right method, meaning
`OnSaveInstanceState`
`OnRestroreInstanceState`

Demonstrate that this actually works.

There are two ways to do it:
* Run your application. Fill some text into the EditText.
    Move to another application. Go back to your application.
    See that the text in the EditText is the same.
* Run your application. Fill some text into the EditText.
    Kill your application. Run your application again.
    See that the text in the EditText is the same.
