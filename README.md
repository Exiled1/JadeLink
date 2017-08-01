# JadeLink

This is a revamp of the regular StudentVue web application. The whole team comprises of four smaller teams. Some specific tasks for the mini-teams include working with the database, Java programming, front-end/back-end development, and creating the website itself.

Steps:

- Initialize Firebase, then actually install the sample code to work off of
- Initialize the project folder
- Start the development server
- Configure the web app manifest
- Fill out 'sw-import.js'

----------------------------------------------------------------------------------------------------------------------------------------

Initializing Firebase:

- For the first steps we actually need to initialize firebase. To do that, you need to go to the directory that contains the project and run '$ firebase init' inside of the directory that contains the project.
- After you type that, it'll ask you what features you'd actually like to install. (Features, if you will) You can choose what you'd actually like to have for it.
- You need to select the actual firebase project that you (I) created (P.S. when firebase asks about the Firebase Database rules, just choose the default "database.rules.json" file.)
- Don't configure the project as a single-page app (In other words say no for the secondary thing, the one after it asks if youd like to use it as your public directory)

After you initialize firebase, you need to navigate into the public folder (cd public)
and use the command $ bower install -p polymerlabs/note-app-elements firebase/polymerfire'
'$ cd ..'

Initializing the project folder:
You need to make sure that all of the actual important files for the project are complete, to do so you need a couple things: 'manifest.json', 'sw-import.js, and 'note-app.html'.

Here are the commands that you'll need to do this.

$ touch public/manifest.json
(Please dont copy paste the $...) (P.S. windows doesn't use the touch command, so instead, type 'type NUL >' in place of 'touch')
$ touch public/note-app.html
The actual app implementation is places as a Polymer custom element, it'll be called <note-app> in this example, which will be kept in an appropirately named HTML file

----------------------------------------------------------------------------------------------------------------------------------------

Manipulating the manifest.json file:
As a template, below is going to be a basic manifest configuration.
{
  "name": "Notes",
  "scope": "./",
  "start_url": "index.html",
  "display": "standalone",
  "orientation": "any",
  "theme_color": "#9C27B0",
  "background_color": "#9C27B0",
}
 What it means:

 name: This is the name of the app, we can pick any name we want, this one's just called notes.

 scope: The scope of the app is the directory that's considered the root of the app, the value in the example is probably what value you should use (It means to go back a directory)

 start_url: This is the URL that will be opened when the app starts. This example app only has one entry point, so its called "index.html".

 display: This dictates how the app is presented the the user when launched from the home screen. Using the value "standalone" will make the Web App look like a native app (Doesent have a browser attached) when its launched.

 theme_color: The primary theme color of the app. This is basically used to adjust the highlight color of the native OS chrome when the app launches.

 background_color: the color that's used for the splash screen as the app actually launches from a mobile devices screen (Might be useful for later)

 Other important things to the manifest are the following keywords:

 src: The path to the icon for a given scale.

 sizes: The size of the icon you're actually pointing at while using the src keyword.

 type: the mime-type for the icon source image.

---------------------------------------------------------------------------------------------------------------------------------------

Thing that we're using for the app: https://www.google.com/script/start/

How to make stuff for a web app: https://codelabs.developers.google.com/codelabs/polymer-firebase-pwa/index.html?index=..%2F..%2Findex#0

GitHub for Dummies (crash course): http://rogerdudler.github.io/git-guide/

Use this tool to quickly edit the manifest.json file: https://app-manifest.firebaseapp.com/

Lazy af way to integrate authentication w/ Firebase: https://github.com/firebase/FirebaseUI

How to embed Java into HTML: 
https://stackoverflow.com/questions/10964693/java-embedding-into-html

https://stackoverflow.com/questions/985754/how-to-deploy-a-java-applet-for-todays-browsers-applet-embed-object

Transcompiling Java into Javascript: http://www.gwtproject.org/overview.html
