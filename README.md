# Food-Court
Coding club project

# Bugs
1. Guest login not working
2. You tell me dude

# Changelog
1. Alert dialogs built for signout and exit from app
2. Intents properly designed among various activities
3. Some UI changes introduced
4. Back buttons added in action bars wherever required

# What new did I learn today?
1. Shortcut trick to add a back button (to go back to parent activity) in the app bar/action bar is as follows:
  <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity" />
     
  write this piece of code inside <activity> tag in AndroidManifest.xml file to add the back button
  
2. How to build AlertDialogs
3. How to use SharedPreferences
