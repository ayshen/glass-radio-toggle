RadioToggles
============

Introduction
------------

RadioToggles is a bare-bones application for controlling the Wi-Fi and Bluetooth
radios on Glass. It's not intended to be a full-fledged settings application,
but rather a quick way to stop Glass from draining half its battery sucking on
the Wi-Fi overnight, which it seems to do despite having a low-performance mode
enabled by using on-head detection.

Installation
------------

To build and install RadioToggles, you will need the [Android SDK
tools](http://developer.android.com/sdk/index.html). Make sure you have
`android-14` installed as a build target.

Connect Glass to your development computer and enable debug mode from the
Settings bundle (at the far left of the Home screen; under *Device info*). This
allows you to work with Glass using `adb`.

Run `ant debug install` as usual.

Usage
-----

RadioToggles registers an intent filter to be a default responder for
`com.google.glass.action.ACTION_GO_TO_SETTINGS`, the intent action that is
normally used to start the Settings bundle. When you tap the touchpad with the
Settings bundle onscreen, Glass will spawn a chooser dialog. Swipe forward on
the touchpad to choose RadioToggles and tap to start the activity.

The RadioToggles activity has two switches: one for Wi-Fi and one for Bluetooth.
Swipe the touchpad forward or backward to choose the appropriate switch, and tap
to toggle the switch.

When you are done with the activity, swipe downward along the touchpad to finish
the activity and return to the Settings bundle overview.

Be careful not to set Glass to use RadioToggles as the default responder for the
`com.google.glass.action.ACTION_GO_TO_SETTINGS` intent! This will prevent you
from using the built-in Glass settings until you find a way to reset application
preferences!
