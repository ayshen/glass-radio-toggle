RadioToggles
============

Introduction
------------

RadioToggles is a bare-bones application for controlling the Wi-Fi and Bluetooth
radios on Glass. It's not intended to be a full-fledged settings application,
but rather a quick way to stop Glass from draining half its battery sucking on
the Wi-Fi overnight.

Installation
------------

To build and install RadioToggles, you will need the [Android SDK
tools](http://developer.android.com/sdk/index.html) and the [Glass Development
Kit](http://developers.google.com/glass/develop/gdk/index).

Connect Glass to your development computer and enable debug mode from the
Settings bundle (at the far left of the Home screen; under *Device info*).
Run `ant debug install` as usual.

Usage
-----

RadioToggles now uses GDK voice triggers. The commands that it recognizes are

* `enable Wifi`
* `disable Wifi`
* `enable Bluetooth`
* `disable Bluetooth`
* `go into airplane mode`
* `disable airplane mode`

Originally the command prefixes were `turn on` and `turn off`, but Glass
occasionally has difficulty distinguishing between `off` and `on` and doesn't
behave as expected.
