# Android Activity Lifecycle & Bidirectional Intent App

Welcome to the **Android Activity Lifecycle & Bidirectional Intent App!**

This Android application demonstrates how the Activity Lifecycle works in practice, along with bidirectional data communication between two screens (`MainActivity` and `SecondActivity`) using explicit intents and the modern `ActivityResultLauncher` API.

## What Does This App Do?

The application consists of two simple screens that demonstrate two fundamental Android development concepts:

### 1. Bidirectional Data Passing

- On the main screen (`MainActivity`), users can enter a message and send it to the second screen (`SecondActivity`) using an explicit intent.
- The second screen receives and displays the incoming message.
- Users can then enter a reply and send it back to the main screen.
- When the reply button is clicked, the response is returned using `setResult()`, and `finish()` closes the second activity.
- The main screen receives the reply through `ActivityResultLauncher` and updates its user interface accordingly.

### 2. Android Activity Lifecycle Tracking

Both activities implement logging for the seven standard Activity Lifecycle callback methods:

- `onCreate()`
- `onStart()`
- `onResume()`
- `onPause()`
- `onStop()`
- `onDestroy()`
- `onRestart()`

All lifecycle events are displayed in Android Studio's Logcat console using the tag `LifecycleCallback`, making it easy to monitor activity state transitions during app navigation.

## Project Structure

**Package Name:** `com.example.lifecyclebidirectionalapp`

**Activities:**

- `MainActivity.java` — The main entry point of the application. It handles sending messages to the second activity and receiving replies.
- `SecondActivity.java` — Receives messages from the main activity, displays them, and sends replies back.

**Layout Files:**

- `activity_main.xml` — Contains a vertically arranged layout with a message input field, a send button, and a TextView for displaying the returned response.
- `activity_second.xml` — Contains a TextView for displaying the received message, an input field for entering a reply, and a button for returning the response.

## Core Implementation Details

### 1. MainActivity.java

The `MainActivity` handles the following operations:

- Creates an explicit intent to send data to `SecondActivity`.
- Uses `putExtra()` to attach the user's message to the intent.
- Registers an `ActivityResultLauncher` to receive data returned from the second activity.
- Checks the result code (`RESULT_OK`) before processing the returned message.
- Updates the user interface with the received response.
- Logs Activity Lifecycle callbacks to Logcat.

### 2. SecondActivity.java

The `SecondActivity` performs the following operations:

- Receives the message through `getIntent().getStringExtra()`.
- Displays the received message on the screen.
- Allows users to enter a reply.
- Creates a return intent containing the reply message.
- Uses `setResult(RESULT_OK, returnIntent)` to send the response back.
- Calls `finish()` to close the second activity and return to `MainActivity`.
- Logs its Activity Lifecycle callbacks to Logcat.

## How to View Activity Lifecycle Logs

Follow these steps to monitor the lifecycle events:

1. Connect a physical Android device or launch an emulator through Android Studio.
2. Run the application.
3. Open the **Logcat** window in Android Studio.
4. Enter `tag:LifecycleCallback` in the Logcat search field.
5. Interact with the application by navigating between activities, pressing the Home or Back button, or rotating the device.
6. Observe the lifecycle callback messages in real time.

**Note:** Lifecycle callback sequences may vary depending on user interactions, Android system behavior, and configuration changes. For example, rotating the device may cause an activity to be recreated depending on its configuration.

## Conclusion

This project provides a practical demonstration of Android Activity Lifecycle management and bidirectional data communication using explicit intents and `ActivityResultLauncher`. It helps developers understand how activities interact, exchange information, and respond to different lifecycle events.
